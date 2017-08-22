package com.smart.dao;

import com.smart.domain.User;
import org.omg.PortableInterceptor.ServerRequestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class UserDao {
    private JdbcTemplate jdbcTemplate;
    private final  static String UPDATE_LOGIN_INFO_SQL = " update t_user set "+
            " last_visit=?,last_ip=?,credits=? where user_id=? ";

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public List getMatchList(String userName, String password){
        String sqlStr =" SELECT * from t_user where user_name =? and password = ? ";
        return jdbcTemplate.queryForList(sqlStr,new Object[] { userName,password });
    }



    public int updateLoginInfo(User user){
        return jdbcTemplate.update(UPDATE_LOGIN_INFO_SQL,new Object[]{ user.getLastVisit(),
                user.getLastIp(),user.getCredits(),user.getUserId()});
    }

}
