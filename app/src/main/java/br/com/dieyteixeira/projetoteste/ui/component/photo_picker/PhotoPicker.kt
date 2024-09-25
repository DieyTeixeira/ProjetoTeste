package br.com.dieyteixeira.projetoteste.ui.component.photo_picker

import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest

/*-------------------------------------------------------------------------------------------------|
|                                                                                                  |
|                            PEGAR FOTO DO GALERIA E MOSTRAR NA TELA                               |
|                                          Dependência:                                            |
|                     Coil: implementation("io.coil-kt:coil-compose:2.2.2")                        |
|                                                                                                  |
|------------------------------------------------------------------------------------------------ */

@Composable
fun PhotoPicker() {
    val context = LocalContext.current
    var imageUri: Any? by remember { mutableStateOf("") }
    val photoPicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia()
    ) {
        if (it != null) {
            Log.d("PhotoPicker", "Selected URI: $it")
            imageUri = it
        } else {
            Log.d("PhotoPicker", "No media selected")
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AsyncImage(
            modifier = Modifier
                .size(250.dp)
                .clickable {
                    photoPicker.launch(
                        PickVisualMediaRequest(
                            ActivityResultContracts.PickVisualMedia.ImageOnly
                        )
                    )
                },
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUri)
                .crossfade(enable = true)
                .build(),
            contentDescription = "Avatar Image",
            contentScale = ContentScale.Crop,
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = {
            Toast.makeText(
                context,
                ActivityResultContracts.PickVisualMedia.isPhotoPickerAvailable().toString(),
                Toast.LENGTH_LONG
            ).show()
        }) {
            Text(text = "Validar Foto")
        }
    }
}

@Preview
@Composable
private fun PhotoPickerPreview() {
    PhotoPicker()
}