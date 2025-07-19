package com.dkoniev.chordstabs.data.model

data class SongDetails(
    val id: Int,
    val name: String,
    val artist: Artist,
    val lyrics: Lyrics
)
