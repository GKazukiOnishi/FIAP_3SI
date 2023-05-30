package br.com.fiap.foodflow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.foodflow.databinding.ViewPlantationAreaItemBinding
import br.com.fiap.foodflow.mock.PlantationAreaDataSourceMock
import br.com.fiap.foodflow.model.PlantationAreaModel

class PlantationListAdapter(
    private val goToPlantationAreaFragment: (PlantationAreaModel) -> Unit
) : RecyclerView.Adapter<PlantationListAdapter.PlantationItemViewHolder>() {

    private val areasList: List<PlantationAreaModel> = PlantationAreaDataSourceMock.areasList

    inner class PlantationItemViewHolder(private val view: ViewPlantationAreaItemBinding) :
        RecyclerView.ViewHolder(view.root) {
        fun bindView(plantationArea: PlantationAreaModel) {
            view.plantationAreaCodeId.text = plantationArea.codigo
            view.plantationAreaId.text = plantationArea.id
            view.plantationAreaType.text = plantationArea.tipo
            view.plantationAreaLoc.text = plantationArea.localizacao

            view.root.setOnClickListener {
                goToPlantationAreaFragment(plantationArea)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantationItemViewHolder {
        val binding = ViewPlantationAreaItemBinding.bind(
            LayoutInflater.from(parent.context).inflate(
                R.layout.view_plantation_area_item,
                parent,
                false
            )
        )
        return PlantationItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return areasList.size
    }

    override fun onBindViewHolder(holder: PlantationItemViewHolder, position: Int) {
        holder.bindView(areasList[position])
    }
}