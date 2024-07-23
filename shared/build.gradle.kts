plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("kotlin-parcelize")
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.20"
    id("org.jetbrains.compose")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
}

kotlin {
    androidTarget {
        publishAllLibraryVariants()
    }

    jvm()

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.1")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.2.2")
                implementation("io.ktor:ktor-client-core:1.6.2")
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.1")
                implementation("com.google.dagger:hilt-android:2.38.1")
                implementation("androidx.compose.ui:ui:1.4.0")
                implementation("androidx.compose.material:material:1.4.0")
                implementation("androidx.compose.ui:ui-tooling-preview:1.4.0")
                implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
                implementation("androidx.activity:activity-compose:1.3.1")
                kapt("com.google.dagger:hilt-android-compiler:2.38.1")
            }
        }
        val iosMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-ios:1.6.2")
            }
        }
    }
}

android {
    compileSdk = 34
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

dependencies {
    implementation("com.google.dagger:hilt-android:2.38.1")
    kapt("com.google.dagger:hilt-android-compiler:2.38.1")
}

kapt {
    correctErrorTypes = true
    arguments {
        arg("dagger.hilt.disableModulesHaveInstallInCheck", "true")
    }
}
