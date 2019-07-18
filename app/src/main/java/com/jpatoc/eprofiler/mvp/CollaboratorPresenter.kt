package com.jpatoc.eprofiler.mvp

import com.jpatoc.eprofiler.Collaborator
import com.jpatoc.eprofiler.UserResponse
import com.jpatoc.eprofiler.api.ServiceManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CollaboratorPresenter(private var collaboratorMVPView: CollaboratorMVPView): Callback<UserResponse> {


    private fun initData(): List<Collaborator> {
        val items = mutableListOf(
                Collaborator(1, "John Doe", "Developer",
                        android.R.drawable.ic_menu_report_image),
                Collaborator(2, "Jane Doe", "Database Admin",
                        android.R.drawable.ic_btn_speak_now),
                Collaborator(3, "Brock Doe", "Network Admin",
                        android.R.drawable.ic_delete),
                Collaborator(4, "Ash Doe", "Network Admin",
                        android.R.drawable.ic_dialog_alert),
                Collaborator(5, "Misty Doe", "Network Admin",
                        android.R.drawable.ic_dialog_email),
                Collaborator(3, "Joy Doe", "Network Admin",
                        android.R.drawable.ic_dialog_info),
                Collaborator(3, "Bill Gates", "Network Admin",
                        android.R.drawable.ic_dialog_map),
                Collaborator(3, "Tim Cook", "Network Admin",
                        android.R.drawable.ic_input_add),
                Collaborator(3, "Steve Jobs", "Network Admin",
                        android.R.drawable.ic_lock_idle_lock),
                Collaborator(3, "Br", "Network Admin",
                        android.R.drawable.ic_media_next),
                Collaborator(3, "Brock Doe", "Network Admin",
                        android.R.drawable.ic_menu_agenda))
        return items.toList()
    }

    fun fetchCollaborators() {

        val userApiService = ServiceManager().getUserApiService()

        val users = userApiService.getUsers()

        users.enqueue(this)
    }

    override fun onFailure(call: Call<UserResponse>, t: Throwable) {
        collaboratorMVPView.showEmptyMessage()
    }

    override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
        collaboratorMVPView.fetchedCollaborators(response.body()!!.results)
    }
}