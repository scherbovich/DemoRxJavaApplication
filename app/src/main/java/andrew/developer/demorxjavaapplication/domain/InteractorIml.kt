package andrew.developer.demorxjavaapplication.domain

import andrew.developer.demorxjavaapplication.data.entity.AlbumsItem

abstract class InteractorIml<T : InteractorOut, R> : Interactor<T>, SingleUseCaseImpl<R>() {

    protected lateinit var out: T

    override fun setupInteractorOut(out: T) {
        this.out = out
    }
}