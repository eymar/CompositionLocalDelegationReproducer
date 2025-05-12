package org.company.app

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocal
import androidx.compose.runtime.compositionLocalOf
import org.company.app.theme.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlin.reflect.KProperty

@Composable
operator fun <T> CompositionLocal<T>.getValue(thisRef: Any?, property: KProperty<*>) = current

@Preview
@Composable
internal fun App() = AppTheme {
    val local = compositionLocalOf { "Default" }
    val delegatedLocal by local

    Text("Hey!")
}
