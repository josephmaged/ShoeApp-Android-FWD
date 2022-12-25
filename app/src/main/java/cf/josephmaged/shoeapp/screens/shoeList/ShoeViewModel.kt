package cf.josephmaged.shoeapp.screens.shoeList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cf.josephmaged.shoeapp.models.Shoe

class ShoeViewModel : ViewModel() {

    private var _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    fun addShoe(shoe: Shoe) {
        if (_shoeList.value == null) {
            _shoeList.value = mutableListOf(shoe)
        } else {
            _shoeList.value?.add(shoe)
        }
    }
}