package com.mythcreatures.breedingtracker.animals

import com.mythcreatures.breedingtracker.BasePresenter
import com.mythcreatures.breedingtracker.RoomDB.AnimalDao
import com.mythcreatures.breedingtracker.RoomDB.AnimalEntity
import com.mythcreatures.breedingtracker.RoomDB.AppDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AnimalListPresenter(animalListView: AnimalListView, appDatabase: AppDatabase) : BasePresenter {

    init {
        GlobalScope.launch {
            var animalList: List<AnimalEntity> = appDatabase.animalDao().getAll()

            if (animalList.isEmpty()) {
                val animalDao: AnimalDao = appDatabase.animalDao()

                animalDao.insertAll(AnimalEntity("Example Name", "Example description"))

                animalList = animalDao.getAll()
            }

        }
    }
}
