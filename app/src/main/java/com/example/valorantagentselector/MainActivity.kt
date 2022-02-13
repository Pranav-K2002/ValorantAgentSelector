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
    private lateinit var photoAdapter2: PhotoAdapter
    private var dataList = mutableListOf<DataModel>()

    private val randAgent: RandomiseAgentClass = RandomiseAgentClass()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val columns = 4

        val randomiseButton: Button = findViewById(R.id.randomiseButton)

        val unlockedAgentsRecyclerView = findViewById<RecyclerView>(R.id.unlockedAgentsRecyclerView)
        unlockedAgentsRecyclerView.layoutManager = GridLayoutManager(applicationContext, columns)
        photoAdapter = PhotoAdapter(applicationContext)
        unlockedAgentsRecyclerView.adapter = photoAdapter

        val unpreferredAgentsRecyclerView = findViewById<RecyclerView>(R.id.unPreferredAgentsRecyclerView)
        unpreferredAgentsRecyclerView.layoutManager = GridLayoutManager(applicationContext, columns)
        photoAdapter2 = PhotoAdapter(applicationContext)
        unpreferredAgentsRecyclerView.adapter = photoAdapter2

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


        val notPreferredAgent = mutableListOf<String>("astra")

        val unlockedAgents= agentsList

        unlockedAgents.removeAll(notPreferredAgent)

        for (agent in notPreferredAgent) {

            val context = applicationContext
            val resources: Resources = context.resources
            val resourceId: Int = resources.getIdentifier(agent, "drawable", context.packageName)

            dataList.add(DataModel(agent.capitalize(Locale.ROOT), resourceId))
        }

        photoAdapter2.setDataList(dataList)

        randomiseButton.setOnClickListener {
            val agent = randAgent.randomiseAgent(agentsList)
            Toast.makeText(applicationContext, agent, Toast.LENGTH_SHORT).show()
        }

    }


}