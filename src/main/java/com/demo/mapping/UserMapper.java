package com.demo.mapping;

import com.demo.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by 吴波 on 2017/10/2.
 */
public interface UserMapper {
    @Select("SELECT * FROM user")
    List<User> getAll();

    @Select("select * from user where USER_NAME = #{userName}")
    @Results({
            @Result(property = "userId",  column = "USER_ID"),
            @Result(property = "userName",  column = "USER_NAME"),
            @Result(property = "userPasswd", column = "USER_PASSWD")
    })
    User getUserByName(String userName);

    @Insert("insert into user(USER_NAME,USER_PASSWD,EMAIL,DATE,STATE) values(#{userName},#{userPasswd},#{email},#{date},#{state})")
    int insertUser(User user);
}
