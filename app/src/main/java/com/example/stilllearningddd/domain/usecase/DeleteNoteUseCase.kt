package com.example.stilllearningddd.domain.usecase

import com.example.stilllearningddd.domain.model.Note
import com.example.stilllearningddd.domain.repository.NoteRepository

class DeleteNoteUseCase(private val repository: NoteRepository) {
    operator fun invoke(note: Note)= repository.deleteNote(note)
}