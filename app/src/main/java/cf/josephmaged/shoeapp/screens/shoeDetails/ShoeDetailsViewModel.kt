package cf.josephmaged.shoeapp.screens.shoeDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cf.josephmaged.shoeapp.models.Shoe

class ShoeDetailsViewModel : ViewModel() {

    val shoeName = MutableLiveData<String>()
    val shoeSize = MutableLiveData<String>()
    val shoeCompany = MutableLiveData<String>()
    val shoeDescription = MutableLiveData<String>()

    fun addNewShoe() : Shoe{
        return Shoe(shoeName.value?: "", shoeSize.value?: "", shoeCompany.value?: "", shoeDescription.value?: "")
    }
}