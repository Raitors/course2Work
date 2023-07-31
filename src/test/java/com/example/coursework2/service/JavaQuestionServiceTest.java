package com.example.coursework2.service;

import com.example.coursework2.model.Question;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class JavaQuestionServiceTest {
    JavaQuestionService javaQuestionService = new JavaQuestionService();

    @Test
    void add() {
        javaQuestionService.add(new Question("asd", "zxc"));
        javaQuestionService.add(new Question("qwe", "ert"));

        Collection<Question> actual = javaQuestionService.getAll();
        assertEquals(2, actual.size());
        assertTrue(actual.contains(new Question("asd", "zxc")));
        assertTrue(actual.contains(new Question("qwe", "ert")));

    }

    @Test
    void remove() {
        javaQuestionService.add(new Question("asd", "zxc"));
        javaQuestionService.add(new Question("qwe", "ert"));
        Collection<Question> actual = javaQuestionService.getAll();

        javaQuestionService.remove(new Question("asd","zxc"));

        assertEquals(1,actual.size());

        assertFalse(actual.contains(new Question("asd", "zxc")));
        assertTrue(actual.contains(new Question("qwe", "ert")));
    }

}
