package com.example.coursework2.service;

import com.example.coursework2.exceptions.QuestionAlreadyExistsException;
import com.example.coursework2.exceptions.QuestionNotFoundException;
import com.example.coursework2.exceptions.StorageIsEmptyException;
import com.example.coursework2.interfac.QuestionService;
import com.example.coursework2.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private static final Random RANDOM = new Random();
    private Set<Question> questions = new HashSet<>();


    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        if (questions.add(question)) {
            return question;
        }
        throw new QuestionAlreadyExistsException();
    }

    @Override
    public Question remove(Question question) {
        if (questions.remove(question)) {
            return question;
        }
        throw new QuestionNotFoundException();
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            throw new StorageIsEmptyException();
        }
        int index = RANDOM.nextInt(questions.size());
        return questions.stream()
                .skip(index)
                .findFirst()
                .orElse(null);
    }
}
