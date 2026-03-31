package com.secure.notes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.secure.notes.models.Note;
import com.secure.notes.repository.NoteRepository;
import com.secure.notes.service.NoteService;

@Service
public class NoteServiceImpl implements NoteService {

  @Autowired
  private NoteRepository noteRepo;

  @Override
  public Note createNoteForUser(String username, String content){
    Note note = new Note();
    note.setOwnerUsername(username);
    note.setContent(content);
    return noteRepo.save(note);
  }

  @Override
  public Note updateNoteForUser(Long noteId, String content, String username){
    Note note = noteRepo.findById(noteId).orElseThrow(() -> new RuntimeException("Note not found"));
    if(!note.getOwnerUsername().equals(username)){
      throw new RuntimeException("Unauthorized");
    } 
    note.setContent(content);
    return noteRepo.save(note);
  }

  @Override
  public void deleteNoteForUser(Long noteId, String username) {
    Note note = noteRepo.findById(noteId).orElseThrow(() -> new RuntimeException("Note not found"));
    if(!note.getOwnerUsername().equals(username)){
      throw new RuntimeException("Unauthorized");
    } 
    noteRepo.delete(note);
  }

  @Override
  public List<Note> getNotesForUser(String username) {
    List<Note> notes = noteRepo.findByOwnerUsername(username);
    // if(!notes.get(0).getOwnerUsername().equals(username)){
    //   throw new RuntimeException("Unauthorized");
    // }
    return notes;
  }


}
