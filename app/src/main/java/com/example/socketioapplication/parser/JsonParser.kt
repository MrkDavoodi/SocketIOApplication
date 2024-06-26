package com.example.socketioapplication.parser

import com.example.socketioapplication.models.OnOffTimeSchedule
import com.example.socketioapplication.models.Time
import com.example.socketioapplication.models.UpdateDate
import com.example.socketioapplication.models.VersionModel
import org.json.JSONArray
import org.json.JSONObject

class JsonParser(jsonString: String) {
    private val jsonObject: JSONObject = JSONObject(jsonString)

    fun parseItems(): VersionModel {
        val videoArray: JSONArray = jsonObject.getJSONArray("VideoList")
        val categoryArray: JSONArray = jsonObject.getJSONArray("category")
        val onOffTimeSchedule = jsonObject.getJSONArray("onOffTimeSchedule")
        val versionApp = jsonObject.getDouble("versionApp")
        val versionWeb = jsonObject.getDouble("Ver")
        val holidays = jsonObject.getString("Holyday")
        val versionDetail = VersionModel(
            Condition = "",
            Holyday = holidays.toString(),
            ONTime = "",
            Player = listOf("", ""),
            Ver = versionWeb.toString(),
            versionApp = versionApp,
            categoryList = convertJSONArrayToStringList(categoryArray),
            VideoList = convertJSONArrayToStringList(videoArray),
            needToUpp = false,
            onOffTimeSchedule = listOf( OnOffTimeSchedule("", Time("",""),Time("",""))),
            updateDate = UpdateDate("", "", "", "", false, ""),


            )
        val itemsList = mutableListOf<String>()

//        for (i in 0 until videoArray.length()) {
////            val itemObject = videoArray.getString(i)
////            val id = itemObject.getInt("id")
////            val title = itemObject.getString("title")
////            val image = itemObject.getString("image")
////            val content = itemObject.getString("content")
////            val tags = itemObject.getJSONArray("tags").toList().map { it.toString() }
////
////            val item = Books(id, title, image, content, tags)
//            itemsList.add(item)
//        }

        return versionDetail
    }

//    fun displayItems() {
//        val items = parseItems()
//
//        for (item in items) {
//            println("ID: ${item.id}")
//            println("Title: ${item.title}")
//            println("Image: ${item.image}")
//            println("Content: ${item.content}")
//            println("Tags: ${item.tags.joinToString(", ")}")
//            println()
//        }
//    }


    private fun convertJSONArrayToStringList(itemArray: JSONArray):List<String>{
        val itemsList = mutableListOf<String>()
        for (i in 0 until itemArray.length()){
            itemsList.add(i,itemArray[i].toString())
        }
        return itemsList
    }
}