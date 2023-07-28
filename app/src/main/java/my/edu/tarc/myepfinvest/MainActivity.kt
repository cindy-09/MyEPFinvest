package my.edu.tarc.myepfinvest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import my.edu.tarc.myepfinvest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.buttonCalculate.setOnClickListener{
            val age = binding.spinnerAge.selectedItemPosition
            val saving = binding.editTextAccount.text.toString().toFloat()
            val investmentAmount = when(age) {
                0 -> //16-20
                    (saving - 5000) * 0.3
                1 -> //21-25
                    (saving - 14000) * 0.3
                2 -> //26-30
                    (saving - 29000) * 0.3
                3-> //31-35
                    (saving - 50000) * 0.3
                4-> //36-40
                    (saving - 78000) * 0.3
                5-> //41-45
                    (saving - 116000) * 0.3
                6-> //46-50
                    (saving - 165000) * 0.3
                7-> //51-55
                    (saving - 228000) * 0.3
                else ->
                    0
            }
            val investment = Investment(investmentAmount.toString())
            binding.myInvestment = investment
        }

        binding.buttonReset.setOnClickListener{
            val investment = Investment("")
            binding.myInvestment = investment

        }
    }
}