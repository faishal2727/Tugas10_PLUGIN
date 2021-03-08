package com.example.aplikasisaya

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.aplikasisaya.biodata1.hasilrc
import com.example.aplikasisaya.biodata1.isidata
import io.realm.Realm
import io.realm.Realm.getDefaultInstance
import io.realm.kotlin.createObject
import kotlinx.android.synthetic.main.activity_halaman1.*
import java.lang.Exception

class halaman1 : AppCompatActivity() {
    lateinit var realm : Realm
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_halaman1)
        btn_back.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
        view()
        save()
        getUser()
        updateData()
        deleteData()
    }
    private fun view() {
        realm= getDefaultInstance()
    }

    private fun save() {
        btnsave.setOnClickListener {
            realm.beginTransaction()
            try {
                val dataa = realm.createObject(isidata::class.java)
                dataa.setnama(data1.text.toString())
                  dataa.setkelas(data5.text.toString())
//                dataa.setsemester(data3.toString().toInt())
                dataa.setnim(data4.text.toString().toInt())
              //  dataa.setjeniskelamin(data5.toString())
                realm.commitTransaction()
                Toast.makeText(this, "Lanjut", Toast.LENGTH_SHORT).show()
            }catch (e:Exception){
                Toast.makeText(this, "Eror  404", Toast.LENGTH_SHORT).show()

            }
            startActivity(Intent(this,hasil::class.java))
            finish()
        }
        btnlihat.setOnClickListener {
            startActivity(Intent(this,hasil::class.java))
            finish()
        }
    }
    fun getUser(){
        data1.setText(intent.getStringExtra("nama"))
        data4.setText(intent.getStringExtra("nim"))
        data5.setText(intent.getStringExtra("kelas"))
    }
    fun updateData(){
        btnedit.setOnClickListener {
            realm.beginTransaction()
            realm.where(isidata::class.java).equalTo("nama", data1.text.toString()).findFirst().let {
                it!!.setnim(data4.text.toString().toInt())
                it!!.setkelas(data5.text.toString())

            }

            realm.commitTransaction()
            Toast.makeText(this, "Data Updated", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, hasil::class.java))
            finish()
        }
    }
    fun deleteData(){
        btnhapus.setOnClickListener {
            realm.beginTransaction()
            realm.where(isidata::class.java).equalTo("nama", data1.text.toString()).findFirst().let {
                it!!.deleteFromRealm()
            }
            realm.commitTransaction()
            Toast.makeText(this, "Data Deleted", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, hasil::class.java))
            finish()
        }
    }



}