package com.example.nevergiveup

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.diceroller)
        // This button allows user to roll a dice
        rollButton.setOnClickListener{rollDice()}
        rollButton.setOnClickListener{rollDice()}
        }

    /**
     *  Roll the dice and update the screen with the result
     */

    fun rollDice() {
        // Create a dice object of 6 sides and roll it
        val dice = Dice(numSides = 6).roll()

        val dice2 = Dice(numSides = 6).roll()

        // Find the image in the layout
        val diceImage : ImageView = findViewById(R.id.imageView)

        val diceImage2 : ImageView = findViewById(R.id.imageView2)
        // Determine which drawable resource ID to use based on the dice roll
        val drawableResource = when(dice)
        {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
        }
        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)
        // Update the content description
        diceImage.contentDescription = dice.toString()

        val drawableResource2 = when(dice2)
        {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // Update the ImageView with the correct drawable resource ID
        diceImage2.setImageResource(drawableResource2)
        // Update the content description
        diceImage2.contentDescription = dice2.toString()



    }

    }

/** create dice with variable number of sides and roll it
 */
class Dice( val numSides: Int) {
    fun roll(): Int = (1..numSides).random()

}
