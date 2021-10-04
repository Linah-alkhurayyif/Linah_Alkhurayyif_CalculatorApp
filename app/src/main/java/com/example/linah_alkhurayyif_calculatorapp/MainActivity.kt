package com.example.linah_alkhurayyif_calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var number_1 = ""
    var number_2 = ""
    var Operation_result = 0f
    var Operation = ""
    lateinit var mathematicalOperation:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mathematicalOperation = findViewById<TextView>(R.id.tvDisplay)
        val button_num0 = findViewById<Button>(R.id.button_0)
        val button_num1 = findViewById<Button>(R.id.button_1)
        val button_num2= findViewById<Button>(R.id.button_2)
        val button_num3 = findViewById<Button>(R.id.button_3)
        val button_num4 = findViewById<Button>(R.id.button_4)
        val button_num5= findViewById<Button>(R.id.button_5)
        val button_num6 = findViewById<Button>(R.id.button_6)
        val button_num7 = findViewById<Button>(R.id.button_7)
        val button_num8 = findViewById<Button>(R.id.button_8)
        val button_num9 = findViewById<Button>(R.id.button_9)
        val addition = findViewById<Button>(R.id.button_p)
        val division = findViewById<Button>(R.id.button_D)
        val subtraction = findViewById<Button>(R.id.button_s)
        val multiplication = findViewById<Button>(R.id.button_m)
        val clear = findViewById<Button>(R.id.button_c)
        val equal = findViewById<TextView>(R.id.button_e)
        val nagtive  = findViewById<Button>(R.id.button_n)
        val decimal  = findViewById<Button>(R.id.button_do)
        val delete = findViewById<Button>(R.id.button_DEL)
        number_1
        button_num0.setOnClickListener {theMathematicalOperation("0") }
        button_num1.setOnClickListener {theMathematicalOperation("1") }
        button_num2.setOnClickListener {theMathematicalOperation("2") }
        button_num3.setOnClickListener {theMathematicalOperation("3") }
        button_num4.setOnClickListener {theMathematicalOperation("4") }
        button_num5.setOnClickListener {theMathematicalOperation("5") }
        button_num6.setOnClickListener {theMathematicalOperation("6") }
        button_num7.setOnClickListener {theMathematicalOperation("7") }
        button_num8.setOnClickListener {theMathematicalOperation("8") }
        button_num9.setOnClickListener {theMathematicalOperation("9") }
        clear.setOnClickListener {
            Operation = ""
            number_1 = ""
            number_2 = ""
            mathematicalOperation.text = "0"
        }
        multiplication.setOnClickListener {
            Operation = "*"
            mathematicalOperation.text = number_1 + Operation
        }
        division.setOnClickListener {
            Operation = "/"
            mathematicalOperation.text = number_1 + Operation
        }
        subtraction.setOnClickListener {
            Operation = "-"
            mathematicalOperation.text = number_1 + Operation
        }
        addition.setOnClickListener {
            Operation = "+"
            mathematicalOperation.text = number_1 + Operation
        }
        equal.setOnClickListener {
            when{
                Operation == "+" ->Operation_result = number_1.toFloat() + number_2.toFloat()
                Operation == "*" -> Operation_result = number_1.toFloat() * number_2.toFloat()
                Operation == "-" -> Operation_result = number_1.toFloat() - number_2.toFloat()
                Operation == "/" -> {
                    if(number_1 == "0"||number_2 == "0"){
                        Operation_result = 0f
                    }else{
                        Operation_result = number_1.toFloat() / number_2.toFloat()
                    }
                }
            }
            mathematicalOperation.text = Operation_result.toString()
            number_1 = Operation_result.toString()
            number_2 = ""
            Operation = ""
        }
        nagtive.setOnClickListener{
            if(Operation == ""){
                number_1 += "-"
                mathematicalOperation.text = number_1
            }else {
                number_2 += "-"
                mathematicalOperation.text = number_1 + Operation + number_2
            }
        }
        decimal.setOnClickListener{
            if(Operation == ""){
                number_1 += "."
                mathematicalOperation.text = number_1
            }else {
                number_2 += "."
                mathematicalOperation.text = number_1 + Operation + number_2
            }
        }
        delete.setOnClickListener{
            if(Operation == ""){
                if(number_1 != ""){
                    number_1= number_1.substring(0, number_1.length - 1);
                }
                if(number_1 == ""){
                    mathematicalOperation.text = "0"
                }else{
                    mathematicalOperation.text = number_1
                }

            }else {
                if(number_2 != ""){
                    number_2=number_2.substring(0, number_2.length - 1);
                }else{
                    Operation=""
                }
                mathematicalOperation.text = number_1 + Operation + number_2
            }
        }
    }
   fun theMathematicalOperation(number: String){
       if(Operation == ""){
           number_1 += number
           mathematicalOperation.text = number_1
       }else {
           number_2 += number
           mathematicalOperation.text = number_1 + Operation + number_2
       }
   }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("number_1", number_1)
        outState.putString("number_2", number_2)
        outState.putFloat("Operation_result", Operation_result)
        outState.putString("Operation", Operation)

    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle){
        super.onRestoreInstanceState(savedInstanceState)
        number_1= savedInstanceState.getString("number_1", number_1)
        number_2 = savedInstanceState.getString("number_2", number_2)
    Operation_result= savedInstanceState.getFloat("Operation_result", Operation_result)
    Operation= savedInstanceState.getString("Operation", Operation)
        if(Operation == ""){
            mathematicalOperation.text = number_1
        }else {
            mathematicalOperation.text = number_1 + Operation + number_2
        }

    }

}