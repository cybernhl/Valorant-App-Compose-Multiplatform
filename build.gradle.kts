plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    id("org.jetbrains.compose") version libs.versions.jetbrains.compose.version.get() apply false
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.kotlinx.serialization) apply false
    alias(libs.plugins.buildKonfigPlugin) apply false
    alias(libs.plugins.compose.compiler).apply(false)
}

buildscript {
    dependencies {

    }
}

allprojects {

}