package org.abubaker.quizapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import org.abubaker.quizapp.databinding.ActivityMainBinding
import org.abubaker.quizapp.databinding.ActivityQuizQuestionsBinding

class QuizQuestionsActivity : AppCompatActivity() {

    // Binding Object
    private lateinit var binding: ActivityQuizQuestionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // setContentView(R.layout.activity_quiz_questions)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_quiz_questions)

        // It will return all questions
        // val questionsList = Constants.getQuestions()
        // Log.i("Questions Size: ", "${questionsList.size}")
    }

}