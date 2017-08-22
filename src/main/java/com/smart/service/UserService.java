package com.smart.service;

import com.smart.dao.LoginLogDao;
import com.smart.dao.UserDao;
import com.smart.domain.LoginLog;
import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private UserDao userDao;
    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    private LoginLogDao loginLogDao;

    @Autowired
    public void setLoginLogDao(LoginLogDao loginLogDao){
        this.loginLogDao = loginLogDao;
    }
    public User getMatchUser(String userName,String password){
        List<Map> res = userDao.getMatchList(userName,password);
        if(res == null){
            return null;
        }else {
            User user = new User();
            user.setUserId(Integer.parseInt(res.get(0).get("user_id").toString()));
            user.setUserName(res.get(0).get("user_name").toString());
            user.setCredits(Integer.parseInt(res.get(0).get("credits").toString()));
            return null;
        }
    }

    @Transactional
    public void loginSuccess(User user){
        user.setCredits(5 + user.getCredits());
        LoginLog loginLog = new LoginLog();
        loginLog.setUserId(user.getUserId());
        loginLog.setIp(user.getLastIp());
        loginLog.setLoignDate(user.getLastVisit());
        userDao.updateLoginInfo(user);
        loginLogDao.insertLoginLog(loginLog);
    }

}
