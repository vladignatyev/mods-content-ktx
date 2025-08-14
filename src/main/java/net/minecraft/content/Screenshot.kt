package net.minecraft.content

import java.util.Locale

/**
 * Represents a screenshot URL with a title derived from the filename.
 */
data class Screenshot(val url: String) {
    /**
     * Title generated from the filename with the first letter of each word capitalized.
     */
    val title: String
        get() {
            val name = url.substringAfterLast('/')
                .substringBeforeLast('.')
            return name.split('-', '_')
                .filter { it.isNotEmpty() }
                .joinToString(" ") { part ->
                    part.replaceFirstChar {
                        if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
                    }
                }
        }
}
