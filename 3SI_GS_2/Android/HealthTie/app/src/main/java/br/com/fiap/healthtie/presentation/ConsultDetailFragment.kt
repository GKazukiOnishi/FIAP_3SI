package br.com.fiap.healthtie.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.fiap.healthtie.databinding.FragmentConsultDetailBinding

class ConsultDetailFragment : Fragment() {
    lateinit var binding: FragmentConsultDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentConsultDetailBinding.inflate(inflater, container, false)
        return binding.root
    }
}