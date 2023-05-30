package br.com.fiap.foodflow.model

import java.io.Serializable

data class PlantationAreaModel(
    val codigo: String,
    val id: String,
    val localizacao: String,
    val tipo: String,
    val umidadeAtual: Int,
    val alertaPraga: Boolean,
    val alertaDoenca: Boolean,
    val analiseDaIA: String,
    val ultimaImg: Int
) : Serializable