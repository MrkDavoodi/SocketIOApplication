package com.example.socketioapplication

import com.example.socketioapplication.parser.JsonParser
import io.socket.client.IO
import io.socket.client.Socket
import org.json.JSONArray
import org.json.JSONObject
import java.net.URISyntaxException

class SocketManager {
    private var socket: Socket? = null

    init {
        try {
//            socket = IO.socket("http://192.168.90.199:3001")
            socket = IO.socket("http://192.168.80.199:3001")
//            socket = IO.socket("http://192.168.1.105:3001")
            socket?.connect()

        } catch (e: URISyntaxException) {
            e.printStackTrace()
        }
    }

    fun connect() {
        socket?.on(Socket.EVENT_CONNECT) {
            println("Socket connected")
        }
        socket?.connect()    }

    fun disconnect() {
        socket?.disconnect()
    }

    fun isConnected(): Boolean {
        return socket?.connected() ?: false
    }

    fun onVersionJSONReceived(listener: (MutableList<String>) -> Unit) {
        if (socket?.connected() == true)
            socket?.on("jsonFile") { args ->
                val version = args[0] as JSONObject
                val versionDetails=JsonParser(version.toString()).parseItems()
                val videoList = version.getJSONArray("VideoList")
                val item : MutableList<String> = listOf<String>().toMutableList()
                var i = 0
                while (i < videoList.length()) {
                    item.add(i, videoList.getString(i).toString())
                    i++
                }
                listener.invoke(item)
            }

    }

    fun sendRequest() {
        socket?.emit("getVersion")
    }

}