package com.example.photoplan.mvp.models

import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import android.webkit.MimeTypeMap
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
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
            fileRef.child("Photos").putFile(imageUri).addOnSuccessListener() { taskSnapshot ->
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

    public fun putFolder(){

    }



    public fun renameDocument(newName:String, oldName:String){
        var db = FirebaseFirestore.getInstance()
        var data:HashMap<String, Any>
        hashMapOf(db.collection("Gomel").document(oldName).
       /* db.collection("Gomel").document(oldName).delete()
        db.collection("Gomel").document(newName).set(data)*/

    }



    public fun renameFolder()
    {
        var db = FirebaseFirestore.getInstance()
        // Create a new user with a first and last name

        // Create a new user with a first and last name
        val user: MutableMap<String, Any> = HashMap()
        user["first"] = "Ada"
        user["last"] = "Lovelace"
        user["born"] = 1815

// Add a new document with a generated ID

// Add a new document with a generated ID
        val location:MutableMap<String,Any> = HashMap()
        val location2:MutableMap<String,Any> = HashMap()
        location["photo1"] = "path222"
        location2["photo1"] = "path2"
        /*db.collection("Location").document("Minsk").collection("Tanka 2").add(location)
        db.collection("Location").document("Gomel").collection("Lenina 28").add(location)
        db.collection("Location").document("Gomel").collection("Lenina 28").add(location)
        db.collection("Location").document("Gomel").collection("Lenina 28").add(location2)*//*
        var m = db.collection("Location").document("Gomel").collection("Lenina 28").get()

        db.collection("Location").document("Gomel").collection("Lenina 28")
        */
        renameDocument("Lenina 28", "Lenina 23")

        //db.collection("Location").document("Gomel").set(location)
       // db.collection("Location").document("Gomel").update("photo1","asdds")



        /*
        db.collection("Location").document().collection("Lenina 13").add(m)
        db.collection("Location").document("Street").delete()
                .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully deleted!") }
                .addOnFailureListener { e -> Log.w(TAG, "Error deleting document", e) };
*/

    }

}