package mx.udg.alumnos.sr_recycler

import android.app.Application
import androidx.room.Room
import mx.udg.alumnos.sr_recycler.db.NotasDB

class NotaApp: Application() {

    val room = Room
        .databaseBuilder(this, NotasDB::class.java, "notas_db")
        .build()

}