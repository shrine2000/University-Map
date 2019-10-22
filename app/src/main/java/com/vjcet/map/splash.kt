package com.vjcet.map

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_splash.*
import kotlinx.android.synthetic.main.content_splash.*

class splash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        image.setImageDrawable(getDrawable((R.drawable.images)))

        Handler().postDelayed({

            val i = Intent(this,MainActivity::class.java)
            startActivity(i)

        },2500)

    }

}
