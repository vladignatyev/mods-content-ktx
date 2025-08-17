package net.minecraft.content

import com.google.gson.annotations.SerializedName

/**
 * Container for a list of [Mod] objects along with generation metadata.
 */
data class ModList(
    @SerializedName("generated_at")
    val generatedAt: String? = null,
    val mods: List<Mod>
)
