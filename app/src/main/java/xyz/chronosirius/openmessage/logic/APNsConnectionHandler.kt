package xyz.chronosirius.openmessage.logic

import android.util.Log
import androidx.compose.runtime.MutableState
import java.net.Socket
import java.net.InetSocketAddress
import java.nio.charset.Charset

class APNsConnectionHandler {
    private var socket: Socket

    init {
        this.socket = Socket()
    }

    fun send(state: MutableState<String>) {
        try {
            Thread( Runnable {
                this.socket.connect(InetSocketAddress("192.168.0.124", 65257))
                this.socket.getOutputStream().write("Hello World!".toByteArray())
                state.value = this.socket.getInputStream().readAllBytes().toString(Charset.defaultCharset())
                this.socket.close()
            }).start()
        } catch (e: Exception) {
            Log.e("APNsConnectionHandler", e.toString())
        }
    }
}