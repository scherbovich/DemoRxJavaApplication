package andrew.developer.demorxjavaapplication.ui.main.data

import andrew.developer.demorxjavaapplication.data.Repository
import andrew.developer.demorxjavaapplication.data.entity.AlbumsItem
import io.reactivex.rxjava3.core.Single

interface MainRepository: Repository {

    fun loadAlbums(): Single<List<AlbumsItem>>
    fun getAlbums(): Single<List<AlbumsItem>>
}