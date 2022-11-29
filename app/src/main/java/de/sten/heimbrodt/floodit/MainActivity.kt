package de.sten.heimbrodt.floodit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import de.sten.heimbrodt.floodit.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.attackButton.setOnClickListener {
            val fi = FloodIt(
                binding.editTextTarget.text.toString(),
                "80"
            )
            val radioButton = findViewById<RadioButton>(binding.radioGroup.checkedRadioButtonId)
            if(radioButton.text == "TCP flood") {
                fi.floodTCP()
            }
            else if(radioButton.text == "UDP flood") {
                fi.floodUDP()
            }
        }
    }
}