package com.welooky.welook.api

import okhttp3.*
import java.net.SocketTimeoutException

/**
 * @author zhangsheng
 * @date 2019/5/21
 */
class ExceptionInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return try {
            chain.proceed(chain.request())
        } catch (e: Exception) {
            var message = e.message
            if (e is SocketTimeoutException) {
                message = "网络连接超时"
            }
            val content = """
                {"content":null,"code":-1,"message":"$message"}
            """.trimIndent()
            Response.Builder()
                .request(Request.Builder().url("http://exception").build())
                .protocol(Protocol.HTTP_2).code(200).message("request exception")
                .body(ResponseBody.create(MediaType.parse("application/json"), content))
                .build()
        }
    }
}