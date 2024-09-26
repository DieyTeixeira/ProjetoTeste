package br.com.dieyteixeira.projetoteste

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import br.com.dieyteixeira.projetoteste.ui.theme.ProjetoTesteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
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

//                    PhotoPicker()

//                    AnimatedTopBar()

//                    LazyListScrollState()

//                    AnimatedStopWatch(
//                        mainViewModel = MainViewModel()
//                    )

//                    WebBrowser()

//                    AnimatedSelectItem(
//                        title = "Sample Item",
//                        subtitle = "This is a sample subtitle to test the AnimatedSelectItem composable.",
//                    )

                }
            }
        }
    }
}