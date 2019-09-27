package com.mythcreatures.breedingtracker.RoomDB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mythcreatures.breedingtracker.util.Constants.Companion.animalTableName

@Entity(tableName = animalTableName)
data class AnimalEntity(
        @ColumnInfo(name = "animal_name")
        var animalName: String,
        @ColumnInfo(name = "animal_description")
        var animalDescription: String,
        @PrimaryKey(autoGenerate = true)
        var id: Int = 0
        )
