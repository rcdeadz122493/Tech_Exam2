package com.example.androidexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var array = arrayOf("Red", "Green", "Blue")

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ArrayAdapter(this,
            R.layout.colors_list, array)

        val colors_listView: ListView = findViewById(R.id.listview_1)
        colors_listView.setAdapter(adapter)

        colors_listView.onItemClickListener = object : AdapterView.OnItemClickListener
        {

            override fun onItemClick(parent: AdapterView<*>, view: View,
                                     position: Int, id: Long) {

                // value of item that is clicked
                val itemValue = colors_listView.getItemAtPosition(position) as String

                // Toast the values
                Toast.makeText(applicationContext,
                    "Navigating to: $itemValue", Toast.LENGTH_LONG)
                    .show()

                if(itemValue.equals("Red"))
                {
                    val intent = Intent(this@MainActivity, Homepage::class.java)
                    startActivity(intent);
                }
                else if(itemValue.equals("Green"))
                {
                    val intent = Intent(this@MainActivity, Homepage2::class.java)
                    startActivity(intent);
                }
                else if(itemValue.equals("Blue"))
                {
                    val intent = Intent(this@MainActivity, Homepage3::class.java)
                    startActivity(intent);
                }





            }
        }

    }
}