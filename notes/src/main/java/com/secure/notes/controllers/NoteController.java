package com.secure.notes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.secure.notes.models.Note;
import com.secure.notes.service.NoteService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/notes")
public class NoteController {
  
  @Autowired
  private NoteService noteService;

  @PostMapping("/create")
  public Note createNote(@RequestBody String content, @AuthenticationPrincipal UserDetails userDetails) {
    String username = userDetails.getUsername();
    System.out.println("Creating note for user: " + username);
    return noteService.createNoteForUser(username, content);
  }

  @GetMapping("/all")
  public List<Note> getUserNotes(@AuthenticationPrincipal UserDetails userDetails) {
      String username = userDetails.getUsername();
      System.out.println("Fetching notes for user: " + username);
      return noteService.getNotesForUser(username);
  }
  
  @PutMapping("update/{noteId}")
  public Note updateNote(@PathVariable Long noteId, @RequestBody String content, @AuthenticationPrincipal UserDetails userDetails) {
      String username = userDetails.getUsername();
      System.out.println("Updating note for user: " + username);
      return noteService.updateNoteForUser(noteId, content, username);
  }

  @DeleteMapping("delete/{noteId}")
  public void deleteNote(@PathVariable Long noteId, @AuthenticationPrincipal UserDetails userDetails) {
      String username = userDetails.getUsername();
      System.out.println("Deleting note for user: " + username);
      noteService.deleteNoteForUser(noteId, username);
  }

}
