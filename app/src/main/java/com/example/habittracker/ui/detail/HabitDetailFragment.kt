package com.example.habittracker.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import com.example.habittracker.R
import com.example.habittracker.databinding.FragmentHabitDetailBinding

class HabitDetailFragment : Fragment() {
    private lateinit var binding: FragmentHabitDetailBinding
    private val viewModel: com.example.habittracker.viewmodel.HabitViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_habit_detail,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.saveButton.setOnClickListener {

        }
    }
}
