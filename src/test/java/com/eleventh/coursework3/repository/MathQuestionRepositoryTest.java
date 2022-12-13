package com.eleventh.coursework3.repository;

import com.eleventh.coursework3.exception.BadRequestException;
import com.eleventh.coursework3.exception.NotFoundException;
import com.eleventh.coursework3.model.Question;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class MathQuestionRepositoryTest {
    private MathQuestionRepository out;

    @BeforeEach
    void setUp() {
        out = new MathQuestionRepository();
        out.add(new Question("MathQuestion1", "Answer1"));
        out.add(new Question("MathQuestion2", "Answer2"));
        out.add(new Question("MathQuestion3", "Answer3"));
    }

    @Test
    void addNewQuestion() {
        Question expected = new Question("MathQuestion4", "Answer4");
        Question actual = out.add(expected);
        Assertions.assertThat(actual).isEqualTo(expected);
        Assertions.assertThat(out.getAll().contains(expected)).isTrue();
        Assertions.assertThat(out.getAll().size()).isEqualTo(4);
    }

    @Test
    void addExistingQuestion() {
        Question expected = new Question("MathQuestion3", "Answer3");
        Assertions.assertThat(out.getAll().contains(expected)).isTrue();
        Question actual = out.add(expected);
        Assertions.assertThat(actual).isEqualTo(expected);
        Assertions.assertThat(out.getAll().size()).isEqualTo(3);
    }

    @Test
    void addNullQuestion() {
        Assertions.assertThatExceptionOfType(BadRequestException.class).isThrownBy(() -> {
            out.add(null);
        });
    }

    @Test
    void removeExistingQuestion() {
        Question expected = new Question("MathQuestion1", "Answer1");
        Question actual = out.remove(expected);
        Assertions.assertThat(actual).isEqualTo(expected);
        Assertions.assertThat(out.getAll().size()).isEqualTo(2);
    }

    @Test
    void removeNotExistingQuestion() {
        Assertions.assertThatExceptionOfType(NotFoundException.class).isThrownBy(() -> {
            out.remove(null);
        });
    }

    @Test
    void getAll() {
        Assertions.assertThat(out.getAll().size()).isEqualTo(3);
    }
}