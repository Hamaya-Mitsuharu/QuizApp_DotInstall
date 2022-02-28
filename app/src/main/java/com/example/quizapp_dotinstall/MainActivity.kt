package com.example.quizapp_dotinstall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.io.*

class MainActivity : AppCompatActivity() {
    var quizSet = arrayOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadQuizSet()
    }

    private fun loadQuizSet(){
        try {
            val file = resources.assets.open("quiz.txt")
            val bufferedReader = BufferedReader(InputStreamReader(file))

            // １行ずつ読み込む
            var index = 0
            var line = bufferedReader.readLine()
            while (line != null){
                Log.d("readLineInQuizTxt", line)
                quizSet += line.split("\t")
                line = bufferedReader.readLine()
            }
            for (s in quizSet){
                Log.d("readLineInQuizTxt", s)
            }
            // kotlinでは内部的にuse()を用いているためclose()は暗黙的に実行される
        } catch (e: FileNotFoundException){
            Log.e("FileNotFoundexception", e.toString())
        }
    }
}