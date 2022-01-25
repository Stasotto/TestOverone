package com.example.testoverone.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.DeleteAllFromDBUseCase
import com.example.domain.usecase.GetAllPointsFromDBUseCase
import com.example.domain.usecase.GetDataFromJsonUseCase
import com.example.domain.usecase.SavePointToDBUseCase
import com.example.testoverone.presentation.models.Point
import com.example.testoverone.presentation.toPoint
import com.example.testoverone.presentation.toPointDomain
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class FilterActivityViewModel(
    private val useCase: GetDataFromJsonUseCase,
    private val getAllDataFromDB: GetAllPointsFromDBUseCase,
    private val deletePointFromDB: DeleteAllFromDBUseCase,
    private val savePointToDb: SavePointToDBUseCase
) : ViewModel() {

    private val _dataForListView = MutableLiveData<List<Point>>()
    val dataForListView: LiveData<List<Point>> get() = _dataForListView

    init {
        load()
    }

    fun updateData(position: Int) {
        val item = _dataForListView.value?.get(position) ?: return
        val listData = _dataForListView.value?.toMutableList() ?: return
        listData[position] = item.copy(isChecked = !item.isChecked)
        _dataForListView.value = listData
    }

    fun savePoint(points: List<Point>) {
        viewModelScope.launch {
            points.map {point ->
                savePointToDb.execute(point.toPointDomain())
            }
        }

    }

    private fun load() {
        viewModelScope.launch {
            val resultAssets = async {
                useCase.execute().map { pointDomain ->
                    pointDomain.toPoint()
                }
            }
            val resultDB = async {
                getAllDataFromDB.execute().map { pointDomain ->
                    pointDomain.toPoint()
                }
            }
            val resAss = resultAssets.await()
            val resDB = resultDB.await()

            mixePoints(resAss,resDB)
        }

    }

    private fun mixePoints(assPoints: List<Point>?, pointsRoom: List<Point>?) {
        val assetsPoints = assPoints?.toMutableList() ?: return
        assetsPoints.forEachIndexed { index, assPoint ->
            pointsRoom?.forEach { pointRoom ->
                if (assPoint.id == pointRoom.id) {
                    assetsPoints[index] = pointRoom
                }
            }
        }
        _dataForListView.value = assetsPoints
    }


}