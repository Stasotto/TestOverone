package com.example.data

import com.example.data.storage.AssetsStorage
import com.example.data.storage.RoomStorage
import com.example.domain.models.PointDomain
import com.example.domain.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RepositoryImpl(
    private val assetsStorage: AssetsStorage,
    private val roomStorage: RoomStorage
) : Repository {

    override suspend fun getAllData(): List<PointDomain> {
        return withContext(Dispatchers.IO) {
            assetsStorage.getAll().pins.map { pin ->
                pin.toPointEntity().toPointDomain()
            }
        }
    }

    override suspend fun getAllFromDB(): List<PointDomain> {
        return withContext(Dispatchers.IO) {
            roomStorage.getAll().map { pointEntity ->
                pointEntity.toPointDomain()
            }
        }
    }

    override suspend fun deleteFromDB() {
        withContext(Dispatchers.IO) {
            roomStorage.delete()
        }
    }

    override suspend fun saveInDB(pointDomain: PointDomain) {
        withContext(Dispatchers.IO) {
            roomStorage.save(pointDomain.toPointEntity())
        }

    }

}