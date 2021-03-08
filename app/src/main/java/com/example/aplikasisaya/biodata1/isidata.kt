package com.example.aplikasisaya.biodata1

import io.realm.RealmObject

open class isidata : RealmObject() {
    private var nama : String? = null
    private var kelas : String? = null
    private var semester : Int? = null
    private var nim : Int? = null
    private var jeniskelamin : String? = null

    fun setnama(nama : String){
        this.nama = nama
    }
    fun getnama():String?{
        return nama
    }
    fun setkelas(kelas : String){
        this.kelas = kelas
    }
    fun getkelas():String?{
        return kelas
    }
    fun setsemester(semester : Int){
        this.semester = semester
    }
    fun getsemester():Int?{
        return semester
    }
    fun setnim(nim : Int){
        this.nim = nim
    }
    fun getnim():Int? {
        return nim
    }
    fun setjeniskelamin(jeniskelamin : String){
        this.jeniskelamin = jeniskelamin
    }
    fun getjeniskelamin ():String? {
        return jeniskelamin


    }
}