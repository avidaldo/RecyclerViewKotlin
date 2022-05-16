package com.example.recyclerviewkotlin.flowerList

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.recyclerviewkotlin.data.DataSource
import com.example.recyclerviewkotlin.data.Flower

class FlowersListViewModel(val dataSource: DataSource) : ViewModel() {

    val flowersLiveData = MutableLiveData(dataSource.flowerList)

    fun addFlower(name: String, image: Int?, description: String) {
        dataSource.addFlower(dataSource.newFlowerIndexing(name, image, description))
        updateLiveData()
    }

    fun removeFlower(flower: Flower) {
        dataSource.removeFlower(flower)
        updateLiveData()
    }

    private fun updateLiveData() {
        flowersLiveData.value = dataSource.flowerList
    }

    fun getFlowerFromId(id: Long): Flower? {
        return dataSource.getFlowerFromId(id)  // TODO: Leemos directamente del modelo, no del LiveData
    }



}

class FlowersListViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FlowersListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FlowersListViewModel(
                dataSource = DataSource.getDataSource(context.resources)
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}