package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Entity.user;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.example.demo.domain.userRepository;



@Controller
public class LoginController {

    @Autowired
    private userRepository userRepository;

    @RequestMapping (value="/Login")
    public String Login(){
        return "login";
    }

    @RequestMapping(value = "/addLogin", method = RequestMethod.POST)
    public String addLogin(@RequestParam(value = "name") String username, @RequestParam (value = "pwd") String password,
                           HttpServletRequest request){
        System.out.println(username);
        System.out.println(password);
        HttpSession session = request.getSession();
        user  userd = null;
            if(userRepository.findBypassword(password).size() == 0){
                 userd = new user();
                userd.setUsername(username);
                userd.setUserpassword(password);
                userRepository.save(userd);
        } else {
            userd = userRepository.findBypassword(password).get(0);
        }
        session.setAttribute("user",userd);
        return "index";
    }

}
