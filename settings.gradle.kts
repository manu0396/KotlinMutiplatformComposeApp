pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "KotlinMultiplatformComposeApp"
include(":androidApp")
include(":shared")
