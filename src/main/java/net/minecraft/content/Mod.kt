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
    @SerializedName("screenshots")
    private val screenshotUrls: List<String>,
    val downloads: List<Download>,
    @SerializedName("related_owned_videos")
    val relatedOwnedVideos: List<OwnedVideo> = emptyList(),
    @SerializedName("related_external_videos")
    val relatedExternalVideos: List<ExternalVideo> = emptyList()
) {
    /**
     * Screenshots for this mod, represented by URLs with human-friendly titles.
     */
    val screenshots: List<Screenshot>
        get() = screenshotUrls.map { Screenshot(it) }

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
}
