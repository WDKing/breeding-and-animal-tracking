package com.mythcreatures.breedingtracker.RoomDB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mythcreatures.breedingtracker.Constants.Companion.animalTableName
import java.util.*

@Entity(tableName = animalTableName)
data class AnimalEntity(
        @PrimaryKey(autoGenerate = true)
        var id: Int = 0,
        @ColumnInfo(name = "animal_name")
        var animalName: String,
        @ColumnInfo(name = "animal_description")
        var animalDescription: String
        )
