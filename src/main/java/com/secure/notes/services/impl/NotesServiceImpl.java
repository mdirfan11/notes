package com.secure.notes.services.impl;

import com.secure.notes.models.Notes;
import com.secure.notes.repositories.NotesRepository;
import com.secure.notes.services.NotesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotesServiceImpl implements NotesService {

    @Autowired
    private NotesRepository notesRepositories;

    private static final Logger LOGGER = LoggerFactory.getLogger(NotesService.class);

    @Override
    public Notes createNoteForUser(Notes notes) {
        LOGGER.info("NotesServiceImpl :: createNoteForUser :: started");
        LOGGER.info("NotesServiceImpl :: createNoteForUser :: end");
        return notesRepositories.save(notes);
    }

    @Override
    public Notes updateNoteForUser(Long noteId, Notes newNotes) {
        LOGGER.info("NotesServiceImpl :: updateNoteForUser :: started");
        LOGGER.info("note id : {}", noteId);
        Notes notes = notesRepositories.findById(noteId).orElseThrow(() ->
                new RuntimeException("Note not Found")
                );
        notes.setDescription(newNotes.getDescription());
        notes.setContent(newNotes.getContent());
        LOGGER.info("note : {}", notes);
        LOGGER.info("NotesServiceImpl :: updateNoteForUser :: end");
        return notesRepositories.save(notes);
    }

    @Override
    public void deleteNoteForUser(Long noteId) {
        LOGGER.info("NotesServiceImpl :: deleteNoteForUser :: started");
        Notes note = notesRepositories.findById(noteId).orElseThrow(() ->
                new RuntimeException("Note not found")
                );
        notesRepositories.deleteById(noteId);
        LOGGER.info("NotesServiceImpl :: deleteNoteForUser :: end");
    }

    @Override
    public List<Notes> getNotesForUser(String userName) {
        LOGGER.info("NotesServiceImpl :: getNotesForUser :: started");
        LOGGER.info("NotesServiceImpl :: getNotesForUser :: end");
        return notesRepositories.findByOwnerUserName(userName);
    }
}
