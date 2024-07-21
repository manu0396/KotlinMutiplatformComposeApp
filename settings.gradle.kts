pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    plugins {
        id("org.jetbrains.kotlin.multiplatform") version "1.9.24"
        id("org.jetbrains.compose") version "1.4.0"
    }
}

rootProject.name = "KotlinMultiplatformComposeApp"
include(":shared")
