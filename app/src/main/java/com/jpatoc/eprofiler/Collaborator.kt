package com.jpatoc.eprofiler

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Collaborator(var id: Long = 0,
                   var fullName: String,
                   var position: String,
                   var imageResourceId: Int? = null) : Serializable

class UserResponse(
        @SerializedName("results")
        var results: List<User>
) : Serializable

class User(
        @SerializedName("name")
        var name: UserName,

        @SerializedName("picture")
        var picture: Picture
) : Serializable

class UserName(
        @SerializedName("title")
        var title: String,

        @SerializedName("first")
        var first: String,

        @SerializedName("last")
        var last: String
) : Serializable

class Picture(
        @SerializedName("large")
        var large: String,

        @SerializedName("medium")
        var medium: String,

        @SerializedName("thumbnail")
        var thumbnail: String
) : Serializable