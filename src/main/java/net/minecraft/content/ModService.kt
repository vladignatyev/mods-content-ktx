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
     * a list of [Mod] objects.
     */
    @Throws(Exception::class)
    fun load(url: String): List<Mod> {
        val connection = URL(url).openConnection() as HttpURLConnection
        connection.requestMethod = "GET"
        connection.connect()
        connection.inputStream.bufferedReader().use { reader ->
            val json = reader.readText()
            val type = object : TypeToken<List<Mod>>() {}.type
            return gson.fromJson(json, type)
        }
    }
}
