package cf.josephmaged.shoeapp.screens.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import cf.josephmaged.shoeapp.R
import cf.josephmaged.shoeapp.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentWelcomeBinding = DataBindingUtil.inflate(
        inflater,
            R.layout.fragment_welcome, container,false
    )
        binding.apply {
            nextButton.setOnClickListener { view: View ->
                    Navigation.findNavController(view).navigate(R.id.action_welcomeFragment_to_instructionsFragment)
            }
        }
        return binding.root
    }
    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = "Welcome"
    }
}