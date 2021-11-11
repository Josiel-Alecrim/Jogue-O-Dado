package com.josielsantos.rolldicesample

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var imgDice: ImageView
    private val diceImages: MutableList<Int> = mutableListOf<Int>()
    private lateinit var animation: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgDice = findViewById(R.id.imgDice)
        val btnRoll = findViewById<Button>(R.id.btnRoll)
        btnRoll.setOnClickListener{
            // disable the button click
            //btnRoll.isEnabled = false
            getRandomValue()
        }


        //add dice images to list
        diceImages.add(R.drawable.ic_dice_one)
        diceImages.add(R.drawable.ic_dice_two)
        diceImages.add(R.drawable.ic_dice_three)
        diceImages.add(R.drawable.ic_dice_four)
        diceImages.add(R.drawable.ic_dice_five)
        diceImages.add(R.drawable.ic_dice_six)

        //Inicializando a animação
        animation = AnimationUtils.loadAnimation(this@MainActivity, R.anim.shake_anim)

    }

    private fun getRandomValue() {
        val random =  Random.nextInt(6)

        // starts the animation
        imgDice.startAnimation(animation)

        // now we will get when the animation starts and when it ends

        animation.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                // when animation ends we will set the image
                imgDice.setImageResource(diceImages.elementAt(random)) //this will set the dice image randomly
                // enable the button click
            }

            override fun onAnimationRepeat(animation: Animation?) {
                // When animation starts we will set  default image
                imgDice.setImageResource(R.drawable.ic_dice)
            }

        })


    }
}