package com.example.smskotlin

import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    internal lateinit var mobileno: EditText
    internal lateinit var message:EditText
    internal lateinit var sendsms: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mobileno = findViewById(R.id.editText1) as EditText
        message = findViewById(R.id.editText2) as EditText
        sendsms = findViewById(R.id.button1) as Button
        sendsms.setOnClickListener {
            val no = mobileno.text.toString()
            val msg = message.getText().toString()
            val intent = Intent(applicationContext, MainActivity::class.java)
            val pi = PendingIntent.getActivity(applicationContext, 0, intent, 0)
            val sms = SmsManager.getDefault()
            sms.sendTextMessage(no, null, msg, pi, null)

            Toast.makeText(applicationContext, "Message Sent successfully!",
                    Toast.LENGTH_LONG).show()
        }


    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.activity_main, menu)
        return true
    }
   /*public boolean onCreateOptionsMenu(Menu menu)
    {
        menuInflater.inflate(R.menu.activity_main, menu)
        return true*/
    }

