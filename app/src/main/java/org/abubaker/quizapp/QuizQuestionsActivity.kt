package org.abubaker.quizapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import org.abubaker.quizapp.data.Constants
import org.abubaker.quizapp.data.Question
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
        val questionsList = Constants.getQuestions()
        Log.i("Questions Size: ", "${questionsList.size}")

        val currentPosition = 1
        val question: Question? = questionsList[currentPosition - 1]

        binding.progressBar.progress = currentPosition

        binding.tvProgress.text = "$currentPosition / ${binding.progressBar.max}"
        binding.tvQuestion.text = question!!.question

        binding.ivImage.setImageResource(question.image)

        binding.tvOptionOne.text = question.optionOne
        binding.tvOptionTwo.text = question.optionTwo
        binding.tvOptionThree.text = question.optionThree
        binding.tvOptionFour.text = question.optionFour


    }

}