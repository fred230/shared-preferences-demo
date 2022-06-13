package com.fredrick.spdemo

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var nameText:EditText
    private lateinit var ageText: EditText
    private lateinit var btn:Button
    private lateinit var sf:SharedPreferences
    private lateinit var sfEditor:SharedPreferences.Editor




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameText = findViewById(R.id.name)
        ageText = findViewById(R.id.age)
        btn= findViewById(R.id.btn)
        sf = getSharedPreferences("my_sf", MODE_PRIVATE)
        sfEditor = sf.edit()
    }


    override fun onPause(){
        super.onPause()

        val name = nameText.text.toString()
        val age= ageText.text.toString().toInt()
        sfEditor.apply(){
            putString("sf_name",name)
            putInt("sf_Int",age)
            commit()
        }




    }

    override fun onResume() {
        super.onResume()
        val name = sf.getString("sf_name", null)
        val age = sf.getInt("sf_Int", 0)
        nameText.setText(name)

        if (age!=0){
            ageText.setText(age.toString())
        }



    }



        }