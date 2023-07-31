package com.example.coursework2.controller;

import com.example.coursework2.interfac.ExaminerService;
import com.example.coursework2.model.Question;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }
    @GetMapping("/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable(name="amount")int amount){
        return  examinerService.getQuestions(amount);
    }
}
