package cf.josephmaged.shoeapp.screens.shoeDetails

import androidx.lifecycle.ViewModel
import cf.josephmaged.shoeapp.models.Shoe

class ShoeDetailsViewModel : ViewModel() {

    val shoes: MutableList<Shoe> = mutableListOf()

    init {

    }
}