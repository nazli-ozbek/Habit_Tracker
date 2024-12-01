package com.example.habittracker.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.habittracker.R
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

        applyAnimations()

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
        binding.homeButton.setOnClickListener {
            // Navigate back to LoginFragment
            view?.findNavController()
                ?.navigate(RegisterFragmentDirections.actionRegisterFragmentToLoginFragment())
        }

        return binding.root
    }

    private fun applyAnimations() {
        val fadeIn = AnimationUtils.loadAnimation(requireContext(), R.anim.fade_in)
        val bottomDown = AnimationUtils.loadAnimation(requireContext(), R.anim.bottom_down)

        binding.backgroundShape.startAnimation(bottomDown)
        binding.loginTitleTextView.startAnimation(fadeIn)
        binding.registerUsernameEditText.startAnimation(fadeIn)
        binding.registerPasswordEditText.startAnimation(fadeIn)
        binding.homeButton.startAnimation(fadeIn)
        binding.registerButton.startAnimation(fadeIn)
        binding.habitTrackerLogo.startAnimation(fadeIn)
    }
}
