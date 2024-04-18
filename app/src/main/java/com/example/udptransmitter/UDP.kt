package com.example.udptransmitter

import android.os.Handler
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import java.io.IOException
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress
import java.net.SocketException
import java.net.UnknownHostException
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class UDP(private val activity: MainActivity) {
        private val TAG = "UdpSocket"

        private var mThreadPool: ExecutorService? = null
        private var socket: DatagramSocket? = null
        private var receivePacket: DatagramPacket? = null
        private val BUFFER_LENGTH = 1024
        private val receiveByte = ByteArray(BUFFER_LENGTH)

        private var isThreadRunning = false
        private lateinit var clientThread: Thread
        private var runningport: Int = -1;

        private var client_address: String = "";
        private var client_port: Int = -1;

        private var parentActivity: MainActivity? = null

        init {
            //根據CPU數量建立執行續池
            mThreadPool = Executors.newFixedThreadPool(2)
            parentActivity = activity
        }

        fun startUDPSocket(port: Int) {
            if (socket != null) return
            try {
                socket = DatagramSocket(port)
                if (receivePacket == null)
                // 接收數據封包
                    receivePacket = DatagramPacket(receiveByte, BUFFER_LENGTH)
                startSocketThread()
            } catch (e: SocketException) {
                e.printStackTrace()
            }

            runningport = port

        }

        private fun startSocketThread() {
            clientThread = Thread(Runnable {
                Log.d(TAG, "clientThread is running...")
                receiveMessage()
            })
            isThreadRunning = true
            clientThread.start()
        }

        private fun receiveMessage() {
            while (isThreadRunning) {
                try {
                    socket?.receive(receivePacket)

                    if (receivePacket == null || receivePacket?.length == 0)
                        continue

                    val strReceive = String(receivePacket!!.data, receivePacket!!.offset, receivePacket!!.length)
                    if(client_address == "" && client_port == -1) {
                        if(strReceive == "HELLO FROM STM32"){
                            Log.d("UdpSocket", "Received HELLO FROM STM32")
                            client_address = receivePacket!!.address.hostAddress
                            client_port = receivePacket!!.port
                            Log.d("UdpSocket","Client address: " + client_address)
                            Log.d("UdpSocket","Client port: " + client_port.toString())
                            parentActivity?.runOnUiThread(java.lang.Runnable {
                                parentActivity?.findViewById<TextView>(R.id.waitconnect)?.setText("CONNECTED")
                                val text = "CONNECTED"
                                val duration = Toast.LENGTH_SHORT

                                val toast = Toast.makeText(parentActivity, text, duration)
                                toast.show()

                            })
                            sendMessage("HELLO FROM ANDROID")
                        }
                        else{
                            userAction(strReceive)
                            //receivePacket?.length = BUFFER_LENGTH
                        }
                    }
                } catch (e: IOException) {
                    stopUDPSocket()
                    e.printStackTrace()
                    return
                }
            }
        }

        fun sendMessage(message: String) {
            mThreadPool?.execute {
                try {
                    val packet = DatagramPacket(message.toByteArray(), message.length, InetAddress.getByName(client_address), client_port)
                    socket?.send(packet)
                } catch (e: UnknownHostException) {
                    e.printStackTrace()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }

        fun stopUDPSocket() {
            isThreadRunning = false
            receivePacket = null
            clientThread.interrupt()
            if (socket != null) {
                socket?.close()
                socket = null
            }
        }

    fun userAction(strReceive: String){
        Log.d(TAG, strReceive)
    }

}

