package com.example.moviesapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@Composable
fun WeatherWindow(){
    val scope = rememberCoroutineScope()
    val state = rememberScaffoldState()
    var window by remember { mutableStateOf(0) }

    Scaffold(
        scaffoldState = state,

        topBar = {
            TopAppBar() {
                    IconButton({
                        scope.launch {
                            state.drawerState.open()
                        }
                    }) {
                        Icon(Icons.Default.Menu, "")
                    }
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth(0.9f)) {
                    Text(text = "Погода", fontSize = 22.sp)
                }

            }
        },

        drawerContent = {
            Column {

                    Row(verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .background(color = MaterialTheme.colors.background)
                            .fillMaxWidth()
                            .padding(bottom = 10.dp, top = 10.dp)
                    ) {
                        Text(text = "Погода ")
                    }

                Divider()

                DropdownMenuItem({window = 1}) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "Выбор города ")
                        Spacer(modifier = Modifier.weight(1f))
                        Icon(Icons.Default.Search, "")
                    }
                }
                Divider()

                DropdownMenuItem({window = 0}) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "Погода ")
                        Spacer(modifier = Modifier.weight(1f))
                        Icon(Icons.Default.Settings, "")
                    }
                }
                Divider()

                DropdownMenuItem({window = 2}) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "Настройка ")
                        Spacer(modifier = Modifier.weight(1f))
                        Icon(Icons.Default.Settings, "")
                    }
                }
                Divider()

                Spacer(modifier = Modifier.weight(1f))

                Divider()
                DropdownMenuItem({window = 3}) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "О приложении ")
                        Spacer(modifier = Modifier.weight(1f))
                        Icon(Icons.Default.Info, "")
                    }
                }
            }
        }
    ) {
        if(window == 0) TempWindow()
        else if (window == 1) CityWindow()
        else if (window == 2) SetingWindow()
        else if (window == 3) AboutAppWindow()
        else Column(Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center){
            Text(text = "ERROR", fontSize = 54.sp)
        }
    }
}