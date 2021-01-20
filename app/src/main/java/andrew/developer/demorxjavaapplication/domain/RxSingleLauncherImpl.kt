package andrew.developer.demorxjavaapplication.domain

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

abstract class RxSingleLauncherImpl<R>: RxSingleLauncher<R>, RxDisposeBagImpl() {

    override fun launch(
            onLoading: (Boolean) -> Unit,
            onSuccess: ((t: R) -> Unit),
            onError: ((t: Throwable) -> Unit)
    ) {
        disposeLast()
        lastDisposable = executeSingle()
                .onErrorResumeNext { executeDbSingle() }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { onLoading(true) }
                .doOnTerminate { onLoading(false) }
                .subscribe(onSuccess, onError)

        lastDisposable?.let {
            compositeDisposable.add(it)
        }
    }
}
