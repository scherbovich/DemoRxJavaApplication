package andrew.developer.demorxjavaapplication.ui.main.domain

import andrew.developer.demorxjavaapplication.data.entity.AlbumsItem
import andrew.developer.demorxjavaapplication.domain.InteractorIml
import andrew.developer.demorxjavaapplication.ui.main.data.MainRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class MainInteractorImpl @Inject constructor(private val repository: MainRepository):
        InteractorIml<MainInteractorOut, List<AlbumsItem>>(),
        MainInteractor {

    override fun loadAlbums() {
        launch( { out.isLoading(it) },
                { out.onLoaded(it) },
                { out.onError(it) } )
    }

    override fun executeSingle(): Single<List<AlbumsItem>> {
        return repository.loadAlbums()
    }

    override fun executeDbSingle(): Single<List<AlbumsItem>> {
        return repository.getAlbums()
    }
}