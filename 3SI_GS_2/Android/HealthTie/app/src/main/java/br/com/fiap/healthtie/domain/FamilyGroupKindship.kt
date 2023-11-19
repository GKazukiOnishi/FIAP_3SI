package br.com.fiap.healthtie.domain

enum class FamilyGroupKindship(val title: String) {
    GRANDMOTHER("Avó"),
    GRANDFATHER("Avô"),
    FATHER("Pai"),
    MOTHER("Mãe"),
    BROTHER("Irmão");

    companion object{
        fun getByTitle(title: String): FamilyGroupKindship{
            return values().find {
                it.title == title
            } ?: BROTHER
        }
    }

}