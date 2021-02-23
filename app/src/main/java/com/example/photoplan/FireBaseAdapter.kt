package com.example.photoplan

import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import android.webkit.MimeTypeMap
import android.widget.Toast
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
import java.io.File


public class FireBaseAdapter() {
    private lateinit var storageRef: StorageReference
    private lateinit var riversRef: StorageReference;
    var localFile = File.createTempFile("images", "jpg")


    init {
        storageRef = FirebaseStorage.getInstance().getReference();
        val riversRef: StorageReference = storageRef.child("images/rivers.jpg")

    }

    public fun UploadFile(imageUri: Uri, contentResolver: ContentResolver ,context: Context) {

        if (imageUri != null) {

            var fileRef: StorageReference = storageRef.child(
                System.currentTimeMillis().toString() + "." + getFileExtension(
                    imageUri,
                    contentResolver
                )
            );
            Toast.makeText(context, fileRef.toString(), Toast.LENGTH_SHORT).show()
            fileRef.putFile(imageUri).addOnSuccessListener() { taskSnapshot ->
                Toast.makeText(
                    context,
                    "Uploaded!",
                    Toast.LENGTH_LONG
                ).show()
            }


        }
    }



    private fun getFileExtension(uri: Uri, contentResolver:ContentResolver):String{

        var cR: ContentResolver = contentResolver
        var mime = MimeTypeMap.getSingleton()
        var context:Context
        return mime.getExtensionFromMimeType(cR.getType(uri)).toString()
    }


}