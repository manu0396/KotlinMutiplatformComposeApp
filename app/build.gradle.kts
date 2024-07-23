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
        targetSdkVersion(34)
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
    implementation("androidx.core:core-ktx:${property("coreKtxVersion")}")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:${property("lifecycleRuntimeKtxVersion")}")
    implementation("androidx.activity:activity-compose:${property("activityComposeVersion")}")
    implementation(platform("androidx.compose:compose-bom:${property("composeBomVersion")}"))
    implementation("androidx.compose.material3:material3:${property("material3Version")}")
    implementation("com.google.dagger:hilt-android:${property("daggerHiltVersion")}")
    kapt("com.google.dagger:hilt-android-compiler:${property("hiltCompilerVersion")}")
    implementation("javax.inject:javax.inject:${property("javaxInjectVersion")}")
    testImplementation("junit:junit:${property("junitVersion")}")
    androidTestImplementation("androidx.test.ext:junit:${property("junitKtxVersion")}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${property("espressoCoreVersion")}")
}
