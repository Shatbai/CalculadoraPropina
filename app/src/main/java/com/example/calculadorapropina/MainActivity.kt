package com.example.calculadorapropina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.calculadorapropina.databinding.ActivityMainBinding
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }
    private fun initUI(){
        binding.button15.setOnClickListener{
            interfaceCalculate(percentage=.15)
            Toast.makeText(this, "Daras 15% de propina", Toast.LENGTH_SHORT).show()
        }
        binding.button20.setOnClickListener{
            interfaceCalculate(percentage = .20)
            Toast.makeText(this, "Daras 20% de propina", Toast.LENGTH_SHORT).show()
        }
        binding.button35.setOnClickListener{
            interfaceCalculate(percentage = .35)
            Toast.makeText(this, "Daras 35% de propina", Toast.LENGTH_SHORT).show()
        }
        binding.redondeo.setOnClickListener{
            redondearB()
        }
    }
    private fun interfaceCalculate(percentage: Double){
        val amount =binding.editTextNumberDecimal.text.toString()
        val amountValue = amount.toDoubleOrNull()
        if (amountValue == null|| amountValue<=0){
            Toast.makeText(this, "No se puede dejar en ceros ni en numeros negativos", Toast.LENGTH_SHORT).show()
            binding.totalTip.text="0.0"
            binding.totalAmount.text="0.0"
        }
            binding.totalTip.text="${ amountValue!! *percentage}"
            binding.totalAmount.text="${amountValue*(1+ percentage)}"
    }
    private fun redondearB(){
        val tip1r=binding.totalTip.text.toString()
        val tip2r=binding.totalAmount.text.toString()
        val tip1= tip1r.toDoubleOrNull()
        val tip2= tip2r.toDoubleOrNull()
        binding.totalTip.text= tip1?.roundToInt().toString()
        binding.totalAmount.text= tip2?.roundToInt().toString()




    }
}
