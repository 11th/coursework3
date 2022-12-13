package com.eleventh.coursework3.service;

import com.eleventh.coursework3.model.Question;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Random;

public class UtilService {
    private Random random;

    @Autowired
    public void setRandom(Random random) {
        this.random = random;
    }

    public int getRandomInt(int bound) {
        return random.nextInt(bound);
    }

    public Question getRandomQuestion(Collection<Question> questions) {
        int questionNum = getRandomInt(questions.size());
        int questionCur = 0;
        for (Question question : questions) {
            if (questionCur == questionNum) {
                return question;
            }
            questionCur++;
        }
        return null;
    }
}
