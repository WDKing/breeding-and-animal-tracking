package com.mythcreatures.breedingtracker.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mythcreatures.breedingtracker.R
import com.mythcreatures.breedingtracker.RoomDB.AppDatabase
import com.mythcreatures.breedingtracker.animals.AnimalListActivity
import com.mythcreatures.breedingtracker.litters.LitterListActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), HomeView {

    lateinit var homePresenter: HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        homePresenter = HomePresenter()

        start_animal_button.setOnClickListener {homePresenter.startActivity(this, AnimalListActivity::class.java)}
        start_litter_button.setOnClickListener {homePresenter.startActivity(this, LitterListActivity::class.java)}
    }
}
