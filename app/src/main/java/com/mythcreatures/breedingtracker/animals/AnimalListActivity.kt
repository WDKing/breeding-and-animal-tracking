package com.mythcreatures.breedingtracker.animals

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.mythcreatures.breedingtracker.base.BaseActivity
import com.mythcreatures.breedingtracker.R
import com.mythcreatures.breedingtracker.RoomDB.AppDatabase
import com.mythcreatures.breedingtracker.animals.new.NewAnimalActivity


class AnimalListActivity : BaseActivity(), AnimalListView {

    lateinit var animalListPresenter: AnimalListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_animal)

        animalListPresenter = AnimalListPresenter( this, AppDatabase.getInstance(getContext()) )
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.animal_list_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item?.itemId) {
            R.id.menuitem_animal_new -> {
                animalListPresenter.startActivity(getContext(), NewAnimalActivity::class.java)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}
