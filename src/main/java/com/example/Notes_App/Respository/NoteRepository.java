package com.example.Notes_App.Respository;

import com.example.Notes_App.entities.Note;
import com.example.Notes_App.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    // Custom query methods can be defined here if needed
    // For example, find notes by user ID or
    List<Note> findByUser(User user);
}
