package com.example.photoplan.mvp.presenter

import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import com.example.photoplan.mvp.models.FireBaseAdapter
import com.example.photoplan.mvp.views.iMainActivityPresenter
import com.google.firebase.firestore.FirebaseFirestore

class MainActivityPresenter():iMainActivityPresenter{
    var fireBaseAdapter = FireBaseAdapter()

    override fun renameSection() {

    }

    override fun renameLocation() {
        TODO("Not yet implemented")
    }

    override fun showFullPhoto() {
        TODO("Not yet implemented")
    }

    override fun addFolder() {
        TODO("Not yet implemented")
    }

    override fun putPhoto(uriPhoto: Uri, contentResolver: ContentResolver, context: Context) {
        fireBaseAdapter.UploadFile(uriPhoto, contentResolver, context)
    }

    override fun deletePhoto() {
        TODO("Not yet implemented")
    }
}