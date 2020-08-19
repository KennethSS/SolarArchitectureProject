package com.solar.remote.retrofit

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {
    private const val CONNECTION_TIMEOUT = 10L
    private const val WRITE_TIMEOUT = 30L
    private const val READ_TIMEOUT = 30L

    const val HOST = "https://api.spotify.com/"
    const val HOST_URL = "http://192.168.10.164:8080/"

    inline fun <reified T>provideAppService(isDebug: Boolean): T  {
        val retrofit = provideRetrofit(
            buildOkHttpInterceptor(isDebug),
            HOST_URL
        )
        return retrofit.create(T::class.java)
    }

    fun provideRetrofit(okHttpClient: OkHttpClient, baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(GsonConverter.converter)
            .baseUrl(baseUrl)
            .build()
    }

    fun buildOkHttpInterceptor(isDebug: Boolean): OkHttpClient {
        val httpClientBuilder = OkHttpClient.Builder()
            .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(AddCookiesInterceptor())
            .authenticator(TokenAuthenticator())
            //.addNetworkInterceptor(StethoInterceptor())

        if (isDebug) {
            httpClientBuilder
                //.addNetworkInterceptor(StethoInterceptor()) // Facebook
                .addNetworkInterceptor(
                    HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY)
                )
        }

        httpClientBuilder.addNetworkInterceptor { chain ->
            val request = chain.request()
            val builder: Request.Builder = request.newBuilder()
            chain.proceed(builder.build())
        }

        return httpClientBuilder.build()
    }
}