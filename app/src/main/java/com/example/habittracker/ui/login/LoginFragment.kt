package com.example.habittracker.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.habittracker.R
import com.example.habittracker.databinding.FragmentLoginBinding
import com.example.habittracker.viewmodel.UserViewModel

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel: UserViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        applyAnimations()

        binding.loginButton.setOnClickListener {
            val username = binding.usernameEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            viewModel.login(username, password) { success, message ->
                if (success) {
                    findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
                } else {
                    message?.let { showErrorMessage(it) }
                }
            }
        }

        binding.registerButton.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        return binding.root
    }

    private fun showErrorMessage(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    private fun applyAnimations() {
        val fadeIn = AnimationUtils.loadAnimation(requireContext(), R.anim.fade_in)
        val bottomDown = AnimationUtils.loadAnimation(requireContext(), R.anim.bottom_down)

        binding.backgroundShape.startAnimation(bottomDown)
        binding.loginTitleTextView.startAnimation(fadeIn)
        binding.usernameEditText.startAnimation(fadeIn)
        binding.passwordEditText.startAnimation(fadeIn)
        binding.loginButton.startAnimation(fadeIn)
        binding.registerButton.startAnimation(fadeIn)
        binding.habitTrackerLogo.startAnimation(fadeIn)
    }
}
