package net.minecraft.content

import com.google.gson.annotations.SerializedName
import java.util.Locale

/**
 * Represents a single mod with localized data and rich metadata.
 */
data class Mod(
    val id: String,
    val labels: Map<String, String>,
    val description: Map<String, String>,
    val author: Author,
    val screenshots: List<Screenshot>,
    val downloads: List<Download>,
    val tags: Map<String, String>,
    @SerializedName("related_owned_videos")
    val relatedOwnedVideos: List<OwnedVideo> = emptyList(),
    @SerializedName("related_external_videos")
    val relatedExternalVideos: List<ExternalVideo> = emptyList()
) {
    /**
     * Returns the title label for the given [locale]. It first checks the full
     * locale tag (e.g. `en-US`) and then falls back to the language code.
     */
    fun labelFor(locale: Locale): String? {
        val tag = locale.toLanguageTag()
        return labels[tag] ?: labels[locale.language]
    }

    /**
     * Returns the description for the given [locale].
     */
    fun descriptionFor(locale: Locale): String? {
        val tag = locale.toLanguageTag()
        return description[tag] ?: description[locale.language]
    }

    /**
     * Returns the tags string for the given [locale].
     */
    fun tagsFor(locale: Locale): String? {
        val tag = locale.toLanguageTag()
        return tags[tag] ?: tags[locale.language] ?: tags["en"]
    }
}

