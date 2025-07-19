package com.dkoniev.chordstabs.ui.screens

import android.util.Log.i
import android.widget.Space
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dkoniev.chordstabs.data.model.SongListItem

@Composable
fun MainScreen(
    songs: List<SongListItem>,
    onSongClick: (Int) -> Unit,
    onArtistClick: (Int) -> Unit,
    onSearchClick: () -> Unit,
    onSettingsClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Chords Tab App") },
                navigationIcon = {
                    IconButton(onClick = onSearchClick) {
                        Icon(Icons.Default.Search, contentDescription = "Search")
                    }
                },
                actions = {
                    IconButton(onClick = onSettingsClick) {
                        Icon(Icons.Default.Settings, contentDescription = "Settings")
                    }
                }
            )
        },
        bottomBar = {
            // TODO Add composables
            BottomNavigation {
                BottomNavigationItem(
                    selected = true,
                    onClick = {},
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    label = { Text("Home") }
                )
                BottomNavigationItem(
                    selected = false,
                    onClick = {},
                    icon = { Icon(Icons.Default.Favorite, contentDescription = "Favorites") },
                    label = { Text("Favorites") }
                )
            }
        }
    ) { padding ->
        LazyColumn(contentPadding = padding) {
            items(songs.size) { index ->
                val songItem = songs[index]

                SongsListItem(
                    songId = songItem.id,
                    songName = songItem.name,
                    artistId = songItem.artist.id,
                    artistName = songItem.artist.name,
                    onSongClick = onSongClick,
                    onArtistClick = onArtistClick
                )
                if (index < songs.size.dec()) {
                    Spacer(modifier = Modifier.height(height = 12.dp))
                }
            }
        }
    }
}

@Composable
fun SongsListItem(
    songId: Int,
    songName: String,
    artistId: Int,
    artistName: String,
    onSongClick: (Int) -> Unit,
    onArtistClick: (Int) -> Unit
) {
    Row(
        modifier = Modifier.clickable(onClick = { onSongClick(songId) }),      // TODO The placement of clickable invokation might be changed in scope of this composable
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.padding(
                vertical = 16.dp,
                horizontal = 16.dp
            ),
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = songName)
            Spacer(modifier = Modifier.height(height = 4.dp))
            Text(
                modifier = Modifier.clickable(onClick = { onArtistClick(artistId) }),
                text = artistName,
            )
        }
        Spacer(modifier = Modifier.weight(weight = 1f))

        // TODO Add "add_to_favourites" button
//        Icon(
//
//        )
    }
}
