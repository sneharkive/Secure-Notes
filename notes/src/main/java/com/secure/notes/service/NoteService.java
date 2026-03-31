package com.secure.notes.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.secure.notes.models.Note;

@Service
public interface NoteService {
  public Note createNoteForUser(String username, String content);

  Note updateNoteForUser(Long noteId, String content, String username);

  void deleteNoteForUser(Long noteId, String username);

  List<Note> getNotesForUser(String username);
}
