package com.example.Notes_App.Controller;


import com.example.Notes_App.entities.Note;
import org.springframework.ui.Model;
import com.example.Notes_App.servies.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
public class NoteController {
    @Autowired
    NoteService noteService;

    @GetMapping("/notes")
    public String viewNotes(Model model , Principal principal) {
        List<Note> notes = noteService.getAllNotes(principal.getName()); // or however you retrieve them

        model.addAttribute("notes", notes);
        return "notes";
    }

  @PostMapping("/notes")
    public String addNote(@RequestParam("title") String title, Principal principal) {
        noteService.addNote(principal.getName(), title);
        System.out.println("Note added: " + title);
        return "redirect:/notes";
    }
}

