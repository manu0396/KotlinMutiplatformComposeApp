plugins {
    kotlin("multiplatform") version "1.9.24" //Check this
    id("com.android.library")
    id("org.jetbrains.compose") version "1.7.0"
}

kotlin {
    android()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib"))
                implementation("org.jetbrains.compose.runtime:runtime:1.5.1")
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("androidx.core:core-ktx:1.13.1")
                implementation("androidx.appcompat:appcompat:1.3.1")
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
    }
}

android {
    compileSdk = 34
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")

    defaultConfig {
        minSdk = 24
        targetSdk = 34
    }
}
