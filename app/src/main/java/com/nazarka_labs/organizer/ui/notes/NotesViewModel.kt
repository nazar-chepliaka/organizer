package com.nazarka_labs.organizer.ui.notes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class NotesViewModel : ViewModel() {

    var notesItems = MutableLiveData<MutableList<NotesItem>>();

    init {
        notesItems.value = mutableListOf()
    }

    fun addNotesItem(newNotes: NotesItem)
    {
        val list = notesItems.value
        list!!.add(newNotes)
        notesItems.postValue(list!!)
    }

    fun updateNotesItem(id: UUID, name: String, desc: String)
    {
        val list = notesItems.value
        val note = list!!.find { it.id == id }!!
        note.name = name
        note.desc = desc
        notesItems.postValue(list!!)
    }
}