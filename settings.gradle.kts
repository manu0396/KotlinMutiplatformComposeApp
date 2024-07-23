pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    plugins {
        id("org.jetbrains.kotlin.multiplatform") version "1.9.20"
        id("org.jetbrains.compose") version "1.4.0"
    }
}

rootProject.name = "KotlinMultiplatformComposeApp"
include(":app")
include(":shared")
