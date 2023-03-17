
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.10"
    id("org.jetbrains.compose") version "1.3.1"
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
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-swing:1.6.4")
    implementation("com.google.code.gson:gson:2.10")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "18"
}

compose.desktop {
    application {
        mainClass = "xyz.atnrch.wrench.WrenchApp"
        nativeDistributions {
            includeAllModules = true
            targetFormats(TargetFormat.AppImage)
            packageName = "Wrench"
            packageVersion = "1.0.0"
        }
    }
}