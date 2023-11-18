package br.com.fiap.healthtie.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.fiap.healthtie.databinding.FragmentConsultDetailBinding
import br.com.fiap.healthtie.databinding.FragmentHomeBinding

class ConsultDetailFragment : Fragment() {

    lateinit var binding: FragmentConsultDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentConsultDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configurarFragment()
    }

    private fun configurarFragment() {

    }

}