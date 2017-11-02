package com.demo.Service;

import com.demo.domain.User;
import com.demo.mapping.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by 吴波 on 2017/10/2.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public boolean isUserExisted(String userName){
        User user = userMapper.getUserByName(userName);
        if(user!=null){
            if(user.getState().equals("E")){
                return true;
            }
        }
        return false;
    }

    public boolean isPasswdRight(String userName,String password){
        User user = userMapper.getUserByName(userName);
        if(user.getUserPasswd().equals(password)){
            return true;
        }
        return false;
    }

    public boolean createUser(String userName,String userPasswd,String email){
        User user = new User();
        user.setUserName(userName);
        user.setUserPasswd(userPasswd);
        user.setEmail(email);
        user.setDate(new Date());
        user.setState("E");
        int i = userMapper.insertUser(user);
        return i == 1;
    }
}
