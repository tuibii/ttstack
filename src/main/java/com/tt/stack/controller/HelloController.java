package com.tt.stack.controller;

import com.tt.stack.dao.LogBlogDao;
import com.tt.stack.entity.LogBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HelloController {

    @Autowired
    LogBlogDao logBlogDao;

    @RequestMapping("/about")
    public String toAbout(){
        return "about";
    }

//    @ResponseBody
//    @RequestMapping("/log")
//    public List<LogBlog> testLogBlog(){
//        return logBlogDao.getAllLogBlog();
//    }

}
