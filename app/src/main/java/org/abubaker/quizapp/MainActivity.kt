package org.abubaker.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import org.abubaker.quizapp.data.Constants
import org.abubaker.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Binding Object
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // It will load activity_main.xml view
        // setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Disable status bar
        // window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        // window.setDecorFitsSystemWindows(false)

        binding.btnStart.setOnClickListener {

            if (binding.etName.text.toString().isEmpty()) {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, QuizQuestionsActivity::class.java)

                // Send extra info to the QuizQuestionsActivity through using intent.putExtra()
                intent.putExtra(Constants.USER_NAME, binding.etName.text.toString())

                startActivity(intent)
                finish() // Close the main / active activity
            }
        }


    }

}