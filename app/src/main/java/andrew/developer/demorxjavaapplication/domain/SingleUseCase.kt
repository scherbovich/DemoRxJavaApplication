package andrew.developer.demorxjavaapplication.domain

import io.reactivex.rxjava3.core.Single

interface SingleUseCase<R> {

    fun launch(
            onLoading: (Boolean) -> Unit,
            onSuccess: ((t: R) -> Unit),
            onError: ((t: Throwable) -> Unit)
    )
    fun executeSingle(): Single<R>
    fun executeDbSingle(): Single<R>
}