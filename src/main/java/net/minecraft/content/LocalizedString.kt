package net.minecraft.content

/**
 * Represents a string with optional localizations.
 */
data class LocalizedString(
    val title: String,
    val localization: Map<String, String>
)
