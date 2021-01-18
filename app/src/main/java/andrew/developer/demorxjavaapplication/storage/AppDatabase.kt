package andrew.developer.demorxjavaapplication.storage

import andrew.developer.demorxjavaapplication.storage.dao.AlbumDao
import andrew.developer.demorxjavaapplication.storage.entity.AlbumEntity
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(version = 1, exportSchema = false, entities = [AlbumEntity::class])
abstract class AppDatabase: RoomDatabase() {

    abstract fun albumDao(): AlbumDao
}