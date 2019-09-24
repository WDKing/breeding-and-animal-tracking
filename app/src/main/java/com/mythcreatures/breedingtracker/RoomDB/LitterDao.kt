package com.mythcreatures.breedingtracker.RoomDB

import androidx.room.*
import com.mythcreatures.breedingtracker.Constants.Companion.litterTableName

@Dao
interface LitterDao {

    @Query("SELECT * FROM $litterTableName")
    fun getAll(): List<LitterEntity>

    @Query("SELECT * FROM $litterTableName WHERE litter_id LIKE :litterId")
    fun getLitter( litterId: String): LitterEntity

    @Insert
    fun insertAll( vararg animal: LitterEntity )

    @Delete
    fun delete( animal: LitterEntity )

    @Update
    fun updateAll( vararg animal: LitterEntity)
}