package com.example.tugaswidget

import android.app.DatePickerDialog
import android.content.Intent
import android.icu.text.SimpleDateFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    var edDate : EditText? = null
    var cal = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edDate = this.edit_Date

        //membuat onDateSetListener
        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override  fun onDateSet(
                view: DatePicker, year: Int, monthOfYear: Int,
                dayOfMonth: Int
            ) {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateInView ()
            }
        }
        edDate!!.setOnClickListener(object : View.OnClickListener {
            override  fun onClick(view: View) {
                DatePickerDialog(this@MainActivity,
                    dateSetListener,
                    // set DatePickerDialog agar menunujuk tanggal sekarang
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)).show()
            }
        })
    }
    private fun updateDateInView(){
        val myFormat = "MM/dd/yyyy" //mention the format you need
        val sdf = SimpleDateFormat(myFormat, Locale.US)

        edDate!!.setText(sdf.format(cal.getTime()))

        var title_1: EditText = findViewById(R.id.title)
        var directedby_1: EditText = findViewById(R.id.directedby)
        var homeproduction_1: EditText = findViewById(R.id.hp)
        var kategori_1: EditText = findViewById(R.id.kategori)
        var batasumur_1: EditText = findViewById(R.id.bu)
        var country_1: EditText = findViewById(R.id.spinner)
        var daterelease_1: EditText = findViewById(R.id.edit_Date)

        btn_proses.setOnClickListener{

            intent = Intent(this, ActivityKedua::class.java)
            intent.putExtra("title",title_1.getText())
            intent.putExtra("directedby",directedby_1.getText())
            intent.putExtra("homeproduction",homeproduction_1.getText())
            intent.putExtra("kategori",kategori_1.getText())
            intent.putExtra("batasumur",batasumur_1.getText())
            intent.putExtra("country",country_1.getText())
            intent.putExtra("daterelease",daterelease_1.getText())

            startActivity(intent)
        }
    }
}
