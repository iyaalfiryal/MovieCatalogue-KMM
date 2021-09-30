/**
 * Created by Uwais Alqadri on September 24, 2021
 */
object Dependencies {

	const val ktxSerialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.serialization}"
	const val ktxCoroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}"
	const val ktxDateTime = "org.jetbrains.kotlinx:kotlinx-datetime:${Versions.dateTime}"

	const val androidMaterial = "com.google.android.material:material:${Versions.material}"
	const val androidAppCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
	const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraint}"
	const val fragmentNavigation = "androidx.navigation:navigation-fragment-ktx:${Versions.navFragment}"
	const val androidNavigation = "androidx.navigation:navigation-ui-ktx:${Versions.navUi}"

	const val lifecycleKtx = "androidx.lifecycle:lifecycle-extensions:2.2.0"
	const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
	const val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"

	const val rxAndroid = "io.reactivex.rxjava2:rxandroid:2.1.1"
	const val rxJava = "io.reactivex.rxjava2:rxjava:2.2.20"
	const val rxKotlin = "io.reactivex.rxjava3:rxkotlin:${Versions.rxKotlin}"
	const val androidCoroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}"

	const val groupie = "com.github.lisawray.groupie:groupie:${Versions.groupie}"
	const val groupieViewBinding = "com.github.lisawray.groupie:groupie-viewbinding:${Versions.groupie}"

	const val viewBindingDelegate = "com.github.kirich1409:viewbindingpropertydelegate:${Versions.viewBinding}"
	const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"

	const val koinCore = "io.insert-koin:koin-core:${Versions.koin}"
	const val koinTest = "io.insert-koin:koin-test:${Versions.koin}"
	const val koinAndroid = "io.insert-koin:koin-android:${Versions.koin}"

	const val ktorCore = "io.ktor:ktor-client-core:${Versions.ktor}"
	const val ktorClientSerialization = "io.ktor:ktor-client-serialization:${Versions.ktor}"
	const val ktorLogging = "io.ktor:ktor-client-logging:${Versions.ktor}"
	const val ktorAndroid = "io.ktor:ktor-client-android:${Versions.ktor}"
	const val ktorIos = "io.ktor:ktor-client-ios:${Versions.ktor}"

	const val sqlRuntime = "com.squareup.sqldelight:runtime:${Versions.sqlDelight}"
	const val sqlCoroutineExtensions = "com.squareup.sqldelight:coroutines-extensions:${Versions.sqlDelight}"
	const val sqlAndroidDriver = "com.squareup.sqldelight:android-driver:${Versions.sqlDelight}"
	const val sqlNativeDriver = "com.squareup.sqldelight:native-driver:${Versions.sqlDelight}"
	const val sqliteDriver = "com.squareup.sqldelight:sqlite-driver:${Versions.sqlDelight}"

	const val kermitLogger = "co.touchlab:kermit:${Versions.kermit}"

}