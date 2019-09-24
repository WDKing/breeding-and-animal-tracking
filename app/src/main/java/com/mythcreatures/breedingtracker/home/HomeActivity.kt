package com.mythcreatures.breedingtracker.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mythcreatures.breedingtracker.R
import com.mythcreatures.breedingtracker.animals.AnimalsActivity
import com.mythcreatures.breedingtracker.litters.LitterActivity
import kotlinx.android.synthetic.main.activity_start.*

class HomeActivity : AppCompatActivity(), HomeView {

    lateinit var homePresenter: HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        homePresenter = HomePresenter()

        start_animal_button.setOnClickListener {homePresenter.startActivity(this, AnimalsActivity::class.java)}
        start_litter_button.setOnClickListener {homePresenter.startActivity(this, LitterActivity::class.java)}
    }
}
