package com.example.demo.Controller;

import com.example.demo.Entity.arithreic;
import com.example.demo.Entity.score;
import com.example.demo.Entity.user;
import com.example.demo.domain.ArithRepository;
import com.example.demo.domain.scoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {
    @Autowired
    private ArithRepository arithRepository;
    @Autowired
    private scoreRepository ScoreRepository;

    //系统后台界面
    @RequestMapping("/Admin")
    @Modifying
    public String admin(HttpServletRequest request,Model model){
        HttpSession httpSession = request.getSession();
        user user = (com.example.demo.Entity.user) httpSession.getAttribute("user");
        model.addAttribute("nameSesson",user);
        return "index";
    }

    //答题界面
    @RequestMapping("/ques_form")
    public String ques_form(HttpServletRequest request,Model model){
        List<arithreic> ArithList = arithRepository.findAll();
        HttpSession httpSession = request.getSession();
        user user = (com.example.demo.Entity.user) httpSession.getAttribute("user");
        System.out.print(user.getUsername());
        model.addAttribute("nameSesson",user);
        model.addAttribute("arithList",ArithList);
        return "ques_form";
    }
    //成绩展示界面
    @RequestMapping("/score_chart")
    public String score_chart(HttpServletRequest request,Model model){
        HttpSession httpSession = request.getSession();
        user user = (com.example.demo.Entity.user) httpSession.getAttribute("user");
        score  score = new score();
        model.addAttribute("nameSesson",user);
        return "score_chart";
    }

    //成绩查找
    @RequestMapping(value="/getScore",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, int[]> getScore(@RequestParam(value = "userpassword") String pwd, HttpServletRequest request, Model model){

        List<String> scoreList = ScoreRepository.findBypassword(pwd);

        Map<String, int[]> result=new HashMap<>();
        int[] score=new int[]{50,40,60,80};

        result.put("score",score);
        return result;
    }

    //添加成绩
    @RequestMapping(value="/addScore")
    public String addScore(@RequestParam(value = "score") String score,@RequestParam(value = "userpassword") String pwd,HttpServletRequest request){
        score scores = new score();
        scores.setScore(score);
        scores.setUserpassword(pwd);
        ScoreRepository.save(scores);
        return "ques_form";
    }

}
