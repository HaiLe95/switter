package com.annle.switter.controller;

import com.annle.switter.model.Note;
import com.annle.switter.model.User;
import com.annle.switter.service.note.NoteServiceImpl;
import com.annle.switter.service.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.jws.WebParam;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private NoteServiceImpl noteService;

    @GetMapping("/register")
    public String register(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register_form";
    }

    @PostMapping("/register")
    public String submitRegistration(@ModelAttribute("user") User user) {
        userService.add(user);
        return "register_success";
    }

    @GetMapping("/singin")
    public String singIn(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "sing_in";
    }

    @PostMapping("/signin")
    public String signingIn(@ModelAttribute("user") User user, Model model) {
        if(userService.isRegistered(user.getUsername(), user.getPassword())) {
            return "my_feed";
        } else {
            return "failed";
        }
    }

    @GetMapping("/my_feed")
    public String getNotes(Model model) {
        System.out.println("hereeeee");
        Note note = new Note();
        model.addAttribute("note", note);
        List<Note> notes = noteService.getAll();
        model.addAttribute("notesList", notes);
        System.out.println(notes);
        return "my_feed";
    }

    @GetMapping("/switt")
    public String addNote(Model model) {
        Note note = new Note();
        model.addAttribute("note", note);
        return "add_switt";
    }

    @PostMapping("/switt")
    public String submitNote(@ModelAttribute("note") Note note, Model model) {
        noteService.add(note);
        return "my_feed";
    }

}
