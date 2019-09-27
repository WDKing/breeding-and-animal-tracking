package com.mythcreatures.breedingtracker.animals.new

import android.os.Bundle
import android.os.PersistableBundle
import com.mythcreatures.breedingtracker.R
import com.mythcreatures.breedingtracker.RoomDB.AppDatabase
import com.mythcreatures.breedingtracker.base.BaseActivity

class NewAnimalActivity : BaseActivity(), NewAnimalView {

    lateinit var newAnimalPresenter: NewAnimalPresenter

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        setContentView(R.layout.activity_animal_new)

        newAnimalPresenter = NewAnimalPresenter(this, AppDatabase.getInstance(getContext()))
    }
}