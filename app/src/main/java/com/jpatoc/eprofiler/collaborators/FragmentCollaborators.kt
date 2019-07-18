package com.jpatoc.eprofiler.collaborators

import android.app.Activity
import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.design.widget.CoordinatorLayout
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import com.jpatoc.eprofiler.Collaborator
import com.jpatoc.eprofiler.R
import com.jpatoc.eprofiler.User
import com.jpatoc.eprofiler.collaborator.CollaboratorActivity
import com.jpatoc.eprofiler.inflate
import com.jpatoc.eprofiler.mvp.CollaboratorMVPView
import com.jpatoc.eprofiler.mvp.CollaboratorPresenter
import kotlinx.android.synthetic.main.appbar.*

class FragmentCollaborators : Fragment(), CollaboratorMVPView {

    private lateinit var listView: ListView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView: View = context!!.inflate(R.layout.fragment_collaborators)
        listView = rootView.findViewById(R.id.listview_collaborators)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        CollaboratorPresenter(this).fetchCollaborators()
    }

    override fun fetchedCollaborators(collaborators: List<User>) {
        listView.adapter = CollaboratorAdapter(context!!,collaborators)

        listView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, _, i, _ ->
            run {
                val user = adapterView.adapter.getItem(i) as User
                startActivity(CollaboratorActivity.start(activity as Activity, user))
            }
        }
    }

    override fun showEmptyMessage() =
            Toast.makeText(context!!, "Empty list of collaborators.", Toast.LENGTH_SHORT).show()

    private fun initAppBar() {
        setHasOptionsMenu(true)
        val activity = activity as AppCompatActivity
        activity.setSupportActionBar(toolbar)
        lockAppBar(appbar)
        appbar.setExpanded(false)

        activity.supportActionBar?.setDisplayHomeAsUpEnabled(false)
        activity.supportActionBar?.setTitle(R.string.collaborators)
    }

    fun lockAppBar(appBarLayout: AppBarLayout, lock: Boolean = true) {
        val params = appBarLayout.layoutParams as CoordinatorLayout.LayoutParams
        params.behavior = params.behavior ?: AppBarLayout.Behavior()
        (params.behavior as AppBarLayout.Behavior).setDragCallback(object : AppBarLayout.Behavior.DragCallback() {
            override fun canDrag(appBarLayout: AppBarLayout): Boolean {
                return !lock
            }
        })
    }
}