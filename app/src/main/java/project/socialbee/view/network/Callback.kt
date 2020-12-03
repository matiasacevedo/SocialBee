package project.socialbee.view.network

interface Callback<T> {
    fun onSuccess(result: T?)

    fun onFailed(exception: Exception)
}