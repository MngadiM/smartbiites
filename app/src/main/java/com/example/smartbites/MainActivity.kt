package com.example.smartbites

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.Random

class MainActivity : AppCompatActivity() {
    private lateinit var mealTextView: TextView
    private lateinit var mealImageView: ImageView

    // Meal data
    private val breakfast = listOf(
        "Pancake and Berries - Fluffy goodness to start your day!",
        "Omelet Delux - Packed with veggies and cheese",
        "Health Oat - Topped with honey and nuts",
        "Avocado Toast - Because healthy can be yummy!"
    )

    private val lunch = listOf(
        "Grilled chicken wrap - Light, tasty and filling",
        "Mini Pizza Delight - Who says you can't have pizza for lunch?",
        "Power Salad - Crisp, fresh, and full of nutrients.",
        "Cheese sandwich - Because cheesy makes everything better!"
    )

    private val dinner = listOf(
        "Steak and veggies - Protein-packed goodness",
        "Chicken curry and rice - A comforting meal.",
        "Vegetarian stir-fry - Full of color and flavor.",
        "Sushi Rolls - Because why not?"
    )

    private val snacks = listOf(
        "Banana slices and Almonds - Quick and Nutritious",
        "Trail Mix - Nuts, dried fruits, and a touch of chocolate",
        "Greek yogurt with honey and nuts - Creamy and packed with protein"
    )

    private val desserts = listOf(
        "Chocolate lava Cake - Warm, gooey, and irresistible",
        "Mini donuts - Bite-sized happiness!",
        "Chewy cookies - Because one is never enough!"
    )

    private lateinit var breakfastButton: Button
    private lateinit var lunchButton: Button
    private lateinit var dinnerButton: Button
    private lateinit var snacksButton: Button
    private lateinit var dessertsButton: Button
    private lateinit var surpriseMeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Initialize UI elements
        mealTextView = findViewById(R.id.mealtextView)
        mealImageView = findViewById(R.id.imageView)

        breakfastButton = findViewById(R.id.breakfastButton)
        lunchButton = findViewById(R.id.lunchButton)
        dinnerButton = findViewById(R.id.dinnerbutton)
        snacksButton = findViewById(R.id.SnacksButton)
        dessertsButton = findViewById(R.id.dessertsButton)
        surpriseMeButton = findViewById(R.id.SupriseMeButton)

        // Set button listeners
        breakfastButton.setOnClickListener { displayMenu(breakfast) }
        lunchButton.setOnClickListener { displayMenu(lunch) }
        dinnerButton.setOnClickListener { displayMenu(dinner) }
        snacksButton.setOnClickListener { displayMenu(snacks) }
        dessertsButton.setOnClickListener { displayMenu(desserts) }
        surpriseMeButton.setOnClickListener { surpriseMe() }
    }

    private fun displayMenu(menu: List<String>) {
        var menuText = ""
        for (item in menu) {
            menuText += "$item\n\n"
        }
        mealTextView.text = menuText
        val View
        mealTextView.visibility = View.VISIBLE
    }

    private fun surpriseMe() {
        // Pick a random meal from all categories
        val allMeals = breakfast + lunch + dinner + snacks + desserts
        val randomMeal = allMeals[Random().nextInt(allMeals.size)]
        mealTextView.text = randomMeal
        mealTextView.visibility = View.VISIBLE
    }
}

