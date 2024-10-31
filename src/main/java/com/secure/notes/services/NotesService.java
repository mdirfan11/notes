package com.secure.notes.services;

import com.secure.notes.models.Notes;

import java.util.List;

public interface NotesService {

    Notes createNoteForUser(Notes notes);

    Notes updateNoteForUser(Long noteId, Notes notes);

    void deleteNoteForUser(Long noteId);

    List<Notes> getNotesForUser(String userName);

}
