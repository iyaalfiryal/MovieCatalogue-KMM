pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "MovieCatalogue"
include(":movieAndroid")
include(":movieIos")
include(":core")