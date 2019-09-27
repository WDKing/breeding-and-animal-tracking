package com.mythcreatures.breedingtracker.RoomDB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mythcreatures.breedingtracker.util.Constants.Companion.litterTableName

@Entity(tableName = litterTableName)
data class LitterEntity (
        @ColumnInfo(name = "litter_description")
        var litterDescription: String,
        @PrimaryKey(autoGenerate = true)
        var id: Int = 0
        )