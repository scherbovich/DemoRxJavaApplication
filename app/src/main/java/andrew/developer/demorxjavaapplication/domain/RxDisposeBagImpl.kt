package andrew.developer.demorxjavaapplication.domain

import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

abstract class RxDisposeBagImpl: RxDisposeBag {
    protected var lastDisposable: Disposable? = null
    protected val compositeDisposable = CompositeDisposable()

    override fun disposeLast() {
        lastDisposable?.let {
            if (!it.isDisposed) {
                it.dispose()
            }
        }
    }

    override fun dispose() {
        compositeDisposable.clear()
    }
}
