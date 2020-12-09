package com.cognizant.exam.service.impl;

import com.cognizant.exam.bean.entity.Trainee;
import com.cognizant.exam.dao.TraineeDAO;
import com.cognizant.exam.service.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TraineeServiceImpl implements TraineeService {
    @Autowired
    private TraineeDAO traineeDAO;
    @Override
    public Trainee findTraineeByEmployId(String exployId) {
        return traineeDAO.findByEmployId(exployId);
    }

    @Override
    public Trainee save(Trainee trainee) {
        return traineeDAO.save(trainee);
    }
}
