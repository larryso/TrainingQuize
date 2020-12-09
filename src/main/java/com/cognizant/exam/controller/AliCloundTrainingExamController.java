package com.cognizant.exam.controller;

import com.cognizant.exam.bean.entity.Trainee;
import com.cognizant.exam.bean.entity.TrainingExamQuestion;
import com.cognizant.exam.service.TrainExamService;
import com.cognizant.exam.service.TraineeService;
import com.cognizant.exam.utils.ExamUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AliCloundTrainingExamController {
    @Autowired
    private TrainExamService trainExamService;
    @Autowired
    private TraineeService traineeService;

    @GetMapping("/greeting")
    public ModelAndView greeting(ModelAndView mv) {
        mv.setViewName("/index");
//        mv.addObject("title","欢迎使用Thymeleaf!");
        return mv;
    }

    @PostMapping("signTraining")
    @ResponseBody
    public Map<String, Object> signTraining(@RequestBody Trainee trainee) {
        Map<String, Object> result = new HashMap<>();
        try{
            trainExamService.traineeSign(trainee);
            result.put("code",200);
        }catch (Exception e){
            result.put("message",e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
    @GetMapping("/trainingExam")
    public ModelAndView trainingExam(HttpServletRequest request, ModelAndView mv) {
        String employId = request.getParameter("employId");
        System.out.println("$$$$$$$$$$$"+employId);
        mv.setViewName("/exam_questions");
        mv.addObject("employId",employId);
        List<TrainingExamQuestion> questionList = trainExamService.loadAllQuestions();
        mv.addObject("questionList",questionList);
        return mv;
    }
    @PostMapping("submitPaper")
    public ModelAndView submitPaper(HttpServletRequest request, ModelAndView mv) {
        String employId = request.getParameter("employId");
        System.out.println(employId);
        String[] q1= request.getParameterValues("q1");
        String[] q2= request.getParameterValues("q2");
        String[] q3= request.getParameterValues("q3");
        String[] q4= request.getParameterValues("q4");
        String[] q5= request.getParameterValues("q5");
        String[] q6= request.getParameterValues("q6");
        String[] q7= request.getParameterValues("q7");
        String[] q8= request.getParameterValues("q8");
        String[] q9= request.getParameterValues("q9");
        String[] q10= request.getParameterValues("q10");
        StringBuffer sb = new StringBuffer();
        sb.append(q1[0]).
                append(q2[0]).
                append(q3[0]).
                append(q4[0]).
                append(q5[0]).
                append(q6[0]).
                append(q7[0]).
                append(q8[0]).append(q9[0]).append(q10[0]);
        String myAnswerStr =sb.toString();
        System.out.println("myAnser:"+myAnswerStr);
        Trainee trainee = traineeService.findTraineeByEmployId(employId);
        List<TrainingExamQuestion> questionList = trainExamService.loadAllQuestions();
        //calculate score
        String rightAnswerStr = "";
        for(TrainingExamQuestion q: questionList){
            rightAnswerStr = rightAnswerStr+q.getRightAnswer();
        }
        System.out.println("rightanswer："+rightAnswerStr);
        int trueAnswer = ExamUtils.countStr(rightAnswerStr, myAnswerStr);
        System.out.println(trueAnswer);
        trainee.setAnswers(myAnswerStr);
        int myScore = trueAnswer*10;
        trainee.setScore(trueAnswer*10+"");
        if(myScore>=60){
            trainee.setStatus("PASS");
        }else{
            trainee.setStatus("NOT PASS");
        }
        trainee = traineeService.save(trainee);
        mv.addObject("trainee",trainee);
        mv.setViewName("/my_exam");
        mv.addObject("questionList",questionList);
        return mv;
    }
}
