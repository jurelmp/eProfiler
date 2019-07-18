package com.jpatoc.eprofiler.collaborator

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jpatoc.eprofiler.Collaborator
import com.jpatoc.eprofiler.R
import com.jpatoc.eprofiler.User
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_collaborator.*

class CollaboratorActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_COLLABORATOR: String = "EXTRA_COLLABORATOR"

        fun start(activity: Activity, collaborator: User): Intent {
            val intent = Intent(activity, CollaboratorActivity::class.java)
            intent.putExtra(EXTRA_COLLABORATOR, collaborator)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collaborator)

        val collaborator = intent.getSerializableExtra(EXTRA_COLLABORATOR) as User
        textview_fullname.text = collaborator.name.first
        textview_position.text = collaborator.name.last
        Picasso.get().load(collaborator.picture.large).into(imageView2)
    }
}