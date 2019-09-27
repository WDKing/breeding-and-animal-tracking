package com.mythcreatures.breedingtracker.base

import android.content.Context
import androidx.appcompat.app.AppCompatActivity

public abstract class BaseActivity : AppCompatActivity(),
    BaseView {

    fun getContext(): Context {
        return this
    }

}
