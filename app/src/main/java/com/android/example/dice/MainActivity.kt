package com.android.example.dice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import com.android.example.dice.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var rollsLeft = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        val diceList = listOf<ImageView>(
            binding.diceTopLeft,
            binding.diceTopCenter,
            binding.diceTopRight,
            binding.diceBottomLeft,
            binding.diceBottomRight
        )

        binding.rollAllButton.setOnClickListener { rollAllDice(diceList) }

        for(die in diceList){
            die.setOnClickListener{(rollSingleDie(die))}
        }
    }


    fun rollSingleDie(diceImageView: ImageView){
        Random.nextInt(1, 6)
        when (Random.nextInt(1, 6)) {
            1 -> diceImageView.setImageResource(R.drawable.dice_1)
            2 -> diceImageView.setImageResource(R.drawable.dice_2)
            3 -> diceImageView.setImageResource(R.drawable.dice_3)
            4 -> diceImageView.setImageResource(R.drawable.dice_4)
            5 -> diceImageView.setImageResource(R.drawable.dice_5)
            6 -> diceImageView.setImageResource(R.drawable.dice_6)
        }
    }

    fun rollAllDice(listOfDice: List<ImageView>) {
        if (rollsLeft != 0) {
            for (diceImageView: ImageView in listOfDice) {
                when (Random.nextInt(1, 6)) {
                    1 -> diceImageView.setImageResource(R.drawable.dice_1)
                    2 -> diceImageView.setImageResource(R.drawable.dice_2)
                    3 -> diceImageView.setImageResource(R.drawable.dice_3)
                    4 -> diceImageView.setImageResource(R.drawable.dice_4)
                    5 -> diceImageView.setImageResource(R.drawable.dice_5)
                    6 -> diceImageView.setImageResource(R.drawable.dice_6)
                }
            }
            rollsLeft -= 1
            binding.rollsLeftValueTextview.setText(rollsLeft.toString())
        }
    }

}
