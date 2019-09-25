package com.mythcreatures.breedingtracker.animals

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mythcreatures.breedingtracker.BaseActivity
import com.mythcreatures.breedingtracker.R
import com.mythcreatures.breedingtracker.RoomDB.AppDatabase
import kotlinx.android.synthetic.main.activity_list_animal.*

class AnimalListActivity : BaseActivity(), AnimalListView {

    lateinit var animalListPresenter: AnimalListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_animal)

        animalListPresenter = AnimalListPresenter( this, AppDatabase.getInstance(getContext()) )
    }

}
