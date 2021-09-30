buildscript {
	val kotlin_version by extra("1.5.21")
	repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21")
        classpath("com.android.tools.build:gradle:4.2.2")
        classpath("io.insert-koin:koin-gradle-plugin:${Versions.koin}")
        classpath("com.squareup.sqldelight:gradle-plugin:${Versions.sqlDelight}")
    }

}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}