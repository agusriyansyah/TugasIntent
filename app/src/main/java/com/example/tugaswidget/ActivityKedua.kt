package com.example.tugaswidget

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activitykedua.*

class ActivityKedua: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitykedua)

        val bundle= intent.extras
        val title_2 = bundle?.get("nim")
        val directedby_2 = bundle?.get("nama")
        val homeproduction_2 = bundle?.get("nilai")
        val kategori_2 = bundle?.get("nim")
        val batasumur_2 = bundle?.get("nim")
        val country_2 = bundle?.get("nim")
        val daterelease_2 = bundle?.get("nim")
        id_title.setText("Nim :"+title_2)
        id_db.setText("Nama :"+directedby_2)
        id_hp.setText("Nilai :"+homeproduction_2)
        id_kategori.setText("Nilai :"+kategori_2)
        id_bu.setText("Nilai :"+batasumur_2)
        id_country.setText("Nilai :"+country_2)
        id_date.setText("Nilai :"+daterelease_2)

    }

}