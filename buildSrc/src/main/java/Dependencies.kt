object PluginDependencies {
    val android = "com.android.tools.build:gradle:${Versions.gradleAndroidPlugin}"
    val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
}

object ProjectModules {
    val data = ":data"
    val domain = ":domain"
}

object ProjectDependencies {
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    val ktlint = "com.github.shyiko:ktlint:${Versions.ktlint}"

    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"

    val koin = "org.koin:koin-android:${Versions.koin}"
    val koinViewModel = "org.koin:koin-android-viewmodel:${Versions.koin}"

    val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    val coroutinesAdapter = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.coroutinesAdapter}"

    val supportAppCompat = "com.android.support:appcompat-v7:${Versions.supportLibrary}"
    val supportDesign = "com.android.support:design:${Versions.supportLibrary}"
    val recyclerView = "com.android.support:recyclerview-v7:${Versions.supportLibrary}"
    val junit = "junit:junit:${Versions.junit}"

    val assertJ = "org.assertj:assertj-core:${Versions.assertJ}"
    val mockito = "org.mockito:mockito-core:${Versions.mockito}"
    val mockitoKotlin = "com.nhaarman:mockito-kotlin:${Versions.mockitoKotlin}"
    val androidTestRunner = "com.android.support.test:runner:${Versions.androidTestRunner}"
    val espresso = "com.android.support.test.espresso:espresso-core:${Versions.espresso}"
    val kakao = "com.agoda.kakao:kakao:${Versions.kakao}"

    val lifecycle = "android.arch.lifecycle:extensions:${Versions.lifecycle}"
    val lifecycleTesting = "android.arch.core:core-testing:${Versions.lifecycle}"
}

object Versions {
    val gradleAndroidPlugin = "3.0.1"

    val compileSdk = 27
    val targetSdk = 27
    val minSdkVersion = 21
    val releaseVersionCode = 2
    val releaseVersionName = "1.0.1"

    val supportLibrary = "27.1.1"
    val kotlin = "1.3.0"
    val retrofit = "2.4.0"
    val coroutines = "1.0.1"
    val coroutinesAdapter = "0.9.2"

    val loggingInterceptor = "3.10.0"
    val ktlint = "0.20.0"
    val koin = "1.0.1"
    val lifecycle = "1.1.1"

    val junit = "4.12"
    val androidTestRunner = "1.0.1"
    val espresso = "3.0.1"
    val assertJ = "3.9.1"
    val mockito = "2.18.0"
    val mockitoKotlin = "1.5.0"
    val kakao = "1.4.0"
}


