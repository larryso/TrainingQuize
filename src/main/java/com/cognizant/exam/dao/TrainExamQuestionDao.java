package com.cognizant.exam.dao;

import com.cognizant.exam.bean.entity.TrainingExamQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainExamQuestionDao extends JpaRepository<TrainingExamQuestion, Long> {
}
