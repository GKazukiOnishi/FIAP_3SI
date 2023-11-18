package br.com.fiap.healthtie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import br.com.fiap.healthtie.databinding.ActivityMainBinding
import br.com.fiap.healthtie.presentation.HomeFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

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