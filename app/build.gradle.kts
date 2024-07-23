plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdkVersion((project.property("androidCompileSdkVersion") as String).toInt())
    defaultConfig {
        applicationId = "com.example.app"
        minSdkVersion((project.property("androidMinSdkVersion") as String).toInt())
        targetSdkVersion((project.property("androidTargetSdkVersion") as String).toInt())
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("androidx.core:core-ktx:${project.property("androidCoreKtxVersion")}")
    implementation("androidx.appcompat:appcompat:${project.property("androidAppcompatVersion")}")
    implementation("com.google.android.material:material:${project.property("androidMaterialVersion")}")
}
