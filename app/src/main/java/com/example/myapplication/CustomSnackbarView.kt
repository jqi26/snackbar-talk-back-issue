package com.example.myapplication

import android.content.Context
import android.util.AttributeSet
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.AbstractComposeView
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.flow.Flow

class CustomSnackbarView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : AbstractComposeView(context, attrs, defStyle) {
    var show: Flow<Boolean>? = null

    @Composable
    override fun Content() {

        AnimatedVisibility(
            visible = show?.collectAsState(initial = false)?.value ?: false,
            enter = slideInVertically(initialOffsetY = { it }),
            exit = slideOutVertically(targetOffsetY = { it })
        ) {
            MyApplicationTheme {
                Surface(
                    shape = RoundedCornerShape(4.dp),
                    modifier = Modifier.padding(8.dp).focusable(),
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("A snackbar", modifier = Modifier.focusable().fillMaxWidth())
                    }
                }
            }
        }
    }
}