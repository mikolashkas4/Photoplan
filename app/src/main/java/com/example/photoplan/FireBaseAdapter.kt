package com.example.photoplan

import android.net.Uri
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
import java.io.File


public class FireBaseAdapter(){
    private lateinit var  storageRef: StorageReference
    private lateinit var riversRef: StorageReference;
    var localFile = File.createTempFile("images", "jpg")


    init {
        storageRef = FirebaseStorage.getInstance().getReference();
        val riversRef: StorageReference = storageRef.child("images/rivers.jpg")

    }

    public fun UploadFile(file:Uri)
    {
        riversRef.putFile(file)
            .addOnSuccessListener(OnSuccessListener<UploadTask.TaskSnapshot> { taskSnapshot -> // Get a URL to the uploaded content
               print("Succes")
            })
            .addOnFailureListener(OnFailureListener {
              print(it.message.toString())
            })
    }
    public fun getFile():File{
        riversRef.getFile(localFile)
            .addOnSuccessListener {
             print("Succes")
            }.addOnFailureListener {
                print(it.message.toString())
            }
        return localFile;
    }

}