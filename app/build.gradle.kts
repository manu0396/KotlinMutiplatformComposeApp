import org.gradle.kotlin.dsl.*

plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-kapt")
    id("org.jetbrains.compose")
}

android {
    compileSdk = project.extra["androidCompileSdkVersion"] as Int

    defaultConfig {
        applicationId = "com.example.app"
        minSdk = project.extra["androidMinSdkVersion"] as Int
        targetSdk = project.extra["androidTargetSdkVersion"] as Int
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    signingConfigs {
        create("release") {
            keyAlias = project.findProperty("MYAPP_KEY_ALIAS") as String? ?: ""
            keyPassword = project.findProperty("MYAPP_KEY_PASSWORD") as String? ?: ""
            storeFile = file(project.findProperty("MYAPP_STORE_FILE") as String? ?: "")
            storePassword = project.findProperty("MYAPP_STORE_PASSWORD") as String? ?: ""
        }
    }

    buildTypes {
        getByName("release") {
            signingConfig = signingConfigs.getByName("release")
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        getByName("debug") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${project.extra["kotlinVersion"]}")
    implementation("androidx.core:core-ktx:${project.extra["coreKtxVersion"]}")
    implementation("androidx.appcompat:appcompat:${project.extra["androidAppcompatVersion"]}")
    implementation("com.google.android.material:material:${project.extra["androidMaterialVersion"]}")
    implementation("androidx.constraintlayout:constraintlayout:2.1.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:${project.extra["espressoCoreVersion"]}")
}
