package andrew.developer.demorxjavaapplication.domain

abstract class InteractorIml<T : InteractorOut, R> : Interactor<T>, RxSingleLauncherImpl<R>() {

    protected lateinit var out: T

    override fun setupInteractorOut(out: T) {
        this.out = out
    }
}