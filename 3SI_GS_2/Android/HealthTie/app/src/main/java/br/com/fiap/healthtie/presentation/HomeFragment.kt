package br.com.fiap.healthtie.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.fiap.healthtie.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configurarFragment()
    }

    private fun configurarFragment() {
        /*binding.homeCardPlantationId.setOnClickListener {
            findNavController().navigate(R.id.action_to_PlantationListFragment)
        }
        binding.homeCardAnalysisId.setOnClickListener {
            findNavController().navigate(R.id.action_to_AnalysisFragment)
        }*/
    }

}