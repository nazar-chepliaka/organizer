package com.nazarka_labs.organizer.ui.checklists

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.nazarka_labs.organizer.databinding.FragmentChecklistsBinding

class ChecklistsFragment : Fragment() {

    private lateinit var checklistsViewModel: ChecklistsViewModel
    private var _binding: FragmentChecklistsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        checklistsViewModel =
            ViewModelProvider(this).get(ChecklistsViewModel::class.java)

        _binding = FragmentChecklistsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textSlideshow
        checklistsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}