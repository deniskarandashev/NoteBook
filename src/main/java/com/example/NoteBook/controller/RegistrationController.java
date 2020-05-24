package com.example.NoteBook.controller;

import com.example.NoteBook.domain.Role;
import com.example.NoteBook.domain.User;
import com.example.NoteBook.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Collections;
import java.util.Map;

/**
 * @author Denis Karandashev
 * @project NoteBook
 * @date 22.05.2020
 */

@Controller
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model){
        User userLoginFromDB = userRepo.findByUsername(user.getUsername());

        if (userLoginFromDB != null){
            model.put("message", " User already exists");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);
        //return "/login";
        return "redirect:/login";
    }
}
