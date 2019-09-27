package com.mythcreatures.breedingtracker.RoomDB

import androidx.room.*
import com.mythcreatures.breedingtracker.util.Constants.Companion.litterTableName

@Dao
interface LitterDao {

    @Query("SELECT * FROM $litterTableName")
    fun getAll(): List<LitterEntity>

    @Insert
    fun insertAll( vararg animal: LitterEntity )

    @Delete
    fun delete( animal: LitterEntity )

}