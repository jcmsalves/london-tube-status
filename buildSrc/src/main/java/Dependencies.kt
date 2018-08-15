object PluginDependencies {
    val android = "com.android.tools.build:gradle:${Versions.gradleAndroidPlugin}"
    val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
}

object ProjectModules {
    val data = ":data"
    val domain = ":domain"
}

object ProjectDependencies {
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jre7:${Versions.kotlin}"
    val ktlint = "com.github.shyiko:ktlint:${Versions.ktlint}"

    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val rxJava2Adapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    val gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"

    val daggerAndroid = "com.google.dagger:dagger-android:${Versions.dagger}"
    val daggerAndroidSupport = "com.google.dagger:dagger-android-support:${Versions.dagger}"
    val daggerAnnotationProcessor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"
    val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    val javaInject = "javax.inject:javax.inject:${Versions.javaxInject}"

    val rxJava2 = "io.reactivex.rxjava2:rxjava:${Versions.rxJava}"
    val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"

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
}

object Versions {
    val gradleAndroidPlugin = "3.0.1"

    val compileSdk = 27
    val targetSdk = 27
    val minSdkVersion = 21
    val releaseVersionCode = 1
    val releaseVersionName = "1.0.0"

    val supportLibrary = "27.1.1"
    val kotlin = "1.2.30"
    val retrofit = "2.4.0"
    val rxJava = "2.1.12"
    val rxAndroid = "2.0.2"
    val loggingInterceptor = "3.10.0"
    val dagger = "2.13"
    val javaxInject = "1"
    val ktlint = "0.20.0"

    val junit = "4.12"
    val androidTestRunner = "1.0.1"
    val espresso = "3.0.1"
    val assertJ = "3.9.1"
    val mockito = "2.18.0"
    val mockitoKotlin = "1.5.0"
    val kakao = "1.4.0"
}


