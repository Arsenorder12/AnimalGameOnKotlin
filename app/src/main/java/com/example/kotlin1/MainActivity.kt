package com.example.kotlin1

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var isCat: Boolean = false
    var isDog: Boolean = true
    var isHorse: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClicker()
    }

    private fun initClicker() {
        with(binding) {
            btnCat.setOnClickListener {
                animalImg.setImageResource(R.drawable.cat)
                isCat = true
                isDog = false
                isHorse = false
            }

            btnDog.setOnClickListener {
                animalImg.setImageResource(R.drawable.dog)
                isDog = true
                isCat = false
                isHorse = false
            }

            btnHorse.setOnClickListener {
                animalImg.setImageResource(R.drawable.horse)
                isHorse = true
                isCat = false
                isDog = false
            }

            btnIsDog.setOnClickListener {
                if (isDog) {
                    Toast.makeText(applicationContext, "True", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(applicationContext, "False", Toast.LENGTH_SHORT).show()
                }
            }

            btnIsCat.setOnClickListener{
                if (isCat) {
                    Toast.makeText(applicationContext, "True", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(applicationContext, "False", Toast.LENGTH_SHORT).show()
                }
            }

            btnIsHorse.setOnClickListener{
                if (isHorse) {
                    Toast.makeText(applicationContext, "True", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(applicationContext, "False", Toast.LENGTH_SHORT).show()
                }
            }

            nextScreen.setOnClickListener{
                val intent = Intent(this@MainActivity, ResultActivity::class.java)
                var animalName: String = ""

                when(animalImg){
                    R.drawable.dog -> {
                        animalName = "Dog"
                    }
                    R.drawable.cat -> {
                        animalName = "Cat"
                    }
                    R.drawable.horse -> {
                        animalName = "Horse"
                    }
                }

                intent.putExtra("key", animalName)
                startActivity(intent)
            }
        }
    }
}