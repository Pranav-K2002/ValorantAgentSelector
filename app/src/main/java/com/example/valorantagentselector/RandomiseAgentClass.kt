package com.example.valorantagentselector

class RandomiseAgentClass {
    fun randomiseAgent(unlockedAgentsList: List<String>):String{
        val endIndex= unlockedAgentsList.size-1
        val rand = (0..endIndex).random()
        return unlockedAgentsList[rand]
    }
}