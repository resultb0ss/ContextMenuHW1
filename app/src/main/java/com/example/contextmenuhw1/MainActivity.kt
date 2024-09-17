package com.example.contextmenuhw1

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    companion object{
        const val ITEM_ON = 111
        const val ITEM_OFF = 112
    }

    private lateinit var textEdit: EditText
    private lateinit var randomNumButton: Button

    private lateinit var resultTv: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textEdit = findViewById(R.id.text_edit)
        registerForContextMenu(textEdit)


        randomNumButton = findViewById(R.id.randomNumbButton)
        resultTv = findViewById(R.id.textView)

        randomNumButton.setOnClickListener(::onClick)



    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu?.add(Menu.NONE, ITEM_ON, Menu.NONE, "Цветовое качество")
        menu?.add(Menu.NONE, ITEM_OFF, Menu.NONE, "Выйти")
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            ITEM_ON ->{
                var number = textEdit.text.toString()
                when(number){
                    "1" -> textEdit.setBackgroundColor(Color.parseColor("FFA500"))
                    "2" -> textEdit.setBackgroundColor(Color.YELLOW)
                    "3" -> textEdit.setBackgroundColor(Color.GREEN)
                    "4"-> textEdit.setBackgroundColor(Color.BLUE)
                    "5" -> textEdit.setBackgroundColor(Color.RED)
                    else -> textEdit.setBackgroundColor(Color.WHITE)
                }
            }

            ITEM_OFF -> exitProcess(0)

        }
        return super.onContextItemSelected(item)
    }

    fun onClick(view: View){
        var randomNumber = (1..50).random()
        textEdit.setText(randomNumber.toString())
        when (randomNumber){
            in 1..10 -> textEdit.setBackgroundColor(Color.RED)
            in 11..20 -> textEdit.setBackgroundColor(Color.parseColor("FFA500"))
            in 21..30 -> textEdit.setBackgroundColor(Color.YELLOW)
            in 31..40 -> textEdit.setBackgroundColor(Color.GREEN)
            in 41..50 -> textEdit.setBackgroundColor(Color.BLUE)
            else -> textEdit.setBackgroundColor(Color.WHITE)
        }
    }
}