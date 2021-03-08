package com.example.aplikasisaya.biodata1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aplikasisaya.R

class hasilrc(private val hasilrcp:MutableList<isidata> = mutableListOf(), private val listener: clickAdapter):RecyclerView.Adapter<hasilrc.rcpViewHolder>(){
    inner class rcpViewHolder(i:View):RecyclerView.ViewHolder(i){
        val bebas: TextView = i.findViewById(R.id.nama)
        val bebas3: TextView = i.findViewById(R.id.nim)
        val bebas4: TextView = i.findViewById(R.id.kelas)

        fun bindview(bind:isidata){
            bebas.text=bind.getnama()
            bebas3.text=bind.getnim().toString()
            bebas4.text=bind.getkelas().toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): rcpViewHolder {
        return rcpViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout1,parent,false))
    }

    override fun getItemCount(): Int {
        return hasilrcp.size
    }

    override fun onBindViewHolder(holder: rcpViewHolder, position: Int) {
        holder.bindview(hasilrcp[position])
        holder.itemView.setOnClickListener {
            listener.onClick(hasilrcp[position])
        }
    }

    fun last(Listt:List<isidata>){
        hasilrcp.clear()
        hasilrcp.addAll(Listt)
        notifyDataSetChanged()

    }
    interface clickAdapter{
        fun onClick(user: isidata)
    }
}
