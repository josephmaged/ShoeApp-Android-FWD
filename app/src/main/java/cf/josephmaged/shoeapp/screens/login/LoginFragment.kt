package cf.josephmaged.shoeapp.screens.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import cf.josephmaged.shoeapp.R
import cf.josephmaged.shoeapp.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    var userEmail: String = "jmaged2012@gmail.com"
    var userPassword: String = "123456"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentLoginBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_login, container, false
        )
        binding.apply {
            btnLogin.setOnClickListener { view: View ->
                if (editTextEmailAddress.text.toString() == userEmail && editTextPassword.text.toString() == userPassword) {
                    Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_welcomeFragment)
                } else {
                    Toast.makeText(context, "Please enter correct Email and Password", Toast.LENGTH_SHORT).show()
                }
            }
        }
        return binding.root
    }

}