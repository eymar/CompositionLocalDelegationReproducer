

Run with Kotlin 2.2.0-Beta2 (default):

```shell
./gradlew :composeApp:compileDevelopmentExecutableKotlinJs 
```

It fails:

```
> Task :composeApp:compileDevelopmentExecutableKotlinJs FAILED
e: org.jetbrains.kotlin.backend.common.CompilationException: Back-end: Please report this problem https://kotl.in/issue
/Users/Oleksandr.Karpovich/Downloads/ComposeAndKotlin22/composeApp/src/commonMain/kotlin/org/company/app/App.kt:-1:-1
Details: Internal error in file lowering: java.lang.IllegalArgumentException: Wrong number of parameters in wrapper: expected: 0 bound and 2 unbound, but 0 found
        at org.jetbrains.kotlin.backend.common.lower.UpgradeCallableReferences$UpgradeTransformer.wrapFunction$lambda$34(UpgradeCallableReferences.kt:387)
        at org.jetbrains.kotlin.backend.common.lower.UpgradeCallableReferences$UpgradeTransformer.buildWrapperFunction(UpgradeCallableReferences.kt:326)

```

But it completes normally after changing the kotlin version to 2.1.20 in [libs.versions.toml](./gradle/libs.versions.toml)


It can be reproduced with this snippet:

```kotlin

@Composable
operator fun <T> CompositionLocal<T>.getValue(thisRef: Any?, property: KProperty<*>) = current

@Preview
@Composable
internal fun App() = AppTheme {
    val local = compositionLocalOf { "Default" }
    val delegatedLocal by local

    Text("Hey!") // irrelevant for this issue
}

```