package com.example.quizapp_dotinstall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.quizapp_dotinstall.databinding.ActivityMainBinding
import java.io.*

class MainActivity : AppCompatActivity() {
    // 問題文と単語が交互に入っている
    var quizSet = arrayOf<String>()

    lateinit var scoreText : TextView
    lateinit var qText : TextView
    lateinit var a0Button : Button
    lateinit var a1Button : Button
    lateinit var a2Button : Button
    lateinit var nextButton : Button

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        loadQuizSet()
        getViews()
    }

    private fun getViews(){
        scoreText = binding.scoreText
        qText = binding.qText
        a0Button = binding.a0Button
        a1Button = binding.a1Button
        a2Button = binding.a2Button
        nextButton = binding.nextButton
    }

    private fun loadQuizSet(){
        try {
            val file = resources.assets.open("quiz.txt")
            val bufferedReader = BufferedReader(InputStreamReader(file))

            // １行ずつ読み込む
            var index = 0
            var line = bufferedReader.readLine()
            while (line != null){
                quizSet += line.split("\t")
                line = bufferedReader.readLine()
            }
            // kotlinでは内部的にuse()を用いているためclose()は暗黙的に実行される
        } catch (e: FileNotFoundException){
            Log.e("FileNotFoundexception", e.toString())
        }
    }
}