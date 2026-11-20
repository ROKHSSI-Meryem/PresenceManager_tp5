package com.example.prsencemanager

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class GroupesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_groupes)

        val liste = findViewById<ListView>(R.id.lvGroupes)
        val groupes = listOf(
            Groupe("DEVAM201", 24), Groupe("DEVAM202", 22),
            Groupe("DEVAM203", 26), Groupe("DEVAM204", 23),
            Groupe("DEVAM205", 25), Groupe("DEVAM206", 21),
            // Groupes fictifs ajoutés pour tester défilement et recyclage
            Groupe("DEVAM207", 20), Groupe("DEVAM208", 22),
            Groupe("DEVAM209", 25), Groupe("DEVAM210", 23)
        )
        val adapter = GroupeAdapter(this, groupes)
        liste.adapter = adapter

        liste.setOnItemClickListener { _, _, position, _ ->
            val groupe = adapter.getItem(position)
            AlertDialog.Builder(this)
                .setTitle(groupe.nom)
                .setMessage("Effectif : ${groupe.effectif} stagiaires")
                .setPositiveButton("OK", null)
                .show()
        }
    }
}
