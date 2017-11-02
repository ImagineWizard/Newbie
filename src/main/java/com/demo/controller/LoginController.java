package com.demo.controller;

import com.demo.Service.UserService;
import com.demo.domain.User;
import com.demo.mapping.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by 吴波 on 2017/10/1.
 */
@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{userName}/existed",method = RequestMethod.GET)
    public boolean isUserExisted(@PathVariable("userName")String userName){
        return userService.isUserExisted(userName);
    }

    @RequestMapping(value = "/{username}/confirm",method = RequestMethod.GET)
    public boolean isPasswdRight(@PathVariable("username")String userName,@RequestParam("password")String password){
        return userService.isPasswdRight(userName,password);
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public boolean createUser(@RequestParam("userName") String userName,@RequestParam("userPasswd")String userPasswd,@RequestParam("email")String email){
        return userService.createUser(userName,userPasswd,email);
    }

}
