package com.example.kotlinjson

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import java.io.File

data class User(val name:String,val detail:UserDetail)
data class UserDetail(val age:Int, val job:String)

val file = File("src/main/resources/list_data.json")
val json = file.absoluteFile.bufferedReader().use { it.readText() }

val mapper = ObjectMapper().registerKotlinModule()

fun main(args: Array<String>) {
    val obj: List<User> = mapper.readValue(json)
    obj.forEach {
        println(it.name)
        println(it.detail.age)
        println(it.detail.job)
    }
}