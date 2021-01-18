package andrew.developer.demorxjavaapplication.storage.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy

interface BaseDao<E> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity: E): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity: Collection<E>?): LongArray?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity: List<E>?): LongArray?
}