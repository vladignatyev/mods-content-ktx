package net.minecraft.content

import com.google.gson.annotations.SerializedName
import java.util.Locale

/**
 * Represents an image URL with localized headlines.
 */
data class Picture(
    val url: String,
    @SerializedName("headline") val headline: Map<String, String>
) {
    /** Returns the headline for the given [locale]. */
    fun headlineFor(locale: Locale): String? {
        val tag = locale.toLanguageTag()
        return headline[tag] ?: headline[locale.language] ?: headline["en"]
    }
}
