package com.cognizant.exam.service;

import com.cognizant.exam.bean.entity.Trainee;
import com.cognizant.exam.bean.entity.TrainingExamQuestion;

import java.util.List;

public interface TrainExamService {
    public Trainee traineeSign(Trainee trainee) throws Exception;
    public List<TrainingExamQuestion> loadAllQuestions();
}
