package com.cognizant.exam.bean.entity;

import lombok.Data;
import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "t_training_exam_question")
@Table(appliesTo = "t_training_exam_question",comment = "测试试题")
@Data
public class TrainingExamQuestion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String subject;
    @Column
    private String optionA;
    @Column
    private String optionB;
    @Column
    private String optionC;
    @Column
    private String optionD;
    @Column
    private String rightAnswer;
}
