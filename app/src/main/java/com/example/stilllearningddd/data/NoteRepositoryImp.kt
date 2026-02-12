package com.example.stilllearningddd.data

import com.example.stilllearningddd.domain.model.Note
import com.example.stilllearningddd.domain.repository.NoteRepository

class NoteRepositoryImpl : NoteRepository {
    private val notes = mutableListOf<Note>()
    private var id = 1
    override fun addNote(note: Note) {
        notes.add(note.copy(id = id++))
    }

    override fun getNotes(): List<Note> = notes.toList()

    override fun deleteNote(note: Note) {
        notes.removeIf { it.id == note.id }
    }
}
