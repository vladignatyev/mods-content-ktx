package net.minecraft.content

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

fun main() {
    val json = """
        {
          "generated_at": "2024-01-01T00:00:00Z",
          "mods": [
            {
              "date_published": "2024-01-01",
              "unique_id": "test-mod",
              "title": {"title": "Test Mod", "localization": {}},
              "description": null,
              "instructions": null,
              "version": "1.0",
              "author": {
                "internal_id": "author1",
                "title": "Author 1",
                "picture_url": null,
                "official_url": null
              },
              "official_support_url": {"https_url": "https://example.com"},
              "downloadable_urls": [],
              "tags": "",
              "supported_versions": null,
              "reactions": [],
              "wide_picture": null,
              "square_picture": null,
              "small_square": null,
              "screenshots": null,
              "crafting_recipes": null,
              "related_owned_videos": null,
              "related_external_videos": null,
              "generated_at": "2024-01-01T00:00:00Z"
            }
          ]
        }
    """.trimIndent()

    val gson = Gson()
    val type = object : TypeToken<ModList>() {}.type
    val modList: ModList = gson.fromJson(json, type)
    check(modList.generatedAt == "2024-01-01T00:00:00Z")
    check(modList.mods.first().id == "test-mod")
    check(modList.mods.first().generatedAt == "2024-01-01T00:00:00Z")
}
