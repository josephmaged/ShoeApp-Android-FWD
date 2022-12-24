package cf.josephmaged.shoeapp.screens.shoeDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cf.josephmaged.shoeapp.models.Shoe

class ShoeDetailsViewModel : ViewModel() {

    val _shoes = MutableLiveData<MutableList<Shoe>>()
    val shoesList: LiveData<MutableList<Shoe>>
    get() = _shoes

    fun addShoe(shoe: Shoe){
        if (_shoes.value == null){
            _shoes.value = mutableListOf(shoe)
        }else {
            _shoes.value?.add(shoe)
        }
    }
}