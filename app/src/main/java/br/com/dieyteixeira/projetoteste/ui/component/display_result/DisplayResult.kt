package br.com.dieyteixeira.projetoteste.ui.component.display_result

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.dieyteixeira.projetoteste.ui.component.display_result.RequestState.Idle.DisplayResult

/*-------------------------------------------------------------------------------------------------|
|                                                                                                  |
|                             RESULTADOS EM TELA DE CARREGAMENTO                                   |                                  |
|                                                                                                  |
|                                                                                                  |
|------------------------------------------------------------------------------------------------ */

sealed class RequestState<out T> {
    data object Idle : RequestState<Nothing>()
    data object Loading : RequestState<Nothing>()
    data class Success<T>(val data: T) : RequestState<T>()
    data class Error(val message: String) : RequestState<Nothing>()

    fun isLoading() = this is Loading
    fun isSuccess() = this is Success
    fun isError() = this is Error

    fun getSuccessData() = (this as Success).data
    fun getSuccessDataOrNull(): T? {
        return try {
            (this as Success).data
        } catch (e: Exception) {
            null
        }
    }

    fun getErrorMessage() = (this as Error).message
    fun getErrorMessageOrNull(): String? {
        return try {
            (this as Error).message
        } catch (e: Exception) {
            null
        }
    }

    @Composable
    fun DisplayResult(
        onIdle: (@Composable () -> Unit)? = null,
        onLoading: @Composable () -> Unit,
        onSuccess: @Composable (T) -> Unit,
        onError: @Composable (String) -> Unit,
    ) {
        AnimatedContent(
            targetState = this,
            transitionSpec = {
                fadeIn(tween(durationMillis = 300)) togetherWith
                        fadeOut(tween(durationMillis = 300))
            },
            label = "Content Animation"
        ) { state ->
            when (state) {
                is Idle -> { onIdle?.invoke() }
                is Loading -> { onLoading() }
                is Success -> { onSuccess(state.getSuccessData()) }
                is Error -> { onError(state.getErrorMessage()) }
            }
        }
    }
}

@Preview
@Composable
private fun DisplayResultPreview() {
    DisplayResult(
        onIdle = { Text(text = "Idle") },
        onLoading = { Text(text = "Loading") },
        onSuccess = { Text(text = "Success") },
        onError = { Text(text = "Error") }
    )
}