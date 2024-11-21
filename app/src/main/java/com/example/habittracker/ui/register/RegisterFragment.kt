package com.example.habittracker.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.habittracker.databinding.FragmentRegisterBinding
import com.example.habittracker.viewmodel.UserViewModel

class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding
    private lateinit var viewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.registerButton.setOnClickListener {
            val username = binding.registerUsernameEditText.text.toString()
            val password = binding.registerPasswordEditText.text.toString()

            viewModel.register(username, password) { success, error ->
                if (success) {
                    view?.findNavController()?.navigate(RegisterFragmentDirections.actionRegisterFragmentToLoginFragment())
                } else {
                    Toast.makeText(context, "Registration failed: $error", Toast.LENGTH_LONG).show()
                }
            }
        }

        return binding.root
    }
}
