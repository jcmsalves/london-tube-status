package com.jcmsalves.data.di

import com.jcmsalves.data.BuildConfig
import com.jcmsalves.data.interceptors.AuthInterceptor
import com.jcmsalves.data.status.StatusService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { createOkHttpClient() }
    single { createRetrofit(get()) }
    single { createStatusService(get()) }
}

fun createOkHttpClient(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
    val clientBuilder = OkHttpClient.Builder()
    clientBuilder.addInterceptor(AuthInterceptor())
    if (BuildConfig.DEBUG) {
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        clientBuilder.addInterceptor(httpLoggingInterceptor)
    }
    return clientBuilder.build()
}

fun createRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
    .baseUrl(Properties.BASE_URL)
    .client(okHttpClient)
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .build()

fun createStatusService(retrofit: Retrofit): StatusService = retrofit.create(StatusService::class.java)

object Properties {
    const val BASE_URL = "https://api.tfl.gov.uk/"
}
