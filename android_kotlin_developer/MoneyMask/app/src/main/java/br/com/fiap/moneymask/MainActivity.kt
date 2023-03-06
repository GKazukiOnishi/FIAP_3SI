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
    private var value: String? = null
    private var buttonState: ButtonState = ButtonState.HIDE_VALUE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
//        toggleButton.setText(R.string.show_button_label)
//        toggle_button.setText(R.string.show_button_label)
        //binding.toggleButton.setText(R.string.show_button_label)
//        setContentView(R.layout.activity_main)
        setContentView(binding.root)
        clickToggleButton()
    }

    fun clickToggleButton() {
        //value?.length
        value = binding.moneyValue.text.toString()
        binding.toggleButton.setOnClickListener {
            when(buttonState) {
                ButtonState.HIDE_VALUE -> {
                    binding.moneyValue.text = mask
                    buttonState = ButtonState.SHOW_VALUE
                }
                ButtonState.SHOW_VALUE -> {
                    binding.moneyValue.text = value
                    buttonState = ButtonState.HIDE_VALUE
                }
            }
            binding.toggleButton.setText(buttonState.buttonTextResId)
            //it.toggle_button.setText(R.string.show_button_label)
        }
    }
}