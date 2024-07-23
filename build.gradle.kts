buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.0.2")
        classpath(kotlin("gradle-plugin", version = extra["kotlinVersion"] as String))
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
