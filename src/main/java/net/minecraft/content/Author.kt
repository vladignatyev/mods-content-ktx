package net.minecraft.content

import com.google.gson.annotations.SerializedName

/**
 * Information about the mod author.
 */
data class Author(
    @SerializedName("internal_id") val id: String,
    val title: String,
    @SerializedName("picture_url") val pictureUrl: FileUrl?,
    @SerializedName("official_url") val officialUrl: Url?
)
