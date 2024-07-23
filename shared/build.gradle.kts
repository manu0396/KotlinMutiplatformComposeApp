plugins {
    kotlin("multiplatform") version extra["kotlinVersion"] as String
    id("org.jetbrains.kotlin.plugin.serialization") version extra["kotlinVersion"] as String
    id("org.jetbrains.compose") version extra["jetbrainsComposeVersion"] as String
}

repositories {
    google()
    mavenCentral()
}

kotlin {
    android()
    jvm("desktop")

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:${extra["kotlinxSerializationVersion"]}")
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(kotlin("stdlib"))
                implementation("androidx.appcompat:appcompat:${extra["androidAppcompatVersion"]}")
                implementation("androidx.core:core-ktx:${extra["androidCoreKtxVersion"]}")
                implementation(compose.ui)
                implementation(compose.uiTooling)
            }
        }
        val desktopMain by getting {
            dependencies {
                implementation(compose.desktop.currentOs)
            }
        }
    }
}

android {
    compileSdkVersion((extra["androidCompileSdkVersion"] as String).toInt())
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion((extra["androidMinSdkVersion"] as String).toInt())
        targetSdkVersion((extra["androidTargetSdkVersion"] as String).toInt())
    }
}
