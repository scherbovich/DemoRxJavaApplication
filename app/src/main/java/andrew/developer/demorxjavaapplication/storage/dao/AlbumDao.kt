package andrew.developer.demorxjavaapplication.storage.dao

import andrew.developer.demorxjavaapplication.storage.entity.AlbumEntity
import androidx.room.Dao
import androidx.room.Query

@Dao
interface AlbumDao: BaseDao<AlbumEntity> {

    @Query("SELECT * FROM album WHERE id = :id")
    fun getAlbum(id: Int): AlbumEntity?

    @Query("SELECT * FROM album")
    fun getAlbums(): List<AlbumEntity>?
}