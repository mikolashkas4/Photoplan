package com.example.photoplan

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.photoplan.mvp.models.FireBaseAdapter
import com.example.photoplan.mvp.presenter.MainActivityPresenter
import com.example.photoplan.mvp.views.iMainActivityPresenter
import java.lang.Exception


class MainActivity : AppCompatActivity() {
    //public lateinit var fireBaseAdapter: FireBaseAdapter;


    var mainActivityPresenter:iMainActivityPresenter = MainActivityPresenter()



    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        lateinit var addButton:Button;
        lateinit var addPhotoButton: Button;

        addButton = findViewById(R.id.addButton);
        addPhotoButton = findViewById(R.id.addPhotoButton);
        addPhotoButton.setOnClickListener{
            mainActivityPresenter.renameSection()
        }
        addButton.setOnClickListener {
            val intent = mainActivityPresenter.choosePhoto()
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1)
        }

    }









    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && data != null) {

            var imageUri = data.data as Uri
            Toast.makeText(this, imageUri.toString(), Toast.LENGTH_SHORT).show()
            try {
                mainActivityPresenter.putPhoto(imageUri,contentResolver,this)
            }
            catch (e:Exception)
            {
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }
        }

    }

}