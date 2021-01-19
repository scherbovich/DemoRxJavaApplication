package andrew.developer.demorxjavaapplication.ui.main.di

import andrew.developer.demorxjavaapplication.api.Api
import andrew.developer.demorxjavaapplication.di.FragmentScope
import andrew.developer.demorxjavaapplication.storage.AppDatabase
import andrew.developer.demorxjavaapplication.storage.dao.AlbumDao
import andrew.developer.demorxjavaapplication.ui.main.data.MainRepository
import andrew.developer.demorxjavaapplication.ui.main.data.MainRepositoryImpl
import andrew.developer.demorxjavaapplication.ui.main.domain.MainInteractor
import andrew.developer.demorxjavaapplication.ui.main.domain.MainInteractorImpl
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @FragmentScope
    @Provides
    fun provideAlbumDao(appDatabase: AppDatabase): AlbumDao =
        appDatabase.albumDao()

    @FragmentScope
    @Provides
    fun provideMainRepository(api: Api, database: AlbumDao): MainRepository =
        MainRepositoryImpl(database, api)

    @FragmentScope
    @Provides
    fun provideMainInteractor(repository: MainRepository): MainInteractor =
        MainInteractorImpl(repository)
}