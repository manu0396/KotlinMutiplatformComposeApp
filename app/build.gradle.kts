import org.gradle.kotlin.dsl.*

plugins {
    id("com.android.application")
    kotlin("android")
    id("com.google.devtools.ksp")
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
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${extra["kotlinVersion"]}")
    implementation("androidx.core:core-ktx:${extra["androidCoreKtxVersion"]}")
    implementation("androidx.appcompat:appcompat:${extra["androidAppcompatVersion"]}")
    implementation("com.google.android.material:material:${extra["androidMaterialVersion"]}")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:${extra["lifecycleRuntimeKtxVersion"]}")
    implementation("androidx.activity:activity-compose:${extra["activityComposeVersion"]}")
    implementation("androidx.compose.ui:ui:${extra["composeVersion"]}")
    implementation("androidx.compose.material3:material3:${extra["material3Version"]}")
    implementation("androidx.compose.ui:ui-tooling-preview:${extra["composeVersion"]}")
    implementation("com.google.accompanist:accompanist-navigation-animation:0.21.3-beta")
    implementation("com.squareup.retrofit2:retrofit:${extra["retrofitVersion"]}")
    implementation("com.squareup.retrofit2:converter-gson:${extra["retrofitVersion"]}")
    implementation("com.squareup.okhttp3:okhttp:${extra["okhttpVersion"]}")
    implementation("com.squareup.okhttp3:logging-interceptor:${extra["okhttpVersion"]}")
    implementation("androidx.room:room-runtime:${extra["roomVersion"]}")
    implementation("androidx.room:room-ktx:${extra["roomVersion"]}")
    ksp("androidx.room:room-compiler:${extra["roomVersion"]}")
    implementation("com.github.bumptech.glide:glide:${extra["glideVersion"]}")
    implementation("com.google.dagger:hilt-android:${extra["daggerHiltVersion"]}")
    ksp("com.google.dagger:hilt-compiler:${extra["hiltCompilerVersion"]}")
    implementation("com.google.zxing:core:${extra["zxingVersion"]}")
    // Testing dependencies
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:${project.extra["espressoCoreVersion"]}")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:${project.extra["composeVersion"]}")
}
