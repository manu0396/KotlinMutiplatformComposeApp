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
                "com.android.application" -> useModule("com.android.tools.build:gradle:8.5.1")
                "org.jetbrains.kotlin.multiplatform" -> useModule("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.20")
            }
        }
    }
}

rootProject.name = "KotlinMultiplatformComposeApp"
include(":app", ":ios", ":shared")
