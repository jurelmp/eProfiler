package com.jpatoc.eprofiler

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View

fun AppCompatActivity.addFragment(fragment: Fragment) {
    val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
    fragmentTransaction.add(R.id.fragment_collaborators_container, fragment)
    fragmentTransaction.commit()
}

fun Context.inflate(layoutResource: Int): View {
    val inflater = this.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    return inflater.inflate(layoutResource, null, true)
}