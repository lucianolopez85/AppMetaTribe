package com.metatribe.app.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.firebase.FirebaseApp
import com.metatribe.app.R
import com.metatribe.app.databinding.ActivitySplashBinding
import com.project.router.IntentUtils
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity(R.layout.activity_splash) {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        FirebaseApp.initializeApp(this)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = ContextCompat.getColor(this, R.color.black)
        GlobalScope.launch(Dispatchers.Main) {
            delay(2000)
            startActivity(IntentUtils.createLogonIntent(this@SplashActivity))
            finish()
        }
    }
}