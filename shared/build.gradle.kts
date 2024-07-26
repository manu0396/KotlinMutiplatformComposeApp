import org.gradle.kotlin.dsl.*

plugins {
    id("com.android.library")
    kotlin("multiplatform")
    id("com.google.devtools.ksp")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdkVersion(project.extra["androidCompileSdkVersion"] as Int)

    defaultConfig {
        minSdkVersion(project.extra["androidMinSdkVersion"] as Int)
        targetSdkVersion(project.extra["androidTargetSdkVersion"] as Int)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

kotlin {
    androidTarget() // Register the Android target
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-stdlib-common")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${project.extra["coroutinesVersion"]}")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("androidx.core:core-ktx:${project.extra["coreKtxVersion"]}")
                implementation("androidx.lifecycle:lifecycle-runtime-ktx:${project.extra["lifecycleRuntimeKtxVersion"]}")
                implementation("androidx.activity:activity-compose:${project.extra["activityComposeVersion"]}")
                implementation("com.google.accompanist:accompanist-navigation-animation:0.25.0")
                implementation("com.squareup.retrofit2:retrofit:${project.extra["retrofitVersion"]}")
                implementation("com.squareup.retrofit2:converter-gson:${project.extra["retrofitVersion"]}")
                implementation("com.squareup.okhttp3:okhttp:${project.extra["okhttpVersion"]}")
                implementation("com.squareup.okhttp3:logging-interceptor:${project.extra["okhttpVersion"]}")
                implementation("androidx.room:room-runtime:${project.extra["roomVersion"]}")
                implementation("androidx.room:room-ktx:${project.extra["roomVersion"]}")
                implementation("com.github.bumptech.glide:glide:${project.extra["glideVersion"]}")
                implementation("com.google.dagger:hilt-android:${project.extra["daggerHiltVersion"]}")
                ksp("com.google.dagger:hilt-compiler:${project.extra["hiltCompilerVersion"]}")
                ksp("androidx.room:room-compiler:${project.extra["roomVersion"]}")
                implementation("com.google.zxing:core:3.3.3") // QR code reading
            }
        }
        val androidUnitTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation("junit:junit:4.13.2")
            }
        }
        val androidInstrumentedTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation("junit:junit:4.13.2")
            }
        }
        val iosMain by creating {
            dependencies {
                // iOS-specific dependencies
            }
        }
        val iosTest by creating {
            dependencies {
                // iOS-specific test dependencies
            }
        }
        getByName("iosX64Main").dependsOn(iosMain)
        getByName("iosArm64Main").dependsOn(iosMain)
        getByName("iosSimulatorArm64Main").dependsOn(iosMain)
        getByName("iosX64Test").dependsOn(iosTest)
        getByName("iosArm64Test").dependsOn(iosTest)
        getByName("iosSimulatorArm64Test").dependsOn(iosTest)
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
    ksp("com.google.dagger:hilt-compiler:${project.extra["hiltCompilerVersion"]}")
    ksp("androidx.room:room-compiler:${project.extra["roomVersion"]}")
    implementation("com.google.zxing:core:${project.extra["zxingVersion"]}") // QR code reading

    // Testing dependencies
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:${project.extra["espressoCoreVersion"]}")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:${project.extra["composeVersion"]}")
}
