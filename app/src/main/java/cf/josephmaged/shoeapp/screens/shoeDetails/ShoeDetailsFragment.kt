package cf.josephmaged.shoeapp.screens.shoeDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import cf.josephmaged.shoeapp.R
import cf.josephmaged.shoeapp.databinding.FragmentShoeDetailsBinding
import cf.josephmaged.shoeapp.screens.shoeList.ShoeViewModel


class ShoeDetailsFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailsBinding
    private lateinit var detailsViewModel: ShoeDetailsViewModel
    private val shoesViewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_details, container, false
        )

        detailsViewModel = ViewModelProvider(this)[ShoeDetailsViewModel::class.java]
        binding.viewModel = detailsViewModel
        binding.lifecycleOwner = this

        binding.btnCancel.setOnClickListener { view: View ->
            Navigation.findNavController(view).navigate(R.id.action_shoeDetailsFragment_to_shoeListFragment)
        }

        binding.btnSave.setOnClickListener { view: View ->
            val shoe = detailsViewModel.addNewShoe()
            shoesViewModel.addShoe(shoe)
            Navigation.findNavController(view).navigate(R.id.action_shoeDetailsFragment_to_shoeListFragment)
            Toast.makeText(context, shoe.toString(), Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }
}

