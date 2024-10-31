package com.secure.notes.repositories;

import com.secure.notes.models.Notes;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Transactional
public interface NotesRepository extends JpaRepository<Notes, Long> {

    List<Notes> findByOwnerUserName(String ownerUserName);

}
