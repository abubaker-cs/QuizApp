package org.abubaker.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import org.abubaker.quizapp.data.Constants
import org.abubaker.quizapp.databinding.ActivityMainBinding
import org.abubaker.quizapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    // Binding Object
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_result)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_result)

        /**
         * Catch Information
         */
        val username = intent.getStringArrayExtra(Constants.USER_NAME)
        println("Username: $username")
        binding.tvName.text = username.toString()

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswer = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)

        println("Your Score is $correctAnswer out of $totalQuestions")
        binding.tvScore.text = "Your Score is $correctAnswer out of $totalQuestions"

        binding.btnFinish.setOnClickListener {
            startActivity(Intent(this@ResultActivity, MainActivity::class.java))
            // finish()
        }

    }
}