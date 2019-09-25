package com.mythcreatures.breedingtracker.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mythcreatures.breedingtracker.BaseActivity
import com.mythcreatures.breedingtracker.R
import com.mythcreatures.breedingtracker.RoomDB.AppDatabase
import com.mythcreatures.breedingtracker.animals.AnimalListActivity
import com.mythcreatures.breedingtracker.litters.LitterListActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity(), HomeView {

    lateinit var homePresenter: HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        homePresenter = HomePresenter(this, AppDatabase.getInstance(this))

        start_animal_button.setOnClickListener {homePresenter.startActivity( getContext(), AnimalListActivity::class.java )}
        start_litter_button.setOnClickListener {homePresenter.startActivity( getContext(), LitterListActivity::class.java )}
    }
}
