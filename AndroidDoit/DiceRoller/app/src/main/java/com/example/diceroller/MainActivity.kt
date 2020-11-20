package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.isDigitsOnly

class MainActivity : AppCompatActivity() {
    //var diceImage : ImageView? = null
    // 널체크를 해야하는 단점이 있음
    //The lateinit keyword promises the Kotlin compiler that the variable will be initialized before the code calls any operations on it
    lateinit var diceImage1 : ImageView
    lateinit var diceImage2 : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener{ rollDice() }

        diceImage1 = findViewById(R.id.dice_image1)
        diceImage2 = findViewById(R.id.dice_image2)

        //val countupButton: Button = findViewById(R.id.countup_button)
        //countupButton.setOnClickListener { countUp() }
    }

    private fun rollDice(){

        diceImage1.setImageResource(getRandomDiceImage())
        diceImage2.setImageResource(getRandomDiceImage())
    }

    private fun getRandomDiceImage() : Int{
        val randomInt = (1..6).random();
        val drawableResource = when(randomInt){
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else->R.drawable.dice_6
        }
        return drawableResource
    }


    /*
    private fun countUp(){


        val count: Int = resultText?.text.toString().toInt()

        if(resultText?.text.toString()=="Hello World!") resultText?.text="1"

        else if(count<6){
            var after: Int = count+1
            resultText?.text= after.toString()
        }
    }*/
}