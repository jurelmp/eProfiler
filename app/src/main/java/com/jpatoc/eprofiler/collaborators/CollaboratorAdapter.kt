package com.jpatoc.eprofiler.collaborators

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.jpatoc.eprofiler.Collaborator
import com.jpatoc.eprofiler.R
import com.jpatoc.eprofiler.User
import com.jpatoc.eprofiler.inflate
import com.squareup.picasso.Picasso

class CollaboratorAdapter(var context: Context,
                          var data: List<User>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val itemView = context.inflate(R.layout.item_collaborators)

        val collaborator = getItem(position)
        val fullNameTextView = itemView.findViewById<TextView>(R.id.textview_fullname)
        val positionTextView = itemView.findViewById<TextView>(R.id.textview_position)
        val imageView = itemView.findViewById<ImageView>(R.id.imageView)

        fullNameTextView.text = collaborator.name.first
        positionTextView.text = collaborator.name.last
        Picasso.get().load(collaborator.picture.thumbnail).into(imageView)

        return itemView
    }

    override fun getItem(position: Int): User {
        return data[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount() = data.size
}