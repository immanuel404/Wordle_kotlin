package com.example.wordleapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

// ANSWERS-> WEARY, SLICE, FUZZY, WORDS
var gameLevel = 1

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TOAST
        Toast.makeText(this, "Level 1", Toast.LENGTH_SHORT).show()
        // BUTTON
        var btnEnter = findViewById(R.id.btnEnter) as Button


        // BUTTON->ONCLICK
        btnEnter.setOnClickListener()
        {
            when (gameLevel) {
                1 -> {
                    gameLevel1()
                }
                2 -> {
                    gameLevel2()
                }
                3 -> {
                    gameLevel3()
                }
                else -> {
                    gameLevel4()
                }
            }
        }
    }


    // GAME LEVEL->1
    private fun gameLevel1() {
        var word = "WEARY"
        var arrWord = arrayListOf("W","E","A","R","Y")
        var txt1 = findViewById<EditText>(R.id.editText1)
        var txt2 = findViewById<EditText>(R.id.editText2)
        var txt3 = findViewById<EditText>(R.id.editText3)
        var txt4 = findViewById<EditText>(R.id.editText4)
        var txt5 = findViewById<EditText>(R.id.editText5)
        var arrText = ArrayList<EditText>()

        // CHECK->ALL INPUT IS ENTERED
        if(txt1.text.toString() != "" && txt2.text.toString() != "" && txt3.text.toString() != "" && txt4.text.toString() != "" && txt5.text.toString() != "")
        {
            arrText.clear()
            arrText.add(txt1);arrText.add(txt2);arrText.add(txt3);arrText.add(txt4);arrText.add(txt5);

            var i = 0
            var rightCount = 0
            while (i < arrText.size) {
                arrText[i].setBackgroundColor(Color.DKGRAY);
                // CHECK->WORD CONTAINS CHAR_INPUT
                val charExist = word.contains(arrText[i].text.toString().uppercase())
                if(charExist)
                {
                    // IF->CHAR_INPUT IN RIGHT SPOT
                    if(arrText[i].text.toString().uppercase() == arrWord[i])
                    {
                        arrText[i].setBackgroundColor(Color.GREEN);
                        rightCount++
                        // ENABLE NEXT-LEVEL
                        if(rightCount == arrText.size)
                        {
                            Toast.makeText(this, "Level 2", Toast.LENGTH_SHORT).show()
                            gameLevel++
                        }
                    } else {
                        arrText[i].setBackgroundColor(Color.YELLOW);
                    }
                }
                i++
            }
        } else {
            Toast.makeText(this, "Not enough letters", Toast.LENGTH_SHORT).show()
        }
    }


    // GAME LEVEL->2
    private fun gameLevel2() {
        var word = "SLICE"
        var arrWord = arrayListOf("S","L","I","C","E")
        var txt1 = findViewById<EditText>(R.id.editText6)
        var txt2 = findViewById<EditText>(R.id.editText7)
        var txt3 = findViewById<EditText>(R.id.editText8)
        var txt4 = findViewById<EditText>(R.id.editText9)
        var txt5 = findViewById<EditText>(R.id.editText10)
        var arrText = ArrayList<EditText>()

        // CHECK->ALL INPUT IS ENTERED
        if(txt1.text.toString() != "" && txt2.text.toString() != "" && txt3.text.toString() != "" && txt4.text.toString() != "" && txt5.text.toString() != "")
        {
            arrText.clear()
            arrText.add(txt1);arrText.add(txt2);arrText.add(txt3);arrText.add(txt4);arrText.add(txt5);

            var i = 0
            var rightCount = 0
            while (i < arrText.size) {
                arrText[i].setBackgroundColor(Color.DKGRAY);
                // CHECK->WORD CONTAINS CHAR_INPUT
                val charExist = word.contains(arrText[i].text.toString().uppercase())
                if(charExist)
                {
                    // IF->CHAR_INPUT IN RIGHT SPOT
                    if(arrText[i].text.toString().uppercase() == arrWord[i])
                    {
                        arrText[i].setBackgroundColor(Color.GREEN);
                        rightCount++
                        // ENABLE NEXT-LEVEL
                        if(rightCount == arrText.size)
                        {
                            Toast.makeText(this, "Level 3", Toast.LENGTH_SHORT).show()
                            gameLevel++
                        }
                    } else {
                        arrText[i].setBackgroundColor(Color.YELLOW);
                    }
                }
                i++
            }
        } else {
            Toast.makeText(this, "Not enough letters", Toast.LENGTH_SHORT).show()
        }
    }


    // GAME LEVEL->3
    private fun gameLevel3() {
        var word = "FUZZY"
        var arrWord = arrayListOf("F","U","Z","Z","Y")
        var txt1 = findViewById<EditText>(R.id.editText11)
        var txt2 = findViewById<EditText>(R.id.editText12)
        var txt3 = findViewById<EditText>(R.id.editText13)
        var txt4 = findViewById<EditText>(R.id.editText14)
        var txt5 = findViewById<EditText>(R.id.editText15)
        var arrText = ArrayList<EditText>()

        // CHECK->ALL INPUT IS ENTERED
        if(txt1.text.toString() != "" && txt2.text.toString() != "" && txt3.text.toString() != "" && txt4.text.toString() != "" && txt5.text.toString() != "")
        {
            arrText.clear()
            arrText.add(txt1);arrText.add(txt2);arrText.add(txt3);arrText.add(txt4);arrText.add(txt5);

            var i = 0
            var rightCount = 0
            while (i < arrText.size) {
                arrText[i].setBackgroundColor(Color.DKGRAY);
                // CHECK->WORD CONTAINS CHAR_INPUT
                val charExist = word.contains(arrText[i].text.toString().uppercase())
                if(charExist)
                {
                    // IF->CHAR_INPUT IN RIGHT SPOT
                    if(arrText[i].text.toString().uppercase() == arrWord[i])
                    {
                        arrText[i].setBackgroundColor(Color.GREEN);
                        rightCount++
                        // ENABLE NEXT-LEVEL
                        if(rightCount == arrText.size)
                        {
                            Toast.makeText(this, "Final Level", Toast.LENGTH_SHORT).show()
                            gameLevel++
                        }
                    } else {
                        arrText[i].setBackgroundColor(Color.YELLOW);
                    }
                }
                i++
            }
        } else {
            // TOAST
            Toast.makeText(this, "Not enough letters", Toast.LENGTH_SHORT).show()
        }
    }


    // GAME LEVEL->4
    private fun gameLevel4() {
        var word = "WORDS"
        var arrWord = arrayListOf("W","O","R","D","S")
        var txt1 = findViewById<EditText>(R.id.editText16)
        var txt2 = findViewById<EditText>(R.id.editText17)
        var txt3 = findViewById<EditText>(R.id.editText18)
        var txt4 = findViewById<EditText>(R.id.editText19)
        var txt5 = findViewById<EditText>(R.id.editText20)
        var arrText = ArrayList<EditText>()

        // CHECK->ALL INPUT IS ENTERED
        if(txt1.text.toString() != "" && txt2.text.toString() != "" && txt3.text.toString() != "" && txt4.text.toString() != "" && txt5.text.toString() != "")
        {
            arrText.clear()
            arrText.add(txt1);arrText.add(txt2);arrText.add(txt3);arrText.add(txt4);arrText.add(txt5);

            var i = 0
            var rightCount = 0
            while (i < arrText.size) {
                arrText[i].setBackgroundColor(Color.DKGRAY);
                // CHECK->WORD CONTAINS CHAR_INPUT
                val charExist = word.contains(arrText[i].text.toString().uppercase())
                if(charExist)
                {
                    // IF->CHAR_INPUT IN RIGHT SPOT
                    if(arrText[i].text.toString().uppercase() == arrWord[i])
                    {
                        arrText[i].setBackgroundColor(Color.GREEN);
                        rightCount++
                        // ENABLE NEXT-LEVEL
                        if(rightCount == arrText.size)
                        {
                            Toast.makeText(this, "Finished:-)", Toast.LENGTH_SHORT).show()
                            gameLevel++
                        }
                    } else {
                        arrText[i].setBackgroundColor(Color.YELLOW);
                    }
                }
                i++
            }
        } else {
            // TOAST
            Toast.makeText(this, "Not enough letters", Toast.LENGTH_SHORT).show()
        }
    }
}