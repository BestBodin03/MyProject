package com.example.myproject.ui.home

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myproject.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val spinner: Spinner = binding.sexSpinner
        val arrayList = arrayListOf("Male", "Female", "Not choose")
        val adapter = ArrayAdapter(requireContext(), R.layout.simple_spinner_item, arrayList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        val day_spinner: Spinner = binding.daySpinner
        val day_arrayList = arrayListOf("Sunday", "Monday", "Not choose")
        val day_adapter = ArrayAdapter(requireContext(), R.layout.simple_spinner_item, day_arrayList)
        day_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        day_spinner.adapter= day_adapter

        val place_spinner: Spinner = binding.placeSpinner
        val place_arrayList = arrayListOf("วัด", "ห้าง", "สถานที่ราชการ")
        val place_adapter = ArrayAdapter(requireContext(), R.layout.simple_spinner_item, place_arrayList)
        place_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        place_spinner.adapter= place_adapter

        homeViewModel.text.observe(viewLifecycleOwner) {
            // Do something with the text observed from ViewModel
        }

        return root
    }
}
