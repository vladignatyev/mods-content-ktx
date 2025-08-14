package net.minecraft.content

import java.util.Locale

/**
 * Represents a screenshot URL with localized headlines.
 */
data class Screenshot(
    val url: String,
    val headlines: Map<String, String>
) {
    /**
     * Returns the headline for the given [locale], falling back to the language code.
     */
    fun headlineFor(locale: Locale): String? {
        val tag = locale.toLanguageTag()
        return headlines[tag] ?: headlines[locale.language] ?: headlines["en"]
    }
}

