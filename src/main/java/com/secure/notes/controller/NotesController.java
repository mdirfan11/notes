package com.secure.notes.controller;

import com.secure.notes.models.Notes;
import com.secure.notes.services.NotesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NotesController {

    @Autowired
    private NotesService notesService;

    private static final Logger LOGGER = LoggerFactory.getLogger(NotesController.class);

    @PostMapping
    public Notes createNote(
            @RequestBody Notes notes,
            @AuthenticationPrincipal UserDetails userDetails
            ) {
        LOGGER.info("NotesController :: createNote :: started");
        String userName = userDetails.getUsername();
        LOGGER.info("USER NAME : {}", userName);
        notes.setOwnerUserName(userName);
        LOGGER.info("NotesController :: createNote :: end");
        return notesService.createNoteForUser(notes);
    }

    @GetMapping
    public List<Notes> getUserNotes(@AuthenticationPrincipal UserDetails userDetails) {
        LOGGER.info("NotesController :: getUserNotes :: started");
        LOGGER.info("USER NAME : {}", userDetails.getUsername());
        LOGGER.info("NotesController :: getUserNotes :: end");
        return notesService.getNotesForUser(userDetails.getUsername());
    }

    @PutMapping("/{noteId}")
    public Notes updateNote(
            @PathVariable Long noteId,
            @RequestBody Notes note,
            @AuthenticationPrincipal UserDetails userDetails
    ) {
        LOGGER.info("NotesController :: updateNote :: started");
        LOGGER.info("USER NAME : {}", userDetails.getUsername());
        note.setOwnerUserName(userDetails.getUsername());
        LOGGER.info("NotesController :: updateNote :: end");
        return notesService.updateNoteForUser(noteId, note);
    }

    @DeleteMapping("/{noteId}")
    public void deleteNote(@PathVariable Long noteId) {
        LOGGER.info("NotesController :: deleteNote :: started");
        notesService.deleteNoteForUser(noteId);
        LOGGER.info("NotesController :: deleteNote :: end");
    }

}
