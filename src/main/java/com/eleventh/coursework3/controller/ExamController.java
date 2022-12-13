package com.eleventh.coursework3.controller;

import com.eleventh.coursework3.model.Question;
import com.eleventh.coursework3.service.ExaminerService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable("amount") Integer amount){
        return examinerService.getQuestions(amount);
    }
}
