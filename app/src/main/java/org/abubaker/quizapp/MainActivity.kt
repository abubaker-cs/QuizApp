package org.abubaker.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.abubaker.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Binding Object
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}