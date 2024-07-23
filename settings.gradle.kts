pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "org.jetbrains.kotlin.plugin.serialization" -> useModule("org.jetbrains.kotlin:kotlin-serialization:1.5.0")
                "com.android.application" -> useModule("com.android.tools.build:gradle:8.1.1")
                "org.jetbrains.kotlin.multiplatform" -> useModule("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")
            }
        }
    }
}

rootProject.name = "KotlinMultiplatformComposeApp"
include(":androidApp", ":shared")
