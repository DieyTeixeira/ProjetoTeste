package br.com.dieyteixeira.projetoteste.ui.component.animated_border_card

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/*-------------------------------------------------------------------------------------------------|
|                                                                                                  |
|                             ANIMAÇÃO DE CARREGAMENTO 3 CIRCULOS                                  |
|                                          ( ) ( ) ( )                                             |
|                                                                                                  |
|------------------------------------------------------------------------------------------------ */

@Composable
fun AnimatedBorderCard(
    onCardClick: () -> Unit = {},
    textCard: String = "",
) {
    val infiniteTransition = rememberInfiniteTransition(label = "Infinite Color Animation")
    val degrees by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 10000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "Infinite Colors"
    )
    val gradientBrush = Brush.sweepGradient(
        listOf(
            Color.Red,
            Color.Yellow
        )
    )

    Surface(
        modifier = Modifier
            .padding(16.dp)
            .height(40.dp)
            .clickable { onCardClick() },
        shape = RoundedCornerShape(25)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp)
                .drawWithContent {
                    rotate(degrees = degrees) {
                        drawCircle(
                            brush = gradientBrush,
                            radius = size.width,
                            blendMode = BlendMode.SrcIn,
                        )
                    }
                    drawContent()
                },
            color = MaterialTheme.colorScheme.surface,
            shape = RoundedCornerShape(23)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = textCard
                )
            }
        }
    }
}

@Preview
@Composable
private fun AnimatedBorderCardPreview() {
    AnimatedBorderCard(
        onCardClick = { },
        textCard = "Animated Border Card"
    )
}