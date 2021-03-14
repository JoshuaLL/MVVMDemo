package com.joshua.mvvm.extension

import com.joshua.mvvm.model.api.ExceptionResult
import com.joshua.mvvm.widget.utility.HttpUtils
import com.joshua.mvvm.widget.utility.HttpUtils.getHttpExceptionData
import retrofit2.HttpException
import timber.log.Timber

infix fun Throwable.handleException(processException: (ExceptionResult) -> Unit): ExceptionResult {
    val result = when (this) {
        is HttpException -> {
            val httpExceptionItem = getHttpExceptionData(this)
            val result = HttpUtils.isRefreshTokenFailed(httpExceptionItem.errorItem.code.toString())
            Timber.d("isRefreshTokenFailed: $result")
            if (result) {
                ExceptionResult.RefreshTokenExpired
            } else {
                ExceptionResult.HttpError(httpExceptionItem)
            }
        }
        else -> {
            ExceptionResult.Crash(this)
        }
    }

    processException(result)

    return result
}