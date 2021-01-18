package andrew.developer.demorxjavaapplication.ui.main.domain

import andrew.developer.demorxjavaapplication.domain.Interactor

interface MainInteractor: Interactor<MainInteractorOut> {
    fun loadAlbums()
}