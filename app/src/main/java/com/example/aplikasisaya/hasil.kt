package com.example.aplikasisaya
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aplikasisaya.biodata1.hasilrc
import com.example.aplikasisaya.biodata1.isidata
import com.example.aplikasisaya.databinding.ActivityHalaman1Binding
import com.example.aplikasisaya.databinding.ActivityHasilBinding
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_hasil.*
class hasil : AppCompatActivity() {
    lateinit var realm : Realm
    lateinit var hasilrc : hasilrc
    lateinit var hasildta : RecyclerView
    lateinit var binding: ActivityHasilBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHasilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.hasildta.layoutManager= LinearLayoutManager(this)
        hasilrc = hasilrc(mutableListOf(), object : hasilrc.clickAdapter{
            override fun onClick(user: isidata) {
                startActivity(Intent(this@hasil, halaman1::class.java)
                        .putExtra("nama", user.getnama())
                        .putExtra("nim", user.getnim())
                        .putExtra("kelas", user.getkelas())
                )
                finish()
                 }

             })

        binding.hasildta.adapter = hasilrc
        realm = Realm.getDefaultInstance()
        realm.where(isidata::class.java).findAll().let {
            hasilrc.last(it)
        }
        btnkembali.setOnClickListener {
            startActivity(Intent(this,halaman1::class.java))
        }
    }

}