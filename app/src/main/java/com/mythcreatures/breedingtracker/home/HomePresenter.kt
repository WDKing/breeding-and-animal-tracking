package com.mythcreatures.breedingtracker.home

import com.mythcreatures.breedingtracker.base.BasePresenter
import com.mythcreatures.breedingtracker.RoomDB.AnimalEntity
import com.mythcreatures.breedingtracker.RoomDB.AppDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomePresenter(homeView: HomeView,
                    appDatabase: AppDatabase):
    BasePresenter {

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


}
