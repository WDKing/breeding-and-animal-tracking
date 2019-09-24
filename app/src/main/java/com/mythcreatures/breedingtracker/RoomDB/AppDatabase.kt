package com.mythcreatures.breedingtracker.RoomDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(AnimalEntity::class, LitterEntity::class), version = 1)
public abstract class AppDatabase : RoomDatabase() {
    abstract fun animalDao(): AnimalDao
    abstract fun litterDao(): LitterDao

    companion object {
        private val DB_NAME = "breeder_db"
        @Volatile private var appDatabaseInstance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if ( appDatabaseInstance == null ) {
                appDatabaseInstance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        DB_NAME).build()
            }
            return (appDatabaseInstance as AppDatabase)
        }
    }
}