package com.nazarka_labs.organizer.ui.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import androidx.recyclerview.widget.LinearLayoutManager
import com.nazarka_labs.organizer.databinding.FragmentNotesBinding

class NotesFragment : Fragment() {

    private lateinit var notesViewModel: NotesViewModel
    private var _binding: FragmentNotesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notesViewModel =
            ViewModelProvider(this).get(NotesViewModel::class.java)

        _binding = FragmentNotesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /*

        https://github.com/codeWithCal/TodoListTutorialProject/blob/RecyclerViewTutorial_Part_2/app/src/main/java/com/example/todolisttutorial/MainActivity.kt

        binding.newNotesButton.setOnClickListener {
            QuickNoteSheet(null).show(supportFragmentManager, "newTaskTag")
        }

        notesViewModel.notesItems.observe(viewLifecycleOwner){
            binding.todoListRecyclerView.apply {
                layoutManager = LinearLayoutManager(applicationContext)
                adapter = TaskItemAdapter(it, mainActivity)
            }
        }

        */

        return root
    }

    /*

    fun editNotesItem(notesItem: NotesItem)
    {
        QuickNoteSheet(notesItem).show(supportFragmentManager,"newTaskTag")
    }
    */

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

