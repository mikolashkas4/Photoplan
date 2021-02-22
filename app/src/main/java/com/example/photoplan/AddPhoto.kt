package com.example.photoplan

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.widget.PopupMenu
import androidx.core.app.ActivityCompat.startActivityForResult
import org.jetbrains.annotations.NotNull

public class AddPhoto(){


    companion object{
        public val PICK_IMAGE_REQUEST = 1;
        public  fun  openFileChooser() : Intent {
            var intent: Intent = Intent();
            intent.setType("image/*")
            intent.setAction(Intent.ACTION_GET_CONTENT)
            return intent;


        }
    }



}