package com.cognizant.exam.service;

import com.cognizant.exam.bean.entity.Trainee;

public interface TraineeService {
    Trainee findTraineeByEmployId(String exployId);
    Trainee save(Trainee trainee);
}
