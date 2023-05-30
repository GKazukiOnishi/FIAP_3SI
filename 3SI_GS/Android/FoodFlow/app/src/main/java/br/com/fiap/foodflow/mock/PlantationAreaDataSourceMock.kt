package br.com.fiap.foodflow.mock

import br.com.fiap.foodflow.R
import br.com.fiap.foodflow.model.PlantationAreaModel

object PlantationAreaDataSourceMock {

    val areasList: List<PlantationAreaModel> = listOf(
        PlantationAreaModel(
            "A1",
            "195515435616",
            "19º55’15’’ S e 43º56’16’’ W",
            "Café",
            69,
            false,
            false,
            "Os resultados das análises indicam que a plantação está em ótimo estado.",
            R.mipmap.ic_area_a1
        ),
        PlantationAreaModel(
            "A2",
            "195515435625",
            "19º55’15’’ S e 43º56’25’’ W",
            "Café",
            73,
            false,
            false,
            "Os resultados das análises indicam que a plantação está em ótimo estado.",
            R.mipmap.ic_area_a2
        ),
        PlantationAreaModel(
            "B1",
            "195525435616",
            "19º55’25’’ S e 43º56’16’’ W",
            "Café",
            53,
            false,
            true,
            "Os resultados das análises indicam que é necessário iniciar os tratamentos para um possível caso de ervas daninhas. Prazo de 30 dias.",
            R.mipmap.ic_area_b1
        )
    )

}