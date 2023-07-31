package com.example.coursework2.interfac;

import com.example.coursework2.model.Question;

import java.util.Collection;

public interface ExaminerService {
  Collection<Question> getQuestions(int amount);
}
