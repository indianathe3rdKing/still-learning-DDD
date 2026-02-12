package com.example.stilllearningddd.presentation

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.stilllearningddd.data.NoteRepositoryImpl
import com.example.stilllearningddd.domain.model.Note
import com.example.stilllearningddd.domain.usecase.AddNotesUseCase
import com.example.stilllearningddd.domain.usecase.DeleteNoteUseCase
import com.example.stilllearningddd.domain.usecase.GetNotesUseCase

class NoteViewModel: ViewModel() {
    private val repository = NoteRepositoryImpl()
    private val addNotesUseCase= AddNotesUseCase(repository)
    private val getNotesUseCase= GetNotesUseCase(repository)
    private val deleteNoteUseCase= DeleteNoteUseCase(repository)

    var notes = mutableStateListOf<Note>()

    fun loadNotes(){
        notes.clear()
        notes.addAll(getNotesUseCase())
    }

    fun addNote(text: String){
        if (text.isNotBlank()){
            addNotesUseCase(Note(0,text))
            loadNotes()
        }
    }

    fun deleteNote(note: Note){
        deleteNoteUseCase(note)
        loadNotes()
    }
}