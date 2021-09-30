plugins {
    id("com.android.application")
    kotlin("android")
	id("kotlin-android")
}

android {
    compileSdk = AndroidConfigs.compileSdkVersion

    defaultConfig {
        applicationId = AndroidConfigs.applicationId
        minSdk = AndroidConfigs.minSdkVersion
        targetSdk = AndroidConfigs.targetSdkVersion
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

}

dependencies {
    implementation(project(":core"))
	implementation("androidx.appcompat:appcompat:1.3.1")
	implementation("com.google.android.material:material:1.4.0")
	implementation("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.extra["kotlin_version"]}")
	implementation("androidx.constraintlayout:constraintlayout:2.1.0")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    with(Dependencies) {
        implementation(androidMaterial)
        implementation(androidAppCompat)
        implementation(constraintLayout)
        implementation(glide)

        implementation(fragmentNavigation)
        implementation(androidNavigation)
        implementation(liveDataKtx)
        implementation(viewModelKtx)
        implementation(lifecycleKtx)

        implementation(ktorAndroid)
        implementation(koinAndroid)

        implementation(rxAndroid)
        implementation(rxJava)
        implementation(androidCoroutine)

        implementation(groupie)
        implementation(groupieViewBinding)

        implementation(viewBindingDelegate)
    }
}







