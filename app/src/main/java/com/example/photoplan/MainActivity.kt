package com.example.photoplan

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        var addButton = findViewById<Button>(R.id.addButton);
        addButton.setOnClickListener {
            val intent = AddPhoto.openFileChooser();
            startActivityForResult(intent,AddPhoto.PICK_IMAGE_REQUEST)
        }
        
    }
}