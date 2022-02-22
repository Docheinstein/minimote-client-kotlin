package org.docheinstein.minimotek.database.server

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ServerDao {
    @Query("SELECT * FROM $TABLE_NAME WHERE $COLUMN_ID = :id")
    fun load(id: Long): Flow<Server>

    @Query("SELECT * FROM $TABLE_NAME")
    fun loadAll(): Flow<List<Server>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(server: Server): Long

    @Delete
    suspend fun delete(server: Server): Int
}