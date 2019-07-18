package com.jpatoc.eprofiler.mvp

import com.jpatoc.eprofiler.Collaborator
import com.jpatoc.eprofiler.User

interface CollaboratorMVPView {
    fun fetchedCollaborators(collaborators: List<User>)
    fun showEmptyMessage()
}