package com.mythcreatures.breedingtracker.animals

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mythcreatures.breedingtracker.R

class AnimalListActivity : AppCompatActivity(), AnimalListView {

    lateinit var animalListPresenter: AnimalListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_animal)

        animalListPresenter = AnimalListPresenter()
    }
}
