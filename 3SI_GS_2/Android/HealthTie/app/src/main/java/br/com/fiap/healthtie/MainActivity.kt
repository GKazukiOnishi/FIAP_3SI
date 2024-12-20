package br.com.fiap.healthtie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import br.com.fiap.healthtie.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureMenuNavigation()
    }

    private fun configureMenuNavigation() {
        binding.topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_home -> {
                    binding.fragmentContainer.findNavController().navigate(R.id.action_to_home)
                    true
                }
                R.id.menu_reminders -> {
                    binding.fragmentContainer.findNavController().navigate(R.id.action_to_reminder_list)
                    true
                }
                else -> false
            }
        }
    }
}