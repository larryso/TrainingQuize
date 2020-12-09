package com.cognizant.exam.service.impl;

import com.cognizant.exam.bean.entity.Trainee;
import com.cognizant.exam.bean.entity.TrainingExamQuestion;
import com.cognizant.exam.dao.TrainExamQuestionDao;
import com.cognizant.exam.dao.TraineeDAO;
import com.cognizant.exam.service.TrainExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainExamServiceImpl implements TrainExamService {
    @Autowired
    private TraineeDAO traineeDAO;
    @Autowired
    private TrainExamQuestionDao trainExamQuestionDao;
    @Override
    public Trainee traineeSign(Trainee trainee) throws Exception{
        Trainee trainee1 = traineeDAO.findByEmployId(trainee.getEmployId());
        if(trainee1 == null){
            return traineeDAO.save(trainee);
        }else{
            throw new Exception("already signed!");
        }

    }

    @Override
    public List<TrainingExamQuestion> loadAllQuestions() {
        return trainExamQuestionDao.findAll();
    }
}
