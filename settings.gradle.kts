pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven { url = uri("https://plugins.gradle.org/m2/") } // Add this repository
    }
    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "org.jetbrains.kotlin.plugin.serialization" -> useModule("org.jetbrains.kotlin:kotlin-serialization:${extra["serializationVersion"]}")
                "com.android.application" -> useModule("com.android.tools.build:gradle:${extra["androidGradlePluginVersion"]}")
                "org.jetbrains.kotlin.multiplatform" -> useModule("org.jetbrains.kotlin:kotlin-gradle-plugin:${extra["kotlinVersion"]}")
                "dagger.hilt.android.plugin" -> useModule("com.google.dagger:hilt-android-gradle-plugin:${extra["daggerHiltVersion"]}")
                "com.google.devtools.ksp" -> useModule("com.google.devtools.ksp:com.google.devtools.ksp.gradle.plugin:${extra["kspVersion"]}")
            }
        }
    }
}

rootProject.name = "KotlinMultiplatformComposeApp"
include(":androidApp")
include(":shared")
