package com.example.photoplan

import android.content.Intent
import androidx.core.app.ActivityCompat.startActivityForResult


public class  AddPhoto(){


    companion object{
        public val PICK_IMAGE_REQUEST = 1;
        public  fun  openFileChooser() : Intent {
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_PICK
            return intent

        }

    }



}