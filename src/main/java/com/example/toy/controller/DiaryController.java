package com.example.toy.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.toy.model.Diary;
import com.example.toy.repository.DiaryRepository;

@Controller
public class DiaryController {
    @Autowired
    DiaryRepository diaryRepository;
    
    @GetMapping("/diaryview")
    public String diaryview() {
        return "/diary/diaryview";
    }
    
    // 조회하는 기능?
    @GetMapping("/diarylist")
    public String diarylist(Model model) {
        List<Diary> diaryList = diaryRepository.findAll();
        model.addAttribute("diaryList", diaryList);
        return "/diary/diarylist";
    }

    @GetMapping("/diary")
    public String diary() {
        return "/diary/diary";
    }

    @PostMapping("/diary")
    public String diaryPost(@ModelAttribute Diary diary) {
        diary.setCreDate(new Date());
        diaryRepository.save(diary);
        return "redirect:/";
    }
}
