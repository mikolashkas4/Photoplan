package com.example.photoplan.mvp.views

import android.content.ContentResolver
import android.content.Context
import android.content.Intent
import android.net.Uri

interface iMainActivityPresenter {
    fun renameSection()
    fun renameLocation()
    fun showFullPhoto()
    fun addFolder()
    fun putPhoto(uriPhoto:Uri, contentResolver: ContentResolver, context: Context)
    fun deletePhoto()
    fun choosePhoto():Intent
}