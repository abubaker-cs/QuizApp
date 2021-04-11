package org.abubaker.quizapp

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import org.abubaker.quizapp.data.Constants
import org.abubaker.quizapp.data.Question
import org.abubaker.quizapp.databinding.ActivityMainBinding
import org.abubaker.quizapp.databinding.ActivityQuizQuestionsBinding

/**
 * Applied OnClickedListener to the class
 */
class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    // Current Question
    private var mCurrentPosition: Int = 1

    // It will make questions list global
    private var mQuestionsList: ArrayList<Question>? = null

    // Selected answer from the 4 options.
    private var mSelectedOptionPosition: Int = 0

    // Binding Object
    private lateinit var binding: ActivityQuizQuestionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // setContentView(R.layout.activity_quiz_questions)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_quiz_questions)

        // It will return all questions
        mQuestionsList = Constants.getQuestions()
        Log.i("Questions Size: ", "${mQuestionsList!!.size}")

        setQuestion()

        /**
         * Method 01 - We set the view and implemented the code directly
         */
        binding.tvOptionOne.setOnClickListener(this)
        binding.tvOptionTwo.setOnClickListener(this)
        binding.tvOptionThree.setOnClickListener(this)
        binding.tvOptionFour.setOnClickListener(this)

    }

    private fun setQuestion() {

        mCurrentPosition = 1
        val question = mQuestionsList?.get(mCurrentPosition - 1)
        // val question = mQuestionsList!!.get(mCurrentPosition - 1)

        Log.i("setQuestions not null", "$question")
        Log.i("Questions Size: ", "${mQuestionsList!!.size}")

        if (question == null) {
            println("I am empty")
        }

        // Issue: Buttons for options should be reset on each time when we will create a new question
        // It will reset all buttons back to the default
        // defaultOptionsView()

        binding.progressBar.progress = mCurrentPosition
//
        binding.tvProgress.text = "$mCurrentPosition / ${binding.progressBar.max}"
        binding.tvQuestion.text = question!!.question

        binding.ivImage.setImageResource(question.image)

        binding.tvOptionOne.text = question.optionOne
        binding.tvOptionTwo.text = question.optionTwo
        binding.tvOptionThree.text = question.optionThree
        binding.tvOptionFour.text = question.optionFour

    }

    /**
     * It will apply styles for the clicked option (button) based on index-position
     */
    override fun onClick(v: View?) {
        when (v?.id) {

            /**
             * Method 02
             */

            R.id.tv_option_one -> {
                selectedOptionView(binding.tvOptionOne, 1)
            }

            R.id.tv_option_two -> {
                selectedOptionView(binding.tvOptionTwo, 2)
            }

            R.id.tv_option_three -> {
                selectedOptionView(binding.tvOptionThree, 3)
            }

            R.id.tv_option_four -> {
                selectedOptionView(binding.tvOptionFour, 4)
            }
        }
    }

    /*
     * defaultOptionsView()
     */
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
                ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)

        }

    }

    /**
     * selectedOptionView()
     */
    private fun selectedOptionView(tv: TextView, selectedOptionNumber: Int) {

        // Reset to default view
        defaultOptionsView()

        // Set to new position
        mSelectedOptionPosition = selectedOptionNumber

        // Text Color: 363A43
        tv.setTextColor(Color.parseColor("363A43"))

        // Typeface: Bold
        tv.setTypeface(tv.typeface, Typeface.BOLD)

        // Border Color
        tv.background =
            ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)

    }

}