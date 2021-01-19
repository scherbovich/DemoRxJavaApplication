package andrew.developer.demorxjavaapplication.ui.main.data

import andrew.developer.demorxjavaapplication.api.Api
import andrew.developer.demorxjavaapplication.data.entity.AlbumsItem
import andrew.developer.demorxjavaapplication.storage.dao.AlbumDao
import andrew.developer.demorxjavaapplication.ui.main.domain.MainRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val dataBase: AlbumDao,
    private val api: Api
) : MainRepository {

    override fun loadAlbums(): Single<List<AlbumsItem>> {
        return api.getAlbums().map { items ->
            items.onEach {
                dataBase.insert(MainMapper().mapToDB(it))
            }
        }
    }

    override fun getAlbums(): Single<List<AlbumsItem>> {
        return Single.fromCallable { dataBase.getAlbums()
            ?.map { list -> MainMapper().mapToModel(list) } as ArrayList? }
    }
}