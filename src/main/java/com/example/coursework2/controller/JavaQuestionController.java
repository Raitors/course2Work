package com.example.coursework2.controller;


import com.example.coursework2.model.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.coursework2.interfac.QuestionService;
import com.example.coursework2.service.JavaQuestionService;


import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    private final QuestionService service;
    public JavaQuestionController(JavaQuestionService service) {
        this.service = service;
    }
    @GetMapping("/add")
    public Question addQuestion(@RequestParam("question") String question,
                                @RequestParam("answer") String answer) {
        return service.add(question, answer);
    }

    @GetMapping("remove")
    public Question removeQuestion(@RequestParam("question") String question,
                                   @RequestParam("answer") String answer) {
        return service.remove(new Question(question, answer));
    }


    @GetMapping
    public Collection<Question> getAll() {
        return service.getAll();
    }

}
