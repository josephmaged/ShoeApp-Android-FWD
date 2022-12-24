package cf.josephmaged.shoeapp.screens.shoeList

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import cf.josephmaged.shoeapp.R
import cf.josephmaged.shoeapp.databinding.FragmentShoeListBinding
import cf.josephmaged.shoeapp.databinding.ShoeItemBinding
import cf.josephmaged.shoeapp.models.Shoe
import cf.josephmaged.shoeapp.screens.shoeDetails.ShoeDetailsFragment
import cf.josephmaged.shoeapp.screens.shoeDetails.ShoeDetailsViewModel

class ShoeListFragment : Fragment(), MenuProvider {

    private lateinit var binding: FragmentShoeListBinding
    private val viewModel: ShoeDetailsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_list, container, false
        )

        viewModel.shoesList.observe(viewLifecycleOwner, Observer { shoeList ->
            for (shoe in shoeList) {
                val itemBinding = ShoeItemBinding.inflate(layoutInflater)
                itemBinding.shoeItem = shoe
                binding.parentLayout.addView(itemBinding.root)
            }
        })

        binding.apply {
            addShoe.setOnClickListener { view: View ->
                Navigation.findNavController(view).navigate(R.id.action_shoeListFragment_to_shoeDetailsFragment)
            }
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = "Shoe List"
    }

    override fun onPause() {
        super.onPause()
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.appbar_menu, menu)
    }


    override fun onMenuItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(
            item,
            requireView().findNavController()
        )
    }
}
