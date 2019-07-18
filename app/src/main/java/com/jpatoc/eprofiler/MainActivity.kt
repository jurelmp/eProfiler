package com.jpatoc.eprofiler

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jpatoc.eprofiler.collaborators.FragmentCollaborators

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragment(FragmentCollaborators())
    }
}