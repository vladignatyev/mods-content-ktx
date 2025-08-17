package net.minecraft.content

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.HttpURLConnection
import java.net.URL

/**
 * Service for loading mod lists from a remote JSON endpoint.
 */
object ModService {
    private val gson = Gson()

    /**
     * Downloads the JSON list from the given [url] and parses it into
     * a [ModList].
     */
    @Throws(Exception::class)
    fun load(url: String): ModList {
        val connection = URL(url).openConnection() as HttpURLConnection
        connection.requestMethod = "GET"
        return try {
            connection.connect()
            connection.inputStream.bufferedReader().use { reader ->
                val json = reader.readText()
                val type = object : TypeToken<ModList>() {}.type
                gson.fromJson(json, type)
            }
        } finally {
            connection.disconnect()
        }
    }
}
