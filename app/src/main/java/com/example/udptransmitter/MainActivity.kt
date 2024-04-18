package com.example.udptransmitter

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class MainActivity : ComponentActivity() {
    //private lateinit var ds: DatagramSocket
    private var socket: UDP? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainfragment)

        findViewById<MaterialButton>(R.id.rotate_left_btn).setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                Log.d("rotate_left_btn", "UP")
                when (event?.action) {
                    MotionEvent.ACTION_UP -> {
                        socket?.sendMessage("LEF STOP")
                    }
                    MotionEvent.ACTION_DOWN ->{
                        socket?.sendMessage("LEF START")
                    }
                    else -> {

                    }
                }
                return v?.onTouchEvent(event) ?: true
            }
        })

        findViewById<MaterialButton>(R.id.rotate_right_btn).setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                when (event?.action) {
                    MotionEvent.ACTION_UP -> {
                        socket?.sendMessage("RIG STOP")
                    }
                    MotionEvent.ACTION_DOWN -> {
                        socket?.sendMessage("RIG START")
                    }
                    else -> {

                    }
                }
                return v?.onTouchEvent(event) ?: true
            }
        })

        findViewById<MaterialButton>(R.id.forward_btn).setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                when (event?.action) {
                    MotionEvent.ACTION_UP -> {
                        socket?.sendMessage("FOR STOP")
                    }
                    MotionEvent.ACTION_DOWN -> {
                        socket?.sendMessage("FOR START")
                    }
                    else -> {

                    }
                }
                return v?.onTouchEvent(event) ?: true
            }
        })

        val leg_menu = findViewById<TextInputLayout>(R.id.leg_menu_layout)
        val items = listOf("1", "2", "3", "4", "5", "6")
        val adapter = ArrayAdapter(this, R.layout.legmenu, items)
        (leg_menu.editText as? AutoCompleteTextView)?.setAdapter(adapter)

        findViewById<TextInputEditText>(R.id.rot_x).addTextChangedListener(object: TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                findViewById<TextInputLayout>(R.id.rot_x_layout).error = ""
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun afterTextChanged(s: Editable?) {

            }
        })
        findViewById<TextInputEditText>(R.id.rot_y).addTextChangedListener(object: TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                findViewById<TextInputLayout>(R.id.rot_y_layout).error = ""
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun afterTextChanged(s: Editable?) {

            }
        })
        findViewById<TextInputEditText>(R.id.rot_z).addTextChangedListener(object: TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                findViewById<TextInputLayout>(R.id.rot_z_layout).error = ""
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun afterTextChanged(s: Editable?) {

            }
        })

        findViewById<TextInputEditText>(R.id.tra_x).addTextChangedListener(object: TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                findViewById<TextInputLayout>(R.id.tra_x_layout).error = ""
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun afterTextChanged(s: Editable?) {

            }
        })
        findViewById<TextInputEditText>(R.id.tra_y).addTextChangedListener(object: TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                findViewById<TextInputLayout>(R.id.tra_y_layout).error = ""
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun afterTextChanged(s: Editable?) {

            }
        })
        findViewById<TextInputEditText>(R.id.tra_z).addTextChangedListener(object: TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                findViewById<TextInputLayout>(R.id.tra_z_layout).error = ""
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun afterTextChanged(s: Editable?) {

            }
        })

        findViewById<TextInputEditText>(R.id.leg_x).addTextChangedListener(object: TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                findViewById<TextInputLayout>(R.id.leg_x_layout).error = ""
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun afterTextChanged(s: Editable?) {

            }
        })
        findViewById<TextInputEditText>(R.id.leg_y).addTextChangedListener(object: TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                findViewById<TextInputLayout>(R.id.leg_y_layout).error = ""
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun afterTextChanged(s: Editable?) {

            }
        })
        findViewById<TextInputEditText>(R.id.leg_z).addTextChangedListener(object: TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                findViewById<TextInputLayout>(R.id.leg_z_layout).error = ""
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun afterTextChanged(s: Editable?) {

            }
        })


        findViewById<AutoCompleteTextView>(R.id.leg_menu).addTextChangedListener(object: TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                findViewById<TextInputLayout>(R.id.leg_menu_layout).error = ""
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun afterTextChanged(s: Editable?) {

            }
        })
    }

    fun onclick_start(view: View){
        val text = findViewById<TextInputEditText>(R.id.port).text.toString()
        val port = Integer.parseInt(text)
        //ds = DatagramSocket(port)
        socket = UDP(this)
        socket?.startUDPSocket(port)
        // disable start button and enable stop button
        findViewById<MaterialButton>(R.id.start_button).isEnabled = false
        findViewById<MaterialButton>(R.id.stop_button).isEnabled = true
    }

    fun onclick_submit(view: View){
        val text = findViewById<TextInputEditText>(R.id.cmd).text.toString()
        socket?.sendMessage(text)
    }

    fun onclick_submit_rot(view: View){
        val rot_x = findViewById<TextInputEditText>(R.id.rot_x)
        val x = rot_x.text.toString()
        if(x == ""){
            findViewById<TextInputLayout>(R.id.rot_x_layout).error = "Error"
            return
        }
        val rot_y = findViewById<TextInputEditText>(R.id.rot_y)
        val y = rot_y.text.toString()
        if(y == ""){
            findViewById<TextInputLayout>(R.id.rot_y_layout).error = "Error"
            return
        }
        val rot_z = findViewById<TextInputEditText>(R.id.rot_z)
        val z = rot_z.text.toString()
        if(z == ""){
            findViewById<TextInputLayout>(R.id.rot_z_layout).error = "Error"
            return
        }
        socket?.sendMessage(String.format("ROT %s %s %s", x, y, z))

    }

    fun onclick_submit_tra(view: View){

        val tra_x = findViewById<TextInputEditText>(R.id.tra_x)
        val x = tra_x.text.toString()
        if(x == ""){
            findViewById<TextInputLayout>(R.id.tra_x_layout).error = "Error"
            return
        }
        val tra_y = findViewById<TextInputEditText>(R.id.tra_y)
        val y = tra_y.text.toString()
        if(y == ""){
            findViewById<TextInputLayout>(R.id.tra_y_layout).error = "Error"
            return
        }
        val tra_z = findViewById<TextInputEditText>(R.id.tra_z)
        val z = tra_z.text.toString()
        if(z == ""){
            findViewById<TextInputLayout>(R.id.tra_z_layout).error = "Error"
            return
        }
        socket?.sendMessage(String.format("TRA %s %s %s", x, y, z))
    }

    fun onclick_submit_leg(view: View){

        val l = findViewById<AutoCompleteTextView>(R.id.leg_menu).text.toString()
        if(l == ""){
            findViewById<TextInputLayout>(R.id.leg_menu_layout).error = "Error"
            return
        }

        val leg_x = findViewById<TextInputEditText>(R.id.leg_x)
        val x = leg_x.text.toString()
        if(x == ""){
            findViewById<TextInputLayout>(R.id.leg_x_layout).error = "Error"
            return
        }
        val leg_y = findViewById<TextInputEditText>(R.id.leg_y)
        val y = leg_y.text.toString()
        if(y == ""){
            findViewById<TextInputLayout>(R.id.leg_y_layout).error = "Error"
            return
        }
        val leg_z = findViewById<TextInputEditText>(R.id.leg_z)
        val z = leg_z.text.toString()
        if(z == ""){
            findViewById<TextInputLayout>(R.id.leg_z_layout).error = "Error"
            return
        }
        //val selectedValue = (textInputLayout.getEditText() as AutoCompleteTextView).text
        socket?.sendMessage(String.format("LEG %s %s %s %s", l, x, y, z))
    }

    fun onclick_stop(view: View){
        socket?.stopUDPSocket()
        findViewById<MaterialButton>(R.id.start_button).isEnabled = true
        findViewById<MaterialButton>(R.id.stop_button).isEnabled = false
        findViewById<TextView>(R.id.waitconnect).setText("Waiting for connection...")
    }
}
