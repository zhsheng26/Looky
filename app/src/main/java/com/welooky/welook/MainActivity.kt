package com.welooky.welook

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.welooky.welook.ui.login.LoginActivity
import com.welooky.welook.support.BaseActivity
import org.jetbrains.anko.find

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        find<Button>(R.id.btnLogin).setOnClickListener {
            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
        }
    }
}