package com.example.toy.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.toy.model.User;
import com.example.toy.repository.UserRepository;

@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    HttpSession session;

    @GetMapping("/signout")
    public String signout() {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/signin")
    public String signin() {
        return "/sign/signin";
    }

    @PostMapping("/signin")
    public String signinPost(@ModelAttribute User user) {
        User dbUser = userRepository.findByEmailAndPwd(user.getEmail(), user.getPwd());
        if (dbUser != null) {
            session.setAttribute("user_info", dbUser);
        }
        return "redirect:/";
    }

    @GetMapping("/signup")
    public String signup() {
        return "/sign/signup";
    }

    @PostMapping("/signup")
    public String signupPost(@ModelAttribute User user) {
        userRepository.save(user);
        return "redirect:/";
    }
}
