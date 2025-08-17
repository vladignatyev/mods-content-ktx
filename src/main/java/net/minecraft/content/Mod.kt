package net.minecraft.content

import com.google.gson.annotations.SerializedName
import java.util.Locale

/**
 * Represents a single mod with localized data and rich metadata.
 */
data class Mod(
    @SerializedName("date_published") val datePublished: String?,
    @SerializedName("unique_id") val id: String,
    val title: LocalizedString,
    val description: LocalizedString?,
    val instructions: LocalizedString?,
    val version: String?,
    val author: Author,
    @SerializedName("official_support_url") val officialSupportUrl: Url,
    @SerializedName("downloadable_urls") val downloads: List<Downloadable>,
    val tags: String,
    @SerializedName("supported_versions") val supportedVersions: List<String>?,
    val reactions: List<Reaction>,
    @SerializedName("wide_picture") val widePicture: FileUrl?,
    @SerializedName("square_picture") val squarePicture: FileUrl?,
    @SerializedName("small_square") val smallSquare: FileUrl?,
    val screenshots: List<Picture>?,
    @SerializedName("crafting_recipes") val craftingRecipes: List<Picture>?,
    @SerializedName("related_owned_videos") val relatedOwnedVideos: List<OwnedVideo>?,
    @SerializedName("related_external_videos") val relatedExternalVideos: List<ExternalVideo>?,
    @SerializedName("generated_at") val generatedAt: String?
) {
    /**
     * Returns the title label for the given [locale]. It first checks the full
     * locale tag (e.g. `en-US`) and then falls back to the language code.
     */
    fun labelFor(locale: Locale): String {
        val tag = locale.toLanguageTag()
        return title.localization[tag] ?: title.localization[locale.language] ?: title.title
    }

    /** Returns the description for the given [locale]. */
    fun descriptionFor(locale: Locale): String? {
        val tag = locale.toLanguageTag()
        val loc = description ?: return null
        return loc.localization[tag] ?: loc.localization[locale.language] ?: loc.title
    }

    /** Returns the instructions for the given [locale]. */
    fun instructionsFor(locale: Locale): String? {
        val tag = locale.toLanguageTag()
        val instr = instructions ?: return null
        return instr.localization[tag] ?: instr.localization[locale.language] ?: instr.title
    }
}
