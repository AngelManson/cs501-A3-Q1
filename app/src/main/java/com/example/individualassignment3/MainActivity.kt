package com.example.individualassignment3

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.individualassignment3.ui.theme.IndividualAssignment3Theme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IndividualAssignment3Theme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = {
                        @OptIn(ExperimentalMaterial3Api::class)
                        CenterAlignedTopAppBar(
                            title = { Text("Settings", fontWeight = FontWeight.Bold) }
                        )
                    }
                ) { innerPadding ->
                    SettingsScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun SettingsScreen(modifier: Modifier = Modifier) {
    var darkMode by remember { mutableStateOf(false) }
    var notifications by remember { mutableStateOf(true) }
    var boldText by remember { mutableStateOf(false) }
    var volume by remember { mutableStateOf(0.5f) }
    var brightness by remember { mutableStateOf(0.5f) }
    var textSize by remember { mutableStateOf(1.0f) }
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { padding ->
            Column(
                modifier = modifier
                    .padding(padding)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                // This horizontalAlignment is the "Default" for all children.
                // Individual children can override this using Modifier.align().
//                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(MaterialTheme.shapes.medium)
                        .padding(top = 8.dp)
                        .border(
                            1.dp,
                            MaterialTheme.colorScheme.outlineVariant,
                            MaterialTheme.shapes.medium
                        )
                ) {
                    Text(
                        text = "App Settings",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier
                            .padding(10.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                }

                SliderSettingItem(
                    title = "Volume",
                    description = "Adjust the Volume",
                    control = {
                        Slider(
                            value = volume,
                            onValueChange = { volume = it },
                            modifier = Modifier.fillMaxWidth()
                        )
                    })

                SliderSettingItem(
                    title = "Brightness",
                    description = "Adjust the Screen Brightness",
                    control = { Slider(
                        value = brightness,
                        onValueChange = { brightness = it },
                        modifier = Modifier.fillMaxWidth()
                    )
                    })

                SettingItem(
                    title = "Dark Mode",
                    description = "Enable Dark Mode",
                    control = {
                        Switch(
                            checked = darkMode,
                            onCheckedChange = { darkMode = it }
                        )
                    })

                SettingItem(
                    title = "Notifications",
                    description = "Enable app notifications",
                    control = {
                        Switch(
                            checked = notifications,
                            onCheckedChange = { notifications = it }
                        )
                    })

                SliderSettingItem(
                    title = "Text Size",
                    description = "Adjust the Text Size",
                    control = { Slider(
                        value = textSize,
                        onValueChange = { textSize = it },
                        modifier = Modifier.fillMaxWidth()
                    )})

                SettingItem(
                    title = "Bold Text",
                    description = "Make all text bold",
                    control = {
                        Checkbox(
                            checked = boldText,
                            onCheckedChange = { boldText = it }
                        )
                    })

                Divider()

                Button(
                    onClick = { coroutineScope.launch {
                        snackbarHostState.showSnackbar(
                            message = "Settings Saved!",
                            duration = SnackbarDuration.Short
                        )
                    }},
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text("Save")
                }
            }
        }
}

@Composable
fun SettingItem(
    title: String,
    description: String,
    control: @Composable () -> Unit ){
//    Card(
////        modifier = Modifier
//////            .fillMaxSize()
////            .fillMaxWidth()
////            .border(
////                1.dp,
////                MaterialTheme.colorScheme.outlineVariant,
////                MaterialTheme.shapes.medium
//////                width = 1.dp,
//////                shape = MaterialTheme.shapes.medium
////            )
//        modifier = Modifier
//            .fillMaxWidth(),
////            .padding(vertical = 4.dp),
//        colors = CardDefaults.cardColors(
//            containerColor = MaterialTheme.colorScheme.surfaceVariant
//        ),
//        elevation = CardDefaults.cardElevation(
//            defaultElevation = 2.dp
//        ),
//        shape = MaterialTheme.shapes.medium
//    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 72.dp )
                .padding(16.dp)
                .clickable{ },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            ) {
//            (
                //        modifier = Modifier.fillMaxSize(),
                //        verticalArrangement = Arrangement.spacedBy(12.dp),
                //        horizontalAlignment = Alignment.Start
                //    ){
                Text(text = title, fontWeight = FontWeight.Bold)
                Text(text = description, style = MaterialTheme.typography.bodySmall)
            }
            control()
        }
//    }
}

//Each setting row must be a Row with: (check with Prof to see if I can just use column)
@Composable
fun SliderSettingItem(
    title: String,
    description: String,
    control: @Composable () -> Unit ){
//    Card(
////        modifier = Modifier
//////            .fillMaxSize()
////            .fillMaxWidth()
////            .border(
////                1.dp,
////                MaterialTheme.colorScheme.outlineVariant,
////                MaterialTheme.shapes.medium
//////                width = 1.dp,
//////                shape = MaterialTheme.shapes.medium
////            )
//        modifier = Modifier
//            .fillMaxWidth(),
////            .padding(vertical = 4.dp),
//        colors = CardDefaults.cardColors(
//            containerColor = MaterialTheme.colorScheme.surfaceVariant
//        ),
//        elevation = CardDefaults.cardElevation(
//            defaultElevation = 2.dp
//        ),
//        shape = MaterialTheme.shapes.medium
//    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 100.dp )
                .padding(16.dp)
                .clickable{ },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            ) {
                Text(text = title, fontWeight = FontWeight.Bold)
                Text(text = description, style = MaterialTheme.typography.bodySmall)
                control()
            }

        }
//    }
}

@Preview(showBackground = true)
@Composable
fun SettingsPreview() {
    IndividualAssignment3Theme {
        Scaffold(modifier = Modifier.fillMaxSize(),
            topBar = {
                @OptIn(ExperimentalMaterial3Api::class)
                CenterAlignedTopAppBar(
                    title = { Text("Settings", fontWeight = FontWeight.Bold) }
                )
            }
        ) { innerPadding ->
            SettingsScreen(modifier = Modifier.padding(innerPadding))
        }
    }
}