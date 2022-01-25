package com.example.data.storage

import android.content.Context
import com.example.data.models.JsonToKotlin
import com.google.gson.Gson
import java.io.InputStream

class AssetsStorageImpl(private val context: Context) : AssetsStorage {

    override suspend fun getAll(): JsonToKotlin {
        return get()

    }

    private fun loadJSON(context: Context): String? {
        var input: InputStream? = null
        val jsonString: String
        try {
            input = context.assets.open("pins.json")
            val size = input.available()
            val buffer = ByteArray(size)
            input.read(buffer)
            jsonString = String(buffer)
            return jsonString
        } catch (e: Exception) {
        } finally {
            input?.close()
        }
        return null
    }

    private fun get(): JsonToKotlin {
        val jsonString = loadJSON(context)
        return Gson().fromJson(jsonString, JsonToKotlin::class.java)
    }
}