import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.gradle.api.Project
import org.gradle.kotlin.dsl.extra

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.kotlin.plugin.serialization") version project.findProperty("kotlinVersion") as String
    id("org.jetbrains.compose") version project.findProperty("jetbrainsComposeVersion") as String
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
}

kotlin {
    androidTarget()

    jvm()

    ios {
        binaries {
            framework {
                baseName = "Shared"
            }
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${project.findProperty("coroutinesVersion") as String}")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:${project.findProperty("serializationVersion") as String}")
                implementation("io.ktor:ktor-client-core:${project.findProperty("ktorVersion") as String}")
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${project.findProperty("coroutinesVersion") as String}")
                implementation("com.google.dagger:hilt-android:${project.findProperty("hiltVersion") as String}")
                implementation("androidx.compose.ui:ui:${project.findProperty("composeVersion") as String}")
                implementation("androidx.compose.material:material:${project.findProperty("composeVersion") as String}")
                implementation("androidx.compose.ui:ui-tooling-preview:${project.findProperty("composeVersion") as String}")
                implementation("androidx.lifecycle:lifecycle-runtime-ktx:${project.findProperty("lifecycleVersion") as String}")
                implementation("androidx.activity:activity-compose:${project.findProperty("activityComposeVersion") as String}")
            }
        }
        val iosMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-ios:${project.findProperty("ktorVersion") as String}")
            }
        }
    }
}

android {
    compileSdk = 34
    namespace = "com.example.shared"
    defaultConfig {
        minSdk = 21
        targetSdk = 34
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = "17"
    }
}

kapt {
    correctErrorTypes = true
    arguments {
        arg("dagger.hilt.disableModulesHaveInstallInCheck", "true")
    }
}
