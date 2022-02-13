package com.example.valorantagentselector

import android.content.res.Resources
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var photoAdapter: PhotoAdapter
    private var dataList = mutableListOf<DataModel>()

    private val randAgent: RandomiseAgentClass = RandomiseAgentClass()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val randomiseButton: Button = findViewById(R.id.randomiseButton)
        val recyclerView = findViewById<RecyclerView>(R.id.unlockedAgentsRecyclerView)
        val columns = 4
        recyclerView.layoutManager = GridLayoutManager(applicationContext, columns)
        photoAdapter = PhotoAdapter(applicationContext)
        recyclerView.adapter = photoAdapter

        val agentsList = mutableListOf<String>(
            "astra",
            "breach",
            "brimstone",
            "chamber",
            "cypher",
            "jett",
            "kayo",
            "killjoy",
            "neon",
            "omen",
            "phoenix",
            "raze",
            "reyna",
            "sage",
            "skye",
            "sova",
            "viper",
            "yoru"
        )


        for (agent in agentsList) {

            val context = applicationContext
            val resources: Resources = context.resources
            val resourceId: Int = resources.getIdentifier(agent, "drawable", context.packageName)

            dataList.add(DataModel(agent.capitalize(Locale.ROOT), resourceId))
        }

        photoAdapter.setDataList(dataList)

        val notPreferredAgent = mutableListOf<String>()

        agentsList.removeAll(notPreferredAgent)

        randomiseButton.setOnClickListener {
            val agent = randAgent.randomiseAgent(agentsList)
            Toast.makeText(applicationContext, agent, Toast.LENGTH_SHORT).show()
        }

    }


}