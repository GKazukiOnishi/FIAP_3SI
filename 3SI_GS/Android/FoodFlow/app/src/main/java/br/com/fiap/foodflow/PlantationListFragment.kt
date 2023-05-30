package br.com.fiap.foodflow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.fiap.foodflow.databinding.FragmentPlantationListBinding
import br.com.fiap.foodflow.model.PlantationAreaModel

class PlantationListFragment : Fragment() {

    lateinit var binding: FragmentPlantationListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlantationListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configurarFragment()
    }

    private fun configurarFragment() {
        val plantationListAdapter = PlantationListAdapter(::goToPlantationAreaFragment)
        binding.recyclerViewPlantations.adapter = plantationListAdapter
    }

    private fun goToPlantationAreaFragment(plantationAreaModel: PlantationAreaModel) {
        val bundle = Bundle()
        bundle.putSerializable(PlantationAreaFragment.BUNDLE_PLANTATION_AREA_KEY, plantationAreaModel)
        findNavController().navigate(R.id.action_to_PlantationAreaFragment, bundle)
    }

}