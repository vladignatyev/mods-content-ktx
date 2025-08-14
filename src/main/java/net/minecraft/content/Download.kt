package net.minecraft.content

import com.google.gson.annotations.SerializedName
import java.util.Locale

/**
 * Represents a downloadable resource for a mod.
 */
data class Download(
    @SerializedName("file_url") val file: FileUrl,
    @SerializedName("name") val labels: Map<String, String>,
    @SerializedName("description") val descriptions: Map<String, String>,
    @SerializedName("file_size_md") val fileSizeMd: Int
) {
    /**
     * Direct URL to the downloadable file, if provided.
     */
    val url: String?
        get() = file.externalUrl

    /**
     * Returns the label for the given [locale]. It first checks the full locale tag (e.g. `en-US`) and then falls back to the language code.
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
        return descriptions[tag] ?: descriptions[locale.language]
    }
}
