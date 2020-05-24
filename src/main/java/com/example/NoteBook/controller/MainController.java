package com.example.NoteBook.controller;

/**
 * @author Denis Karandashev
 * @project NoteBook
 * @date 21.05.2020
 */

import com.example.NoteBook.domain.Note;
import com.example.NoteBook.domain.User;
import com.example.NoteBook.repos.NotesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private NotesRepo notesRepo;

    @GetMapping("/")
    public String greeting(Model model) {
        return "NoteBook";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Note> notes = notesRepo.findAll();
        if (filter != null && !filter.isEmpty()) {
            notes = notesRepo.findByTag(filter);
        } else {
            notes = notesRepo.findAll();
        }
        model.addAttribute("notes", notes);
        model.addAttribute("filter", filter);

        return "main";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String tag, Model model
    ) {
        Note note = new Note(text, tag, user);

        notesRepo.save(note);

        Iterable<Note> notes = notesRepo.findAll();

        model.addAttribute("notes", notes);

        return "main";
    }
}