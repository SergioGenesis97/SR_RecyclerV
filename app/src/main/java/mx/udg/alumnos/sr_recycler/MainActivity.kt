package mx.udg.alumnos.sr_recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.coroutines.launch
import mx.udg.alumnos.sr_recycler.adapter.Notasadapter
import mx.udg.alumnos.sr_recycler.db.NotasDB
import mx.udg.alumnos.sr_recycler.modelo.Nota
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var recyclerNotas: RecyclerView
    lateinit var app:NotaApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerNotas = findViewById(R.id.listaNotas)

        app = applicationContext as NotaApp
        // Se puede acceder a la variable(BASE DE DATOS) desde cualquier lugar
        // Donde se invoque



        val notas = ArrayList<Nota>()

        notas.add(Nota(titulo = "Primera Nota", descripcion = "Una descripcion zip rar"))
        notas.add(Nota(titulo = "Segunda Nota", descripcion = "Una descripcion pequeña"))
        notas.add(Nota(titulo = "Tercera Nota", descripcion = "Una descripcion smaller"))
        notas.add(Nota(titulo = "Cuarta Nota", descripcion = "Una descripcion media"))
        notas.add(Nota(titulo = "Quinta Nota", descripcion = "Una descripcion medium-biggest"))
        notas.add(Nota(titulo = "Sexta Nota", descripcion = "Una descripcion grande"))
        notas.add(Nota(titulo = "Septima Nota", descripcion = "Una descripcion biggest-supreme"))
        notas.add(Nota(titulo = "Octava Nota", descripcion = "Una descripcion suprema" +
                "suprema suprema suprema suprema suprema suprema suprema suprema suprema " +
                "suprema suprema suprema suprema suprema suprema suprema suprema suprema" +
                "suprema suprema suprema suprema suprema suprema suprema suprema suprema"))

        recyclerNotas.layoutManager = StaggeredGridLayoutManager(2,
                                      StaggeredGridLayoutManager.VERTICAL)
        recyclerNotas.setHasFixedSize(true)
        recyclerNotas.adapter = Notasadapter(notas, this)

    }

    override fun onResume() {
        super.onResume()
        lifecycleScope.launch{
            val notas = app.room.notaDao().obtenerTodas()
            for (nota in notas){
                Log.i("Nota", nota.titulo)
            }

        }
    }


}