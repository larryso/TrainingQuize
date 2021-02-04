package com.cognizant.exam.bean.entity;

import lombok.Data;
import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "t_trainee")
@Table(appliesTo = "t_trainee",comment = "参加培训人")
@Data
public class Trainee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String employId;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String answers;
    @Column
    private String score;
    @Column
    private String status;
}
