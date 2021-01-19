package andrew.developer.demorxjavaapplication.ui.main

import andrew.developer.demorxjavaapplication.data.entity.AlbumsItem
import andrew.developer.demorxjavaapplication.ui.main.domain.MainInteractor
import andrew.developer.demorxjavaapplication.ui.main.domain.MainInteractorOut
import andrew.developer.demorxjavaapplication.utils.SingleLiveEvent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(private val interactor: MainInteractor) : ViewModel(),
        MainInteractorOut {
    private val loadingMut = MutableLiveData<Boolean>()
    private val errorMut: MutableLiveData<Unit> = SingleLiveEvent()
    private val dataMut = MutableLiveData<List<AlbumsItem>>()

    val loading: LiveData<Boolean> get() = loadingMut
    val error: LiveData<Unit> get() = errorMut
    val data: LiveData<List<AlbumsItem>> get() = dataMut

    init {
        interactor.setupInteractorOut(this)
        interactor.loadAlbums()
    }

    fun onRefresh() {
        interactor.loadAlbums()
    }

    override fun isLoading(loading: Boolean) {
        loadingMut.value = loading
    }

    override fun onLoaded(albums: List<AlbumsItem>) {
        dataMut.value = albums
    }

    override fun onError(e: Throwable) {
        errorMut.value = Unit
    }
}