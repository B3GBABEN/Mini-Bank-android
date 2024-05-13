package com.b3g.fawri.minibank.core.bases.errors

sealed class Resource<T>(val data: T? = null, val message: DataError? = null) {
    class Success<T>(data: T) : Resource<T>(data = data)
    class Error<T>(message: DataError, data: T? = null) : Resource<T>(data = data, message = message)
    class Loading<T>(data: T? = null) : Resource<T>(data = data)
}