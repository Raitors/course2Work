package com.example.coursework2.service;

import com.example.coursework2.exceptions.NotEnoughQuestionException;
import com.example.coursework2.interfac.ExaminerService;
import com.example.coursework2.interfac.QuestionService;
import com.example.coursework2.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService service;

    public ExaminerServiceImpl(QuestionService service) {
        this.service = service;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if(amount>service.getAll().size()){
            throw new NotEnoughQuestionException();
        }
        return Stream.generate(service::getRandomQuestion)
                .distinct()
                .limit(amount)
                .collect(Collectors.toList());
    }
}
