package com.nazarka_labs.organizer.ui.notes

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.nazarka_labs.organizer.databinding.FragmentQuickNoteSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class QuickNoteSheet(var notesItem: NotesItem?) : BottomSheetDialogFragment()
{
    private lateinit var binding: FragmentQuickNoteSheetBinding
    private lateinit var notesViewModel: NotesViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = requireActivity()

        if (notesItem != null)
        {
            binding.quickNoteTitle.text = "Редагувати нотатку"
            val editable = Editable.Factory.getInstance()
            binding.name.text = editable.newEditable(notesItem!!.name)
            binding.desc.text = editable.newEditable(notesItem!!.desc)
        }
        else
        {
            binding.quickNoteTitle.text = "Нова нотатка"
        }

        notesViewModel = ViewModelProvider(activity).get(NotesViewModel::class.java)
        binding.saveButton.setOnClickListener {
            saveAction()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentQuickNoteSheetBinding.inflate(inflater,container,false)
        return binding.root
    }


    private fun saveAction()
    {
        val name = binding.name.text.toString()
        val desc = binding.desc.text.toString()
        if(notesItem == null)
        {
            val newTask = NotesItem(name, desc)
            notesViewModel.addNotesItem(newTask)
        }
        else
        {
            notesViewModel.updateNotesItem(notesItem!!.id, name, desc)
        }
        binding.name.setText("")
        binding.desc.setText("")
        dismiss()
    }

}