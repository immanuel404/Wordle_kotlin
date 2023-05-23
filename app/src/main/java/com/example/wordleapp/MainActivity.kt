package com.example.wordleapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlin.collections.ArrayList
import kotlin.random.Random
import android.os.Handler
import android.os.Looper
import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.net.URL
import java.util.concurrent.Executors

// declarations
var gameLevel = 1
var word = ""

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getWord() // Random Word
        Toast.makeText(this, "Game Level $gameLevel",Toast.LENGTH_SHORT).show()

        // BUTTON->ONCLICK
        var btnEnter = findViewById(R.id.btnEnter) as Button
        btnEnter.setOnClickListener()
        {
            Toast.makeText(this, word,Toast.LENGTH_SHORT).show()
            var txt1 = findViewById<EditText>(R.id.editText1)
            var txt2 = findViewById<EditText>(R.id.editText2)
            var txt3 = findViewById<EditText>(R.id.editText3)
            var txt4 = findViewById<EditText>(R.id.editText4)
            var txt5 = findViewById<EditText>(R.id.editText5)
            var arrText = ArrayList<EditText>()

            when (gameLevel) {
                2 -> {
                    txt1 = findViewById<EditText>(R.id.editText6)
                    txt2 = findViewById<EditText>(R.id.editText7)
                    txt3 = findViewById<EditText>(R.id.editText8)
                    txt4 = findViewById<EditText>(R.id.editText9)
                    txt5 = findViewById<EditText>(R.id.editText10)
                }
                3 -> {
                    txt1 = findViewById<EditText>(R.id.editText11)
                    txt2 = findViewById<EditText>(R.id.editText12)
                    txt3 = findViewById<EditText>(R.id.editText13)
                    txt4 = findViewById<EditText>(R.id.editText14)
                    txt5 = findViewById<EditText>(R.id.editText15)
                }
                4 -> {
                    txt1 = findViewById<EditText>(R.id.editText16)
                    txt2 = findViewById<EditText>(R.id.editText17)
                    txt3 = findViewById<EditText>(R.id.editText18)
                    txt4 = findViewById<EditText>(R.id.editText19)
                    txt5 = findViewById<EditText>(R.id.editText20)
                }
            }

            // CHECK->ALL INPUT IS ENTERED
            if (txt1.text.toString() != "" && txt2.text.toString() != "" && txt3.text.toString() != "" && txt4.text.toString() != "" && txt5.text.toString() != "") {
                arrText.clear()
                arrText.add(txt1);arrText.add(txt2);arrText.add(txt3);arrText.add(txt4);arrText.add(txt5);

                var i = 0
                var rightCount = 0
                while (i < arrText.size && gameLevel < 5) {
                    arrText[i].setBackgroundColor(Color.DKGRAY);

                    // IF->CHAR EXITS IN WORD
                    val charExist = word.contains(arrText[i].text.toString().uppercase())
                    if (charExist) {

                        // IF->CHAR_INPUT IS IN CORRECT POSITION
                        if (arrText[i].text.toString().uppercase() == word[i].toString()) {
                            arrText[i].setBackgroundColor(Color.GREEN);
                            rightCount++

                            // IF->CORRECT->NEXT-LEVEL
                            if (rightCount == arrText.size) {
                                gameLevel++
                                if(gameLevel > 4)
                                {
                                    Toast.makeText(this, "Game Complete",Toast.LENGTH_SHORT).show()
                                } else {
                                    getWord()
                                    Toast.makeText(this, "Game Level $gameLevel",Toast.LENGTH_SHORT).show()
                                }
                            }
                        } else {
                            arrText[i].setBackgroundColor(Color.YELLOW);
                        }
                    }
                    i++
                }
            } else {
                Toast.makeText(this, "Enter All 5 letters", Toast.LENGTH_SHORT).show()
            }
        }
    }


    // GET RANDOM WORD
    private fun getWord() {
        var arrWords = arrayListOf("About","Alert","Beach","Bread","Cause","Cross","Break","Chain","Crowd")
        val randomValue = Random.nextInt(arrWords.size)
        word = arrWords[randomValue].uppercase()

        // GET WORD FROM API
//        val executor = Executors.newSingleThreadExecutor()
//        executor.execute {
//            val url = URL("https://wordapidata.000webhostapp.com/?getnamesenglish")
//            val json = url.readText().toString()
//            // format data
//            val reGex = Regex("[^A-Za-z0-9, ]")
//            val wordsFormatted = reGex.replace(json, "")
//            val wordsArray = wordsFormatted.split(",").toTypedArray()
//            val randomValue = Random.nextInt(wordsArray.size)
//            word = wordsArray[randomValue].uppercase()
//        }
    }
}