package com.example.photoplan

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import java.io.FileNotFoundException
import java.lang.Exception


class MainActivity : AppCompatActivity() {
    public lateinit var fireBaseAdapter:FireBaseAdapter;
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        lateinit var addButton:ImageButton;

        addButton = findViewById(R.id.addButton);

        addButton.setOnClickListener {

            val intent = AddPhoto.openFileChooser();

            startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1)
        }

    }



    private fun openFileChooser() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_PICK
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1)

    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && data != null) {
            fireBaseAdapter = FireBaseAdapter()
            var imageUri = data.data as Uri
            Toast.makeText(this, imageUri.toString(), Toast.LENGTH_SHORT).show()
            try {
                fireBaseAdapter.UploadFile(imageUri,contentResolver,this)
            }
            catch (e:Exception)
            {
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }
        }

    }

}