package com.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by 吴波 on 2017/10/1.
 */

@SpringBootApplication
@MapperScan("com.demo.mapping")
public class App {

    public static void  main(String args[]) throws Exception{
         SpringApplication.run(App.class,args);
    }

}
