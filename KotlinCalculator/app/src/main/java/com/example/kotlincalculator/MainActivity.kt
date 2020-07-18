package com.example.kotlincalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Button as Button1

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun clickNum(view: View){
        if(newOperator)
            editText.setText("")
        newOperator=false
        var buttonSelected=view as android.widget.Button
        var buttonValue:String = editText.text.toString()

        when(buttonSelected.id){
            button0.id->{
                buttonValue+="0"
            }
            button1.id->{
                buttonValue+="1"
            }
            button2.id->{
                buttonValue+="2"
            }
            button3.id->{
                buttonValue+="3"
            }
            button4.id->{
                buttonValue+="4"
            }
            button5.id->{
                buttonValue+="5"
            }
            button6.id->{
                buttonValue+="6"
            }
            button7.id->{
                buttonValue+="7"
            }
            button8.id->{
                buttonValue+="8"
            }
            button9.id->{
                buttonValue+="9"
            }
            button.id->{
                buttonValue="-"+buttonValue
            }
        }
        editText.setText(buttonValue)
    }

    var operator="*"
    var oldNum=""
    var newOperator=true

    fun selectOperation(view: View){
        var buttonSelected=view as android.widget.Button
        when(buttonSelected.id){
            buttonAdd.id->{
                operator="+"
            }
            buttonSubt.id->{
                 operator="-"
           }
            buttonMul.id->{
                operator="*"
            }
            buttonDiv.id->{
                operator="/"
            }
        }
        oldNum=editText.text.toString()
        newOperator=true
     }

    fun selectEqual(view: View){
        var newNum=editText.text.toString()
        var result:Double?=null
        when(operator){
            "+"->{
               result=oldNum.toDouble()+newNum.toDouble()
            }
            "-"->{
                result=oldNum.toDouble()-newNum.toDouble()
            }
            "*"->{
                result=oldNum.toDouble()*newNum.toDouble()
            }
            "/"->{
                result=oldNum.toDouble()/newNum.toDouble()
            }
        }
        editText.setText(result.toString())
        newOperator=true

    }

    fun selectDelete(view: View){
        editText.setText("0")
        newOperator=true
    }

    fun getPercentage(view: View){
        var num:Double=editText.text.toString().toDouble()/100
        editText.setText(num.toString())
        newOperator=true

    }

}
