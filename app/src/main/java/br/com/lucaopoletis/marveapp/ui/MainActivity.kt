package br.com.lucaopoletis.marveapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.lucaopoletis.marveapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}