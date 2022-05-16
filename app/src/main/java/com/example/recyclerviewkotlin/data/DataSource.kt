package com.example.recyclerviewkotlin.data

import android.content.res.Resources
import com.example.recyclerviewkotlin.R


val IMAGE_NO_AVALIABLE_RESOURCE = R.drawable.no_avaliable

/* Handles operations on flowersLiveData and holds details about it. */
class DataSource(resources: Resources) {

    /* Esta clase será un singleton, pero como requerimos que reciba el contexto como
    parámetro, no podemos simplemente crear un object. */
    companion object {
        @Volatile
        private var INSTANCE: DataSource? = null

        fun getDataSource(resources: Resources): DataSource {
            return synchronized(DataSource::class) {
                val newInstance = INSTANCE ?: DataSource(resources)
                INSTANCE = newInstance
                newInstance
            }
        }
    }

    val flowerList = flowerList(resources).toMutableList()



    fun addFlower(flower: Flower) {
            flowerList.add(0, flower)
    }

    fun removeFlower(flower: Flower) {
            flowerList.remove(flower)
    }

    fun getFlowerFromId(id: Long) = flowerList.firstOrNull { it.id == id }



    private var idIndex = 1L

    fun newFlowerIndexing(name: String, image: Int?, description: String) =
        Flower(++idIndex, name, image, description)


    /* Returns initial list of flowers. */
    fun flowerList(resources: Resources): List<Flower> {
        return listOf(
            newFlowerIndexing(
                name = resources.getString(R.string.flower1_name),
                image = R.drawable.rose,
                description = resources.getString(R.string.flower1_description)
            ),
            newFlowerIndexing(
                name = resources.getString(R.string.flower2_name),
                image = R.drawable.freesia,
                description = resources.getString(R.string.flower2_description)
            ),
            newFlowerIndexing(
                name = resources.getString(R.string.flower3_name),
                image = R.drawable.lily,
                description = resources.getString(R.string.flower3_description)
            ),
            newFlowerIndexing(
                name = resources.getString(R.string.flower4_name),
                image = R.drawable.sunflower,
                description = resources.getString(R.string.flower4_description)
            ),
            newFlowerIndexing(
                name = resources.getString(R.string.flower5_name),
                image = R.drawable.peony,
                description = resources.getString(R.string.flower5_description)
            ),
            newFlowerIndexing(
                name = resources.getString(R.string.flower6_name),
                image = R.drawable.daisy,
                description = resources.getString(R.string.flower6_description)
            ),
            newFlowerIndexing(
                name = resources.getString(R.string.flower7_name),
                image = R.drawable.lilac,
                description = resources.getString(R.string.flower7_description)
            ),
            newFlowerIndexing(
                name = resources.getString(R.string.flower8_name),
                image = R.drawable.marigold,
                description = resources.getString(R.string.flower8_description)
            ),
            newFlowerIndexing(
                name = resources.getString(R.string.flower9_name),
                image = R.drawable.poppy,
                description = resources.getString(R.string.flower9_description)
            ),
            newFlowerIndexing(
                name = resources.getString(R.string.flower10_name),
                image = R.drawable.daffodil,
                description = resources.getString(R.string.flower10_description)
            ),
            newFlowerIndexing(
                name = resources.getString(R.string.flower11_name),
                image = R.drawable.dahlia,
                description = resources.getString(R.string.flower11_description)
            )
        )
    }

}



