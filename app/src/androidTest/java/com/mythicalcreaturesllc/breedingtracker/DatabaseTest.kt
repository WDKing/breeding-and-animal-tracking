package com.mythcreatures.breedingtracker

import android.content.Context
import android.util.Log
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mythcreatures.breedingtracker.RoomDB.*
import org.junit.After
import org.junit.Assert

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class DatabaseTest {

    private lateinit var appDatabase: AppDatabase
    private lateinit var animalDao: AnimalDao
    private lateinit var litterDao: LitterDao

    @Before
    fun setup() {
        val context: Context = ApplicationProvider.getApplicationContext()

        try {
            appDatabase = Room.inMemoryDatabaseBuilder(context,
                AppDatabase::class.java).allowMainThreadQueries().build()
        } catch (e: Exception) {
            Log.i("InstrumentedTest", e.message)
        }

        animalDao = appDatabase.animalDao()
        litterDao = appDatabase.litterDao()
    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext: Context = ApplicationProvider.getApplicationContext()
        assertEquals("com.mythcreatures.breedingtracker", appContext.packageName)
    }

    @Test
    fun testAddingAnimalDao() {
        val preInsertList = animalDao.getAll()

        val animal = AnimalEntity("Rat name", "Rat description")
        animalDao.insertAll(animal)

        Assert.assertEquals(1, animalDao.getAll().size)

        animalDao.insertAll(animal, animal)

        Assert.assertEquals(3, animalDao.getAll().size)
    }

    @Test
    fun testAddingRetrievingAnimalDao() {
        val preInsertList = animalDao.getAll()

        val animal = AnimalEntity("Rat name", "Rat description")
        animalDao.insertAll(animal)

        val postInsertList = animalDao.getAll()
        val sizeDifference = postInsertList.size - preInsertList.size

        Assert.assertEquals(1, sizeDifference)
        Assert.assertEquals("Rat name", postInsertList[0].animalName)
        Assert.assertEquals("Rat description", postInsertList[0].animalDescription)
    }

    @Test
    fun testAddingDeletingAnimalDao() {
        val preDeleteList = animalDao.getAll()

        val animal = AnimalEntity("Rat name", "Rat description")

        animalDao.insertAll(animal)
        animalDao.delete(animalDao.getAll()[0])

        val postDeleteList = animalDao.getAll()

        Assert.assertEquals(0, postDeleteList.size)
    }

    @Test
    fun testAddingLitterDao() {
        val preInsertList = litterDao.getAll()

        val litter = LitterEntity("Litter description")
        litterDao.insertAll(litter)

        Assert.assertEquals(1, litterDao.getAll().size)

        litterDao.insertAll(litter, litter)

        Assert.assertEquals(3, litterDao.getAll().size)
    }

    @Test
    fun testAddingRetrievingLitterDao() {
        val preInsertList = litterDao.getAll()

        val litter = LitterEntity("Litter description")
        litterDao.insertAll(litter)

        val postInsertList = litterDao.getAll()
        val sizeDifference = postInsertList.size - preInsertList.size

        Assert.assertEquals(1, sizeDifference)
        Assert.assertEquals("Litter description", postInsertList[0].litterDescription)
    }

    @Test
    fun testAddingDeletingLitterDao() {
        val preDeleteList = litterDao.getAll()

        val litter = LitterEntity("Litter description")

        litterDao.insertAll(litter)
        litterDao.delete(litterDao.getAll()[0])

        val postDeleteList = litterDao.getAll()

        Assert.assertEquals(0, postDeleteList.size)
    }

    @After
    fun tearDown() {
        appDatabase.close()
    }
}
