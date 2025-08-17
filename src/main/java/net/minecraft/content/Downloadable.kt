package net.minecraft.content

import com.google.gson.annotations.SerializedName
import java.util.Locale

/**
 * Represents a downloadable resource for a mod.
 */
data class Downloadable(
    val name: LocalizedString,
    val description: LocalizedString,
    @SerializedName("file_url") val fileUrl: FileUrl,
    @SerializedName("file_size_md") val fileSizeMd: Int
) {
    /** Returns the label for the given [locale]. */
    fun labelFor(locale: Locale): String {
        val tag = locale.toLanguageTag()
        return name.localization[tag] ?: name.localization[locale.language] ?: name.title
    }

    /** Returns the description for the given [locale]. */
    fun descriptionFor(locale: Locale): String {
        val tag = locale.toLanguageTag()
        return description.localization[tag] ?: description.localization[locale.language] ?: description.title
    }
}
