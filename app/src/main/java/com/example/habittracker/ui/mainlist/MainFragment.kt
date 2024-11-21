package com.example.habittracker.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.habittracker.adapter.HabitAdapter
import com.example.habittracker.databinding.FragmentMainBinding
import com.example.habittracker.viewmodel.HabitViewModel

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var viewModel: HabitViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(HabitViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.habitsRecyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = HabitAdapter()
        binding.habitsRecyclerView.adapter = adapter

        viewModel.habitList.observe(viewLifecycleOwner) { habits ->
            adapter.submitList(habits)
        }

        viewModel.fetchHabits()

        binding.addHabitButton.setOnClickListener {
            view.findNavController().navigate(MainFragmentDirections.actionMainFragmentToHabitDetailFragment())
        }
    }
}
