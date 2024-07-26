plugins {
    kotlin("multiplatform")
    id("com.google.devtools.ksp")
}

kotlin {
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        val iosMain by creating {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-native:${extra["coroutinesVersion"]}")
                implementation("com.squareup.retrofit2:retrofit:${extra["retrofitVersion"]}")
                implementation("com.squareup.retrofit2:converter-gson:${extra["retrofitVersion"]}")
                implementation("com.squareup.okhttp3:okhttp:${extra["okhttpVersion"]}")
                implementation("com.squareup.okhttp3:logging-interceptor:${extra["okhttpVersion"]}")
                implementation("com.google.zxing:core:${project.extra["zxingVersion"]}") // QR code reading
            }
        }
        val iosTest by creating {
            dependencies {
                implementation(kotlin("test"))
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
