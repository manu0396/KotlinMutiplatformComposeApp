import org.gradle.kotlin.dsl.*

plugins {
    kotlin("multiplatform") version project.extra["kotlinVersion"] as String apply false
    id("com.android.application") version project.extra["androidGradlePluginVersion"] as String apply false
    id("com.google.devtools.ksp") version project.extra["kspVersion"] as String apply false
    id("dagger.hilt.android.plugin") version project.extra["daggerHiltVersion"] as String apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${project.extra["androidGradlePluginVersion"]}")
        classpath(kotlin("gradle-plugin", project.extra["kotlinVersion"] as String))
        classpath("com.google.dagger:hilt-android-gradle-plugin:${project.extra["daggerHiltVersion"]}")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

kotlin {
    androidTarget() // Updated from android() to androidTarget()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        val commonMain by getting {
            dependencies {
                // Common dependencies
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
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
                implementation("com.google.zxing:core:${project.extra["zxingVersion"]}") // QR code reading
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
