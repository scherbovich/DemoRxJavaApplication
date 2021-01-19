package andrew.developer.demorxjavaapplication.ui.main.domain

import andrew.developer.demorxjavaapplication.data.entity.AlbumsItem
import andrew.developer.demorxjavaapplication.domain.Repository
import io.reactivex.rxjava3.core.Single

interface MainRepository: Repository {

    fun loadAlbums(): Single<List<AlbumsItem>>
    fun getAlbums(): Single<List<AlbumsItem>>
}