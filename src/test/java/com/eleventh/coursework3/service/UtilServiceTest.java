package com.eleventh.coursework3.service;

import com.eleventh.coursework3.model.Question;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
class UtilServiceTest {
    private static class CustomRandom extends Random {
        public CustomRandom() {
            super();
        }

        public int nextInt(int bound) {
            return bound;
        }
    }

    @InjectMocks
    private UtilService out;

    @Mock
    CustomRandom random;

    @BeforeEach
    void setUp() {
        out = new UtilService();
        out.setRandom(random);
    }

    @Test
    void getRandomQuestion() {
        Question expected1 = new Question("Question1", "Answer1");
        Question expected2 = new Question("Question2", "Answer2");
        Question expected3 = new Question("Question3", "Answer3");
        List<Question> list = List.of(expected1, expected2, expected3);
        Mockito.when(random.nextInt(anyInt())).thenReturn(list.size() - 1);
        Question actual = out.getRandomQuestion(list);
        Assertions.assertThat(actual).isEqualTo(list.get(list.size() - 1));
    }

    @Test
    void getRandomQuestionForEmptyCollection() {
        Mockito.when(random.nextInt(anyInt())).thenReturn(0);
        Question actual = out.getRandomQuestion(Collections.emptyList());
        Assertions.assertThat(actual).isNull();
    }
}