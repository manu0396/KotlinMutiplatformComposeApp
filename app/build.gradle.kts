import org.gradle.api.Project
import org.gradle.kotlin.dsl.extra

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
}

android {
    namespace = "com.example.app"

    compileSdk = 34
    defaultConfig {
        applicationId = "com.example.app"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation("androidx.core:core-ktx:${project.findProperty("coreKtxVersion") as String}")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:${project.findProperty("lifecycleRuntimeKtxVersion") as String}")
    implementation("androidx.activity:activity-compose:${project.findProperty("activityComposeVersion") as String}")
    implementation(platform("androidx.compose:compose-bom:${project.findProperty("composeBomVersion") as String}"))
    implementation("androidx.compose.material3:material3:${project.findProperty("material3Version") as String}")
    implementation("com.google.dagger:hilt-android:${project.findProperty("daggerHiltVersion") as String}")
    kapt("com.google.dagger:hilt-android-compiler:${project.findProperty("hiltCompilerVersion") as String}")
    implementation("javax.inject:javax.inject:${project.findProperty("javaxInjectVersion") as String}")
    testImplementation("junit:junit:${project.findProperty("junitVersion") as String}")
    androidTestImplementation("androidx.test.ext:junit:${project.findProperty("junitKtxVersion") as String}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${project.findProperty("espressoCoreVersion") as String}")
}
