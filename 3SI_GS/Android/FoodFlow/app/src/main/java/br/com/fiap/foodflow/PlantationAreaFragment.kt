package br.com.fiap.foodflow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import br.com.fiap.foodflow.databinding.FragmentPlantationAreaBinding
import br.com.fiap.foodflow.model.PlantationAreaModel

class PlantationAreaFragment : Fragment() {

    lateinit var binding: FragmentPlantationAreaBinding

    companion object {
        const val BUNDLE_PLANTATION_AREA_KEY = "PLANTATION_AREA_KEY"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlantationAreaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configurarFragment()
    }

    private fun configurarFragment() {
        val plantationAreaModel =
            arguments?.getSerializable(BUNDLE_PLANTATION_AREA_KEY) as PlantationAreaModel

        binding.plantationAreaCodeTextId.text = plantationAreaModel.codigo
        binding.plantationAreaIdTextId.text = plantationAreaModel.id
        binding.plantationAreaLocalizationTextId.text = plantationAreaModel.localizacao
        binding.plantationAreaTypeId.text = plantationAreaModel.tipo
        binding.plantationAreaHumidityTextId.text = plantationAreaModel.umidadeAtual.toString() + getString(
                    R.string.plantation_area_humidity_unity)
        tratarAlerta(plantationAreaModel.alertaPraga, binding.plantationAreaPragueTextId)
        tratarAlerta(plantationAreaModel.alertaDoenca, binding.plantationAreaDiseaseTextId)
        binding.plantationAreaAnalysisTextId.text = plantationAreaModel.analiseDaIA
        binding.plantationAreaImgId.setImageResource(plantationAreaModel.ultimaImg)
    }

    private fun tratarAlerta(alerta: Boolean, textBinding: TextView) {
        if (alerta) {
            textBinding.text =
                getString(R.string.plantation_area_caution_text)
            textBinding.setTextColor(resources.getColor(R.color.danger))
        } else {
            textBinding.text =
                getString(R.string.plantation_area_no_problem_text)
            textBinding.setTextColor(resources.getColor(R.color.success))
        }
    }

}