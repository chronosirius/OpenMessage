package xyz.chronosirius.openmessage

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import xyz.chronosirius.openmessage.logic.APNsConnectionHandler

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Chat(state: MutableState<String>) {
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
                    IconButton(onClick = { state.value = "home" }) {
                        Icon(Icons.Filled.Home, contentDescription = "Localized description")
                    }
                }
            )
        },
        content = {
            val t = remember { mutableStateOf("EE") }
            Surface(modifier=Modifier.padding(it)) {
                Text(text = t.value)
                Button(onClick = { APNsConnectionHandler().send(t) }, modifier=Modifier.padding(top=16.dp)) {
                    Text(text = "Hello World!")
                }
            }
        })
}