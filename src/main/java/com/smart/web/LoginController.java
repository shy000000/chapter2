package com.smart.web;

import com.smart.domain.User;
import com.smart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index.html")
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value = "/loginCheck.html")
    public ModelAndView loginCheck(HttpServletRequest request,LoginCommand loginCommand){
        User loginUser = userService.getMatchUser(loginCommand.getUserName(),loginCommand.getPassword());
        if(loginUser == null){
            return new ModelAndView("login","error","用户名或密码错误");
        }else {
            loginUser.setLastVisit(new Date());
            loginUser.setLastIp(request.getLocalAddr());
            userService.loginSuccess(loginUser);
            request.getSession().setAttribute("user",loginUser);
            return new ModelAndView("main");
        }
    }
}
