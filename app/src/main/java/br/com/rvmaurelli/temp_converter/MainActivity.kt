package br.com.rvmaurelli.temp_converter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //criar os spinners
        val listaUnidades = arrayListOf("Selecione a unidade", "Celsius", "Kelvin", "Fahrenheit")
        val spinnerAdapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_spinner_dropdown_item, listaUnidades)
        spnDeTemp.adapter = spinnerAdapter
        spnParaTemp.adapter = spinnerAdapter

        btnConvert.setOnClickListener {
            var temperaturatxt = ednTempValue.text.toString().trim()
            val convde = spnDeTemp.selectedItem.toString()
            val convpara = spnParaTemp.selectedItem.toString()

            if(temperaturatxt.isEmpty() || convde == "Selecione a unidade" || convpara == "Selecione a unidade"){
                AlertDialog.Builder(this@MainActivity)
                    .setTitle("Atenção")
                    .setMessage("Todos os campos devem ser preenchidos")
                    .setPositiveButton("Ok"){_,_->}
                    .setCancelable(false)
                    .create()
                    .show()

            }else{
                var temp:Float = temperaturatxt.toFloat()
                var tempresult:Float
                var tempresulttxt:String
                var unidade:String

                if (convde == "Celsius"){
                    if (convpara == "Kelvin"){
                        tempresult = (temp + 273.15f)
                        tempresulttxt = tempresult.toString().trim()
                        unidade = "K"

                        startActivity(Intent(this@MainActivity, ResultActivity::class.java).apply {
                            putExtra("tempresulttxt", tempresulttxt)
                            putExtra("unidade", unidade)
                        });finish()
                    }
                    if (convpara == "Fahrenheit"){
                        tempresult = ((temp * (9.0f/5.0f)) + 32.0f)
                        tempresulttxt = tempresult.toString().trim()
                        unidade = "°F"

                        startActivity(Intent(this@MainActivity, ResultActivity::class.java).apply {
                            putExtra("tempresulttxt", tempresulttxt)
                            putExtra("unidade", unidade)
                        });finish()
                    }
                }

                if (convde == "Kelvin"){
                    if (convpara == "Celsius"){
                        tempresult = (temp - 273.15f)
                        tempresulttxt = tempresult.toString().trim()
                        unidade = "°C"

                        startActivity(Intent(this@MainActivity, ResultActivity::class.java).apply {
                            putExtra("tempresulttxt", tempresulttxt)
                            putExtra("unidade", unidade)
                        });finish()
                    }
                    if (convpara == "Fahrenheit"){
                        tempresult = ((temp - 273.15f) * (9.0f/5.0f) + 32.0f)
                        tempresulttxt = tempresult.toString().trim()
                        unidade = "°F"

                        startActivity(Intent(this@MainActivity, ResultActivity::class.java).apply {
                            putExtra("tempresulttxt", tempresulttxt)
                            putExtra("unidade", unidade)
                        });finish()
                    }
                }

                if (convde == "Fahrenheit"){
                    if (convpara == "Kelvin"){
                        tempresult = (( temp - 32.0f) * (5.0f/9.0f) + 273.15f)
                        tempresulttxt = tempresult.toString().trim()
                        unidade = "K"

                        startActivity(Intent(this@MainActivity, ResultActivity::class.java).apply {
                            putExtra("tempresulttxt", tempresulttxt)
                            putExtra("unidade", unidade)
                        });finish()
                    }
                    if (convpara == "Celsius"){
                        tempresult = ((temp - 32.0f) * (5.0f/9.0f))
                        tempresulttxt = tempresult.toString().trim()
                        unidade = "°C"

                        startActivity(Intent(this@MainActivity, ResultActivity::class.java).apply {
                            putExtra("tempresulttxt", tempresulttxt)
                            putExtra("unidade", unidade)
                        });finish()
                    }
                }
            }
        }
    }
}