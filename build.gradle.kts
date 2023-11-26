
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.10"
    id("org.jetbrains.compose") version "1.5.2"
}

group = "xyz.atnrch"
version = "dev"

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
    implementation(compose.desktop.currentOs)
    implementation(compose.materialIconsExtended)
    implementation(compose.material3)
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-swing:1.7.3")
    implementation("com.google.code.gson:gson:2.10.1")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "18"
}

compose.desktop {
    application {
        mainClass = "xyz.atnrch.wrench.Wrench"
        nativeDistributions {
            includeAllModules = true
            targetFormats(TargetFormat.AppImage)
            packageName = "Wrench"
            packageVersion = "1.0.0"
        }
    }
}