package com.example.Notes_App.servies;

import com.example.Notes_App.Respository.NoteRepository;
import com.example.Notes_App.Respository.UserRepository;
import com.example.Notes_App.entities.Note;
import com.example.Notes_App.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private UserRepository userRepository;
    // Add your service methods here


    public List<Note> getAllNotes(String username) {
        User user = userRepository.findByUsername(username).orElse(null);
        return noteRepository.findByUser(user);
    }


    public void addNote(String username, String title) {
        User user = userRepository.findByUsername(username).orElseThrow();
        Note note = new Note();
        note.setTitle(title);
        note.setUser(user);
        noteRepository.save(note);
    }


}
