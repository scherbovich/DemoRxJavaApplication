package andrew.developer.demorxjavaapplication.domain

interface Interactor<T: InteractorOut> {
    fun setupInteractorOut(out: T)
}