package xyz.chronosirius.openmessage

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(state: MutableState<String>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "OpenMessage") },
                navigationIcon = {
                    IconButton(onClick = { state.value = "nav" }) {
                        Icon(Icons.Filled.Menu, contentDescription = "Localized description")
                    }
                },
                actions = {
                    IconButton(onClick = { state.value = "chat" }) {
                        Icon(Icons.Filled.Add, contentDescription = "Localized description")
                    }
                }
            )
        },
        content = {
            Text(text = "Hello World!", modifier = Modifier.padding(it))
        })

}