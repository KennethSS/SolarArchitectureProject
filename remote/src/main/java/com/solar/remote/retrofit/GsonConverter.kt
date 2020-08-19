package com.solar.remote.retrofit

import com.google.gson.GsonBuilder
import retrofit2.converter.gson.GsonConverterFactory

internal object GsonConverter {

    private var gsonConverter: GsonConverterFactory =
            GsonConverterFactory.create(
                    GsonBuilder()
                            //.setFieldNamingPolicy(FieldNamingPolicy.)
                            /*.addDeserializationExclusionStrategy(object: ExclusionStrategy {
                                override fun shouldSkipClass(clazz: Class<*>?): Boolean = clazz == User.javaClass
                                override fun shouldSkipField(f: FieldAttributes?): Boolean = false
                            })*/
                            .setPrettyPrinting()
                            .create()
            )

    val converter: GsonConverterFactory
        get() {
            return gsonConverter
        }
}