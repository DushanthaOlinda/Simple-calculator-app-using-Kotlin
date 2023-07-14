package com.example.simplecalculator
 import android.annotation.SuppressLint
 import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.simplecalculator.R

class MainActivity : AppCompatActivity() {

    private lateinit var inputTextView: TextView
    private lateinit var resultTextView: TextView

    private var currentNumber = ""
    private var selectedOperator = ""
    private var operand1 = 0.0
    private var operand2 = 0.0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputTextView = findViewById(R.id.inputTextView)
        resultTextView = findViewById(R.id.resultTextView)

        val button0: Button = findViewById(R.id.button0)
        val button1: Button = findViewById(R.id.button1)
        val button2: Button = findViewById(R.id.button2)
        val button3: Button = findViewById(R.id.button3)
        val button4: Button = findViewById(R.id.button4)
        val button5: Button = findViewById(R.id.button5)
        val button6: Button = findViewById(R.id.button6)
        val button7: Button = findViewById(R.id.button7)
        val button8: Button = findViewById(R.id.button8)
        val button9: Button = findViewById(R.id.button9)
        val buttonAdd: Button = findViewById(R.id.buttonAdd)
        val buttonSubtract: Button = findViewById(R.id.buttonSubtract)
        val buttonMultiply: Button = findViewById(R.id.buttonMultiply)
        val buttonDivide: Button = findViewById(R.id.buttonDivide)
        val buttonEquals: Button = findViewById(R.id.buttonEquals)
        val buttonClear: Button = findViewById(R.id.buttonClear)

        button0.setOnClickListener { appendNumber("0") }
        button1.setOnClickListener { appendNumber("1") }
        button2.setOnClickListener { appendNumber("2") }
        button3.setOnClickListener { appendNumber("3") }
        button4.setOnClickListener { appendNumber("4") }
        button5.setOnClickListener { appendNumber("5") }
        button6.setOnClickListener { appendNumber("6") }
        button7.setOnClickListener { appendNumber("7") }
        button8.setOnClickListener { appendNumber("8") }
        button9.setOnClickListener { appendNumber("9") }
        buttonAdd.setOnClickListener { handleOperator("+") }
        buttonSubtract.setOnClickListener { handleOperator("-") }
        buttonMultiply.setOnClickListener { handleOperator("*") }
        buttonDivide.setOnClickListener { handleOperator("/") }
        buttonEquals.setOnClickListener { calculateResult() }
        buttonClear.setOnClickListener { clearCalculator() }
    }

    private fun appendNumber(number: String) {
        currentNumber += number
        inputTextView.text = currentNumber
    }

    private fun handleOperator(operator: String) {
        if (currentNumber.isNotEmpty()) {
            operand1 = currentNumber.toDouble()
            selectedOperator = operator
            currentNumber = ""
            inputTextView.text = operator
        }
    }

    private fun calculateResult() {
        if (currentNumber.isNotEmpty()) {
            operand2 = currentNumber.toDouble()
            var result = 0.0

            when (selectedOperator) {
                "+" -> result = operand1 + operand2
                "-" -> result = operand1 - operand2
                "*" -> result = operand1 * operand2
                "/" -> {
                    if (operand2 != 0.0) {
                        result = operand1 / operand2
                    } else {
                        resultTextView.text = "Error: Divide by zero"
                        return
                    }
                }
            }

            resultTextView.text = result.toString()
            currentNumber = ""
            operand1 = result
            selectedOperator = ""
        }
    }

    private fun clearCalculator() {
        currentNumber = ""
        selectedOperator = ""
        operand1 = 0.0
        operand2 = 0.0
        inputTextView.text = ""
        resultTextView.text = ""
    }
}