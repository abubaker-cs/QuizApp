package org.abubaker.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import org.abubaker.quizapp.databinding.ActivityMainBinding

class QuizQuestionsActivity : AppCompatActivity() {

    // Binding Object
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // setContentView(R.layout.activity_quiz_questions)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_quiz_questions)

        // It will return all questions
        val questionsList = Constants.getQuestions()
        Log.i("Questions Size: ", "${questionsList.size}")
    }

}