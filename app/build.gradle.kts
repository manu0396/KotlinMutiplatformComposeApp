import org.gradle.kotlin.dsl.*

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("org.jetbrains.compose")
    id("dagger.hilt.android.plugin")
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
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:${project.extra["lifecycleRuntimeKtxVersion"]}")
    implementation("androidx.activity:activity-compose:${project.extra["activityComposeVersion"]}")
    implementation("androidx.compose.ui:ui:${project.extra["composeVersion"]}")
    implementation("androidx.compose.material3:material3:${project.extra["material3Version"]}")
    implementation("androidx.compose.ui:ui-tooling-preview:${project.extra["composeVersion"]}")
    implementation("com.google.accompanist:accompanist-navigation-animation:0.25.0")
    implementation("com.squareup.retrofit2:retrofit:${project.extra["retrofitVersion"]}")
    implementation("com.squareup.retrofit2:converter-gson:${project.extra["retrofitVersion"]}")
    implementation("com.squareup.okhttp3:okhttp:${project.extra["okhttpVersion"]}")
    implementation("com.squareup.okhttp3:logging-interceptor:${project.extra["okhttpVersion"]}")
    implementation("androidx.room:room-runtime:${project.extra["roomVersion"]}")
    implementation("androidx.room:room-ktx:${project.extra["roomVersion"]}")
    implementation("com.github.bumptech.glide:glide:${project.extra["glideVersion"]}")
    implementation("com.google.dagger:hilt-android:${project.extra["daggerHiltVersion"]}")
    kapt("com.google.dagger:hilt-compiler:${project.extra["hiltCompilerVersion"]}")
    kapt("androidx.room:room-compiler:${project.extra["roomVersion"]}")
    implementation("com.google.zxing:core:3.3.3") // QR code reading

    // Testing dependencies
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:${project.extra["espressoCoreVersion"]}")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:${project.extra["composeVersion"]}")
}

// Apply the Kotlin Kapt plugin to enable annotation processing
kapt {
    correctErrorTypes = true
    arguments {
        arg("room.incremental", "true")
    }
}
