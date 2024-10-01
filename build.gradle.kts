plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false

    kotlin("jvm") version libs.versions.kotlin.version.get() apply false
    alias(libs.plugins.kotlin.android) apply false
    kotlin("multiplatform") version libs.versions.kotlin.version.get() apply false
    alias(libs.plugins.kotlin.cocoapods).apply(false)

    id("org.jetbrains.compose") version libs.versions.jetbrains.compose.version.get() apply false
    alias(libs.plugins.compose.compiler).apply(false)

    alias(libs.plugins.ksp.plugin).apply(false)

    alias(libs.plugins.kotlinx.serialization) apply false

    alias(libs.plugins.buildKonfigPlugin) apply false
}

buildscript {
    dependencies {

    }
}

allprojects {

}
