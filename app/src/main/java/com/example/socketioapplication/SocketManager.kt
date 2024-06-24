package com.example.socketioapplication

import io.socket.client.IO
import io.socket.client.Socket
import org.json.JSONArray
import org.json.JSONObject
import java.net.URISyntaxException

class SocketManager {
    private var socket: Socket? = null

    init {
        try {
            socket = IO.socket("http://192.168.107.199:3001")
        } catch (e: URISyntaxException) {
            e.printStackTrace()
        }
    }

    fun connect() {
        socket?.connect()
    }

    fun disconnect() {
        socket?.disconnect()
    }

    fun isConnected(): Boolean {
        return socket?.connected() ?: false
    }

    fun onVersionJSONReceived(listener: (JSONArray) -> Unit) {
        if (socket?.connected() == true)
            socket?.on("jsonFile") { args ->
                val version = args[0] as JSONObject
                val versionDetail = version.getJSONArray("VideoList")
                listener.invoke(versionDetail)
            }

    }

    fun sendRequest() {
        socket?.emit("getVersion")
    }

}