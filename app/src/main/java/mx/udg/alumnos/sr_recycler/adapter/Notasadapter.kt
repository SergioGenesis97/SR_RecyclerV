package mx.udg.alumnos.sr_recycler.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mx.udg.alumnos.sr_recycler.R
import mx.udg.alumnos.sr_recycler.modelo.Nota

class Notasadapter(notas: ArrayList<Nota>, contexto:Context):
    RecyclerView.Adapter<Notasadapter.ViewHolder>() {


    var notas:ArrayList<Nota>?=null
    var contexto:Context?=null

    init {
        this.notas = notas
        this.contexto = contexto
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Notasadapter.ViewHolder {

        val vistaNota: View = LayoutInflater.from(contexto).inflate(R.layout.nota_layout, parent, false)
        val notaViewHolder = ViewHolder(vistaNota)
        vistaNota.tag = notaViewHolder

        return notaViewHolder

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.tvTitulo.text = notas!![position].titulo
        holder.tvDescripcion.text = notas!![position].descripcion

    }

    override fun getItemCount(): Int {
        return this.notas!!.count()
    }

    class ViewHolder(v: View):RecyclerView.ViewHolder(v) {

        lateinit var tvTitulo: TextView
        lateinit var tvDescripcion: TextView

        init {

            tvTitulo = v.findViewById(R.id.tvTitulo)
            tvDescripcion = v.findViewById(R.id.tvDescripcion)

        }


    }

}