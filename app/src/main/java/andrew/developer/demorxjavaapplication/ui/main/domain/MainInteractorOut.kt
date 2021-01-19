package andrew.developer.demorxjavaapplication.ui.main.domain

import andrew.developer.demorxjavaapplication.data.entity.AlbumsItem
import andrew.developer.demorxjavaapplication.domain.InteractorOut
import io.reactivex.rxjava3.core.Single

interface MainInteractorOut: InteractorOut {

    fun isLoading(loading: Boolean)
    fun onLoaded(albums: List<AlbumsItem>)
    fun onError(e: Throwable)
}
