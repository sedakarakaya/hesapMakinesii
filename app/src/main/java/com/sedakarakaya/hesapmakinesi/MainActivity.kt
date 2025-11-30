package com.sedakarakaya.hesapmakinesi

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // değişkenler
    var operator = "*"
    var eskiSayi = ""
    var yeniOperator = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

    }

    fun btnSayiTik(view: View) {
        val sayiGoster = findViewById<TextView>(R.id.sayiGoster)

        if (yeniOperator) {
            sayiGoster.text = ""
        }
        yeniOperator = false

        val btnSec = view as Button
        var btnTikDeger: String = sayiGoster.text.toString()

        when (btnSec.id) {
            R.id.btn_dot -> sayiGoster.text = btnTikDeger + "0"
            R.id.btn_1 -> sayiGoster.text = btnTikDeger + "1"
            R.id.btn_2 -> sayiGoster.text = btnTikDeger + "2"
            R.id.btn_3 -> sayiGoster.text = btnTikDeger + "3"
            R.id.btn_4 -> sayiGoster.text = btnTikDeger + "4"
            R.id.btn_5 -> sayiGoster.text = btnTikDeger + "5"
            R.id.btn_6 -> sayiGoster.text = btnTikDeger + "6"
            R.id.btn_7 -> sayiGoster.text = btnTikDeger + "7"
            R.id.btn_8 -> sayiGoster.text = btnTikDeger + "8"
            R.id.btn_9 -> sayiGoster.text = btnTikDeger + "9"

            R.id.btn_dot, R.id.btn_comma -> {
                if (!btnTikDeger.contains(".")) {
                    sayiGoster.text = btnTikDeger + "."
                }
            }

            R.id.btn_sign -> {
                if (btnTikDeger.isNotEmpty()) {
                    if (btnTikDeger.startsWith("-")) {
                        sayiGoster.text = btnTikDeger.substring(1)
                    } else {
                        sayiGoster.text = "-" + btnTikDeger
                    }
                }
            }
        }
    }

    fun btnOnTik(view: View) {
        val sayiGoster = findViewById<TextView>(R.id.sayiGoster)
        val btnSec = view as Button

        eskiSayi = sayiGoster.text.toString()
        yeniOperator = true

        when (btnSec.id) {
            R.id.btn_divide -> operator = "/"
            R.id.btn_multiply -> operator = "x"
            R.id.btn_minus -> operator = "-"
            R.id.btn_plus -> operator = "+"
        }
    }

    fun btnEsittirTik(view: View) {
        val sayiGoster = findViewById<TextView>(R.id.sayiGoster)
        val yeniSayi = sayiGoster.text.toString()
        var sonucSayisi: Double? = null

        if (eskiSayi.isNotEmpty() && yeniSayi.isNotEmpty()) {
            when (operator) {
                "/" -> sonucSayisi = eskiSayi.toDouble() / yeniSayi.toDouble()
                "x" -> sonucSayisi = eskiSayi.toDouble() * yeniSayi.toDouble()
                "-" -> sonucSayisi = eskiSayi.toDouble() - yeniSayi.toDouble()
                "+" -> sonucSayisi = eskiSayi.toDouble() + yeniSayi.toDouble()
            }
            sayiGoster.text = sonucSayisi.toString()
            yeniOperator = true
        }
    }

    fun btnSilTik(view: View) {
        val sayiGoster = findViewById<TextView>(R.id.sayiGoster)
        sayiGoster.text = "0"
        yeniOperator = true
        eskiSayi = ""
    }

    fun btnYüzdeTik(view: View) {
        val sayiGoster = findViewById<TextView>(R.id.sayiGoster)
        val deger = sayiGoster.text.toString()

        if(deger.isNotEmpty()) {
            val sayi: Double = deger.toDouble() / 100
            sayiGoster.text = sayi.toString()
            yeniOperator = true
        }
    }
}