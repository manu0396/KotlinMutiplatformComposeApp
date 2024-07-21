plugins {
    id("com.android.application") version "8.0.2"
    kotlin("android") version "1.9.24"
    kotlin("kapt") version "1.9.24"
}

android {
    namespace = "com.example.app"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.example.app"
        minSdk = 16
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.compose.ui:ui:1.4.3")
    implementation("androidx.compose.material3:material3:1.0.0")
    implementation("org.koin:koin-androidx-compose:3.4.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")
    implementation("androidx.room:room-runtime:2.5.2")
    implementation("com.github.bumptech.glide:glide:4.15.1")
    implementation("com.karumi:dexter:6.2.3")
    implementation("com.github.sumitanantwar:qrscanner:1.0.2")
    kapt("androidx.room:room-compiler:2.5.2")
}

repositories {
    google()
    mavenCentral()
}
