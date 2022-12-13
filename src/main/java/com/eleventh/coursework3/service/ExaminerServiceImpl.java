package com.eleventh.coursework3.service;

import com.eleventh.coursework3.exception.BadRequestException;
import com.eleventh.coursework3.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final List<QuestionService> questionServices;
    private final UtilService utilService;

    public ExaminerServiceImpl(List<QuestionService> questionServices, UtilService utilService) {
        this.questionServices = questionServices;
        this.utilService = utilService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount <= 0 || calculateAmountOfQuestions() < amount) {
            throw new BadRequestException("Incorrect amount " + amount);
        }
        Set<Question> result = new HashSet<>();
        while (result.size() < amount) {
            var serviceNumber = utilService.getRandomInt(questionServices.size());
            var questionService = questionServices.get(serviceNumber);
            result.add(questionService.getRandomQuestion());
        }
        return result;
    }

    private int calculateAmountOfQuestions() {
        return questionServices.stream()
                .mapToInt(s -> s.getAll().size())
                .sum();
    }
}
