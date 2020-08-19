package com.solar.remote.retrofit

import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route

class TokenAuthenticator : Authenticator {
    override fun authenticate(route: Route?, response: Response): Request? {
        if (response.code() == 401) {
            val refreshToken = "" //Prefs.getString(Values.REFRESH_TOKEN, "")

            /*val result = ApiClient.getSpotifyService(MemberService::class.java).updateTokenCall(JsonObject().apply {
                addProperty("refresh", refreshToken)
            }).execute()

            if (result.body() != null) {
                //Prefs.putString(Values.ACCESS_TOKEN, result.body()?.data?.access)
                //Prefs.putString(Values.REFRESH_TOKEN, result.body()?.data?.refresh)
            }*/
        }

        val token = "" // Prefs.getString(Values.ACCESS_TOKEN, "")

        /*return response.request()
                .newBuilder()
                .header("Authorization", "Bearer $token")
                .build()*/

        return null
    }
}