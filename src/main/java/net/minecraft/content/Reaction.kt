package net.minecraft.content

import com.google.gson.annotations.SerializedName

/**
 * Represents a reaction entry with an emoji and its count.
 */
data class Reaction(
    @SerializedName("smile_str") val smile: String,
    val count: Int
)
