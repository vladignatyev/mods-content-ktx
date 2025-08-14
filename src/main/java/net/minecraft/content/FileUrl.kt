package net.minecraft.content

import com.google.gson.annotations.SerializedName

/**
 * Represents a file location with optional local, storage, and external URLs.
 */
data class FileUrl(
    @SerializedName("local_path") val localPath: String?,
    @SerializedName("storage_path") val storagePath: String?,
    @SerializedName("external_url") val externalUrl: String?
)
