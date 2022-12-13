package com.eleventh.coursework3.service;

import com.eleventh.coursework3.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
