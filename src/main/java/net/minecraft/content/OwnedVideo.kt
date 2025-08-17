package net.minecraft.content

import com.google.gson.annotations.SerializedName
import java.util.Locale

/**
 * Represents a video owned by the content team, with a localized call-to-action title.
 */
data class OwnedVideo(
    @SerializedName("cta_title") val ctaTitle: LocalizedString,
    @SerializedName("youtube_url") val youtubeUrl: String
) {
    /** Returns the call-to-action title for the given [locale]. */
    fun ctaTitleFor(locale: Locale): String {
        val tag = locale.toLanguageTag()
        return ctaTitle.localization[tag] ?: ctaTitle.localization[locale.language] ?: ctaTitle.title
    }
}
