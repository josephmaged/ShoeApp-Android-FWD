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
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import androidx.navigation.Navigation
import cf.josephmaged.shoeapp.R
import cf.josephmaged.shoeapp.databinding.FragmentShoeDetailsBinding
import cf.josephmaged.shoeapp.models.Shoe
import kotlin.math.log

class ShoeDetailsFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailsBinding
    private lateinit var viewModel: ShoeDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_details, container, false
        )

        viewModel = ViewModelProvider(this)[ShoeDetailsViewModel::class.java]

        binding.btnCancel.setOnClickListener { view: View ->
            Navigation.findNavController(view).navigate(R.id.action_shoeDetailsFragment_to_shoeListFragment)
        }

        binding.btnSave.setOnClickListener {
            onSave()
         }

        return binding.root
    }

    fun onSave(){
        viewModel.shoes.add(
            Shoe(
                binding.shoeName.text.toString(),
                binding.shoeSize.text.toString().toDouble(),
                binding.company.text.toString(),
                binding.description.text.toString()
            )
        )
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
