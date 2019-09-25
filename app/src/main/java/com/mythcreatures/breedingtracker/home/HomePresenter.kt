package com.mythcreatures.breedingtracker.home

import android.content.Context
import android.content.Intent
import androidx.core.app.ActivityCompat
import com.mythcreatures.breedingtracker.BasePresenter
import com.mythcreatures.breedingtracker.RoomDB.AnimalEntity
import com.mythcreatures.breedingtracker.RoomDB.AppDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomePresenter(homeView: HomeView,
                    appDatabase: AppDatabase): BasePresenter {

    init {
        GlobalScope.launch {
            val animalList: List<AnimalEntity> = appDatabase.animalDao().getAll()

            if (animalList.size == 0) {
                appDatabase.animalDao().insertAll(
                    AnimalEntity(
                        "Example Rat", "Example Description"
                    )
                )
            }
        }
    }

    fun startActivity(context: Context, classToStart: Class<*>) {
        val intent = Intent(context, classToStart)
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        ActivityCompat.startActivity(context, intent, null)
    }
}
