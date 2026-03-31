package com.secure.notes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.secure.notes.models.Note;
import java.util.List;


@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
  List<Note> findByOwnerUsername(String ownerUsername);
}
