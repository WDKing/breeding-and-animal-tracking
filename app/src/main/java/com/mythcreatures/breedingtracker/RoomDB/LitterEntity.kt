package com.mythcreatures.breedingtracker.RoomDB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mythcreatures.breedingtracker.Constants.Companion.litterTableName

@Entity(tableName = litterTableName)
data class LitterEntity (
        @PrimaryKey(autoGenerate = true)
        var id: Int = 0,
        @ColumnInfo(name = "litter_id")
        var litterId: String
        )