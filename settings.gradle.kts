pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "org.jetbrains.kotlin.plugin.serialization" -> useModule("org.jetbrains.kotlin:kotlin-serialization:${extra["serializationVersion"]}")
                "com.android.application" -> useModule("com.android.tools.build:gradle:${extra["androidGradlePluginVersion"]}")
                "org.jetbrains.kotlin.multiplatform" -> useModule("org.jetbrains.kotlin:kotlin-gradle-plugin:${extra["kotlinVersion"]}")
                "dagger.hilt.android.plugin" -> useModule("com.google.dagger:hilt-android-gradle-plugin:${extra["daggerHiltVersion"]}")
                "kotlin-kapt" -> useModule("org.jetbrains.kotlin:kotlin-gradle-plugin:${extra["kotlinVersion"]}")
            }
        }
    }
}

rootProject.name = "KotlinMultiplatformComposeApp"
include(":androidApp")
include(":shared")
