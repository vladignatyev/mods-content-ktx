package net.minecraft.content

import com.google.gson.annotations.SerializedName
import java.util.Locale

/**
 * Represents a video owned by the content team, with a localized call-to-action title.
 */
data class OwnedVideo(
    @SerializedName("cta_title") val ctaTitle: Map<String, String>,
    @SerializedName("youtube_url") val youtubeUrl: String
) {
    /**
     * Returns the call-to-action title for the given [locale].
     */
    fun ctaTitleFor(locale: Locale): String? {
        val tag = locale.toLanguageTag()
        return ctaTitle[tag] ?: ctaTitle[locale.language]
    }
}
