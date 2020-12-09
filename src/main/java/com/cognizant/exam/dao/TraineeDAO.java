package com.cognizant.exam.dao;

import com.cognizant.exam.bean.entity.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraineeDAO extends JpaRepository<Trainee, Long> {
    Trainee findByEmployId(String employId);
}
