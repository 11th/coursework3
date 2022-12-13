package com.eleventh.coursework3.repository;

import com.eleventh.coursework3.exception.BadRequestException;
import com.eleventh.coursework3.exception.NotFoundException;
import com.eleventh.coursework3.model.Question;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
public class MathQuestionRepository implements QuestionRepository {
    private final Set<Question> questions = new HashSet<>();

    @PostConstruct
    private void init() {
        questions.add(new Question("MathQuestion1", "Answer1"));
        questions.add(new Question("MathQuestion2", "Answer2"));
        questions.add(new Question("MathQuestion3", "Answer3"));
    }

    @Override
    public Question add(Question question) {
        if (question == null){
            throw new BadRequestException("Define question to add");
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.contains(question)){
            throw new NotFoundException("Question not found");
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }
}
