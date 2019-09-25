package com.mythcreatures.breedingtracker.RoomDB

import androidx.room.*
import com.mythcreatures.breedingtracker.Constants.Companion.animalTableName

@Dao
interface AnimalDao {

    @Query("SELECT * FROM $animalTableName")
    fun getAll(): List<AnimalEntity>

    @Insert
    fun insertAll( vararg animal: AnimalEntity )

    @Delete
    fun delete( animal: AnimalEntity )

}