package org.abubaker.quizapp

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import org.abubaker.quizapp.data.Constants
import org.abubaker.quizapp.data.Question
import org.abubaker.quizapp.databinding.ActivityMainBinding
import org.abubaker.quizapp.databinding.ActivityQuizQuestionsBinding

class QuizQuestionsActivity : AppCompatActivity() {

    // Binding Object
    private lateinit var binding: ActivityQuizQuestionsBinding

    // Current Question
    private var mCurrentPosition: Int = 1

    // It will make questions list global
    private var mQuestionsList: ArrayList<Question>? = null

    // Selected answer from the 4 options.
    private var mSelectedOptionPosition: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // setContentView(R.layout.activity_quiz_questions)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_quiz_questions)

        // It will return all questions
        val questionsList = Constants.getQuestions()
        Log.i("Questions Size: ", "${questionsList.size}")

        setQuestion()

    }

    private fun setQuestion() {

        mCurrentPosition = 1
        val question = mQuestionsList!!.get(mCurrentPosition - 1)

        binding.progressBar.progress = mCurrentPosition

        binding.tvProgress.text = "$mCurrentPosition / ${binding.progressBar.max}"
        binding.tvQuestion.text = question!!.question

        binding.ivImage.setImageResource(question.image)

        binding.tvOptionOne.text = question.optionOne
        binding.tvOptionTwo.text = question.optionTwo
        binding.tvOptionThree.text = question.optionThree
        binding.tvOptionFour.text = question.optionFour

    }

    //
    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        options.add(0, binding.tvOptionOne)
        options.add(1, binding.tvOptionTwo)
        options.add(2, binding.tvOptionThree)
        options.add(3, binding.tvOptionFour)

        // For loop will update UI based on updated options
        for (option in options) {

            // Text Color
            option.setTextColor(Color.parseColor("7A8089"))

            // Typeface
            option.typeface = Typeface.DEFAULT

            // Border Color
            option.background =
                ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)


        }


    }

}