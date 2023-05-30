package br.com.fiap.foodflow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.fiap.foodflow.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configurarTela()
    }

    private fun configurarTela() {
        binding.loginButtonId.setOnClickListener {
            var temErro: Boolean = false
            if (binding.loginInputId.editText?.text?.isBlank() == true) {
                binding.loginInputId.error = getString(R.string.login_error_input_text)
                temErro = true
            }
            if (binding.loginPasswordInputId.editText?.text?.isBlank() == true) {
                binding.loginPasswordInputId.error = getString(R.string.login_error_input_text)
                temErro = true
            }

            if (!temErro) {
                goToHomeActivity()
            }
        }
    }

    private fun goToHomeActivity() {
        startActivity(Intent(
            this,
            HomeActivity::class.java
        ))
    }
}