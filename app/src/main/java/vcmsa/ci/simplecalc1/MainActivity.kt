package vcmsa.ci.simplecalc1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
// required to import the packages so that they are accessible by the source written thereafter
import android.widget.EditText
import android.widget.Button
import android.widget.TextView
import java.util.Locale

class MainActivity : AppCompatActivity() {
    // create a set of variables for each of the controls from the Activity
    lateinit private var etNum1: EditText
    lateinit private var etNum2: EditText
    lateinit private var btnAdd: Button
    lateinit private var btnSubtract: Button
    lateinit private var btnMultiply: Button
    lateinit private var btnDivide: Button
    lateinit private var tvDisplay: TextView

    private var dblResult: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize the controls
        etNum1 = findViewById(R.id.etNum1)
        etNum2 = findViewById(R.id.etNum2)
        btnAdd = findViewById(R.id.btnAdd)
        btnSubtract = findViewById(R.id.btnSubtract)
        btnMultiply = findViewById(R.id.btnMultiply)
        btnDivide = findViewById(R.id.btnDivide)
        tvDisplay = findViewById(R.id.tvDisplay)

        // Set onClick listeners for each button
        btnAdd.setOnClickListener { calcAdd() }
        btnSubtract.setOnClickListener { calcSubtract() }
        btnMultiply.setOnClickListener { calcMultiply() }
        btnDivide.setOnClickListener { calcDivide() }
    }

    private fun calcAdd(){
        /*
         * Because of the simplified approach used in the following code, the "OrNull"
         * piece had to be removed. You will note the following equation:
         * dblResult = dblNum1 + dblNum2
         * If either of the 2 number variables resulted in being null because of the conversion
         * then it means that our program would have crashed with the execution of the equation.
         *
         * So for now, to bypass the error, we assume, because we are our own end-users, that
         * we will enter the right values when testing the program/app
         */
        //val dblNum1 = etNum1.text.toString().toDoubleOrNull()
        //val dblNum2 = etNum2.text.toString().toDoubleOrNull()

        val dblNum1 = etNum1.text.toString().toDouble()
        val dblNum2 = etNum2.text.toString().toDouble()
        // var dblResult: Double

        dblResult = dblNum1 + dblNum2

        // tvDisplay.text = dblResult.toString()
        tvDisplay.text = String.format(Locale.ENGLISH,"%s",dblResult.toString())
    }

    private fun calcSubtract(){
        val dblNum1 = etNum1.text.toString().toDouble()
        val dblNum2 = etNum2.text.toString().toDouble()

        dblResult = dblNum1 - dblNum2

        tvDisplay.text = String.format(Locale.ENGLISH,"%s",dblResult.toString())
    }

    private fun calcMultiply(){
        val dblNum1 = etNum1.text.toString().toDouble()
        val dblNum2 = etNum2.text.toString().toDouble()

        dblResult = dblNum1 * dblNum2

        tvDisplay.text = String.format(Locale.ENGLISH,"%s",dblResult.toString())
    }

    private fun calcDivide(){
        val dblNum1 = etNum1.text.toString().toDouble()
        val dblNum2 = etNum2.text.toString().toDouble()

        dblResult = dblNum1 / dblNum2

        tvDisplay.text = String.format(Locale.ENGLISH,"%s",dblResult.toString())
    }
}