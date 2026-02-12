package com.example.stilllearningddd.domain.repository

import com.example.stilllearningddd.domain.model.Note

interface NoteRepository {
    fun addNote(note: Note)
    fun getNotes(): List<Note>
    fun deleteNote(note: Note)
}