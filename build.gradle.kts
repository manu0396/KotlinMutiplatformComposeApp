buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${property("androidGradlePluginVersion")}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${property("kotlinVersion")}")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${property("hiltCompilerVersion")}")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

subprojects {
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "17"
        }
    }

    tasks.withType<JavaCompile> {
        options.release.set(17)
    }
}
