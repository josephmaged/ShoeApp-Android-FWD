package cf.josephmaged.shoeapp.screens.shoeDetails

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import cf.josephmaged.shoeapp.R
import cf.josephmaged.shoeapp.databinding.FragmentShoeDetailsBinding
import cf.josephmaged.shoeapp.models.Shoe
import cf.josephmaged.shoeapp.screens.shoeList.ShoeListFragment
import kotlin.math.log

class ShoeDetailsFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailsBinding
    private val viewModel: ShoeDetailsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_details, container, false
        )

        binding.btnCancel.setOnClickListener { view: View ->
            Navigation.findNavController(view).navigate(R.id.action_shoeDetailsFragment_to_shoeListFragment)
        }

        binding.btnSave.setOnClickListener { view: View ->
            onSave(view)
        }

        return binding.root
    }

    fun onSave(view: View) {
        viewModel.addShoe(
            Shoe(
                binding.shoeName.toString(),
                binding.shoeSize.toString(),
                binding.company.toString(),
                binding.description.toString()
            )
        )
        Navigation.findNavController(view).navigate(R.id.action_shoeDetailsFragment_to_shoeListFragment)
        Toast.makeText(context, viewModel.shoes.toString(), Toast.LENGTH_LONG).show()
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = "Shoe Details"
    }

    override fun onPause() {
        super.onPause()
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
    }
}

