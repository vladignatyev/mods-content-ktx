package net.minecraft.content

import com.google.gson.annotations.SerializedName

/**
 * Wrapper for an HTTPS URL.
 */
data class Url(
    @SerializedName("https_url") val httpsUrl: String
)
