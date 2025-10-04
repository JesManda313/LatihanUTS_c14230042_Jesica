package com.paba.latihanuts

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() , operasiMat.OperationClickListener{
    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var btnTambah: Button
    private lateinit var tvHasil: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        editText1 = findViewById(R.id.editAngka1)
        editText2 = findViewById(R.id.editAngka2)
        btnTambah = findViewById(R.id.btnTambah)
        tvHasil = findViewById(R.id.tvHasil)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, operasiMat())
                .commit()
        }

        btnTambah.setOnClickListener {
            performOperation("+")
        }
    }


    fun performOperation(operator: String) {
        val num1Str = editText1.text.toString()
        val num2Str = editText2.text.toString()

        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            Toast.makeText(this, "Harap masukkan kedua angka", Toast.LENGTH_SHORT).show()
            return
        }

        val num1 = num1Str.toDouble()
        val num2 = num2Str.toDouble()
        var result: Double? = null
        var operationDetailText = ""

        when (operator) {
            "+" -> {
                result = num1 + num2
                operationDetailText = "Operasi Matematika\n$num1 + $num2"
            }

            "*" -> {
                result = num1 * num2
                operationDetailText = "Operasi Matematika\n$num1 * $num2"
            }

            "/" -> {
                if (num2 == 0.0) {
                    Toast.makeText(this, "Tidak bisa dibagi dengan nol", Toast.LENGTH_SHORT).show()
                    return
                }
                result = num1 / num2
                operationDetailText = "Operasi Matematika\n$num1 / $num2"
            }
        }
        tvHasil.text = "HASIL\n${result.toString()}"



        val detailFragment = operationDetailFragment.newInstance(operationDetailText)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, detailFragment)
            .addToBackStack(null)
            .commit()

    }

    override fun onOperationSelected(operation: String) {
        performOperation(operation)

    }
}