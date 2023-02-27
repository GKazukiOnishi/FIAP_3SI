package br.com.fiap.moneymask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import br.com.fiap.moneymask.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

//    val toggleButton: Button = findViewById(R.id.toggle_button)
    lateinit var binding: ActivityMainBinding
    private val mask: String = "******"
    private val value: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
//        toggleButton.setText(R.string.show_button_label)
//        toggle_button.setText(R.string.show_button_label)
        binding.toggleButton.setText(R.string.show_button_label)
//        setContentView(R.layout.activity_main)
        setContentView(binding.root)
    }

    fun clickToggleButton() {
        value?.length
        binding.toggleButton.setOnClickListener {
            it.toggle_button.setText(R.string.show_button_label)
        }
    }
}