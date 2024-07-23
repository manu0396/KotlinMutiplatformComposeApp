plugins {
    kotlin("multiplatform") version "1.8.0" // Adjust version accordingly
    id("com.android.application") version "8.1.1" // Adjust version accordingly
    id("org.jetbrains.compose") version "1.0.0" // Adjust version accordingly
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.1.1")
        classpath(kotlin("gradle-plugin", "1.8.0"))
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

ext["serializationVersion"] = "1.5.0"
ext["junitKtxVersion"] = "1.2.1"
ext["androidCompileSdkVersion"] = 34
ext["androidMinSdkVersion"] = 24
ext["androidTargetSdkVersion"] = 34
ext["androidCoreKtxVersion"] = "1.9.0"
ext["androidAppcompatVersion"] = "1.4.1"
ext["androidMaterialVersion"] = "1.6.0"
ext["daggerHiltVersion"] = "2.51"
ext["hiltCompilerVersion"] = "2.51"
ext["retrofitVersion"] = "2.9.0"
ext["okhttpVersion"] = "4.12.0"
ext["glideVersion"] = "4.1.1"
