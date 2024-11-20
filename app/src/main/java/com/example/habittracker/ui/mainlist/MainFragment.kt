package com.example.habittracker.ui.mainlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.habittracker.R
import com.example.habittracker.adapter.HabitAdapter
import com.example.habittracker.databinding.FragmentMainBinding
import com.example.habittracker.viewmodel.HabitViewModel

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private val viewModel: HabitViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
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
        binding.addHabitButton.setOnClickListener {
            view.findNavController().navigate(R.id.action_mainFragment_to_habitDetailFragment)
        }
    }
}