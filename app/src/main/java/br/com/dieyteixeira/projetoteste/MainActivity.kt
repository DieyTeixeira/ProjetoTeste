package br.com.dieyteixeira.projetoteste

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.dieyteixeira.projetoteste.ui.component.animated_border_card.AnimatedBorderCard
import br.com.dieyteixeira.projetoteste.ui.component.display_result.RequestState.Idle.DisplayResult
import br.com.dieyteixeira.projetoteste.ui.component.horizontal_pager.HorizontalPager
import br.com.dieyteixeira.projetoteste.ui.component.loading_animation.LoadingAnimationMulticor
import br.com.dieyteixeira.projetoteste.ui.component.loading_animation.LoadingAnimationUnicor
import br.com.dieyteixeira.projetoteste.ui.component.photo_picker.PhotoPicker
import br.com.dieyteixeira.projetoteste.ui.theme.ProjetoTesteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProjetoTesteTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
//                    LoadingAnimationUnicor()

//                    LoadingAnimationMulticor()

//                    HorizontalPager()
//                    DisplayResult(
//                        onIdle = { Text(text = "Idle") },
//                        onLoading = { Text(text = "Loading") },
//                        onSuccess = { Text(text = "Success") },
//                        onError = { Text(text = "Error") }
//                    )

//                    AnimatedBorderCard(
//                        onCardClick = { },
//                        textCard = "Animated Border Card"
//                    )

                    PhotoPicker()
                }
            }
        }
    }
}