package com.example.toy.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.toy.model.Diary;
import com.example.toy.repository.DiaryRepository;

@Controller
public class DiaryController {
    @Autowired
    DiaryRepository diaryRepository;

    @GetMapping("/diaryview/{id}")
    public String diaryview(Model model, @PathVariable("id") long id) {
        Optional<Diary> view = diaryRepository.findById(id);
        Diary diary = view.get();
        model.addAttribute("diary", diary);
        return "/diary/diaryview";
    }

    // 조회하는 기능?
    @GetMapping("/diarylist")
    public String diarylist(Model model) {
        List<Diary> diaryList = diaryRepository.findAll();
        model.addAttribute("diaryList", diaryList);
        return "/diary/diarylist";
    }

    // @PostMapping("/diarylist")
    // public String diarylistPost(@ModelAttribute Diary diary) {
    //     diaryRepository.save(diary);
    //     return "redirect:/diary/diarylist"; // POST 요청 처리 후 다른 페이지로 리다이렉트
    // }

    @GetMapping("/diary")
    public String diary() {
        return "/diary/diary";
    }

    @PostMapping("/diary")
    public String diaryPost(@ModelAttribute Diary diary) {
        diary.setCreDate(new Date());
        diaryRepository.save(diary);
        return "redirect:/diarylist";
    }
}
