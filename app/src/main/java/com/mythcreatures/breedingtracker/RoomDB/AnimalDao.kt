package com.mythcreatures.breedingtracker.RoomDB

import androidx.room.*
import com.mythcreatures.breedingtracker.Constants.Companion.animalTableName

@Dao
interface AnimalDao {

    @Query("SELECT * FROM $animalTableName")
    fun getAll(): List<AnimalEntity>

    @Query("SELECT * FROM $animalTableName WHERE animal_name LIKE :animalName")
    fun getAnimal( animalName: String): AnimalEntity

    @Insert
    fun insertAll( vararg animal: AnimalEntity )

    @Delete
    fun delete( animal: AnimalEntity )

    @Update
    fun updateAll( vararg animal: AnimalEntity)
}