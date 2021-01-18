package andrew.developer.demorxjavaapplication.di

import andrew.developer.demorxjavaapplication.storage.AppDatabase
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class StorageModule {

    @Provides
    @Singleton
    fun provideAppDatabase(context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "database")
            .build()
}