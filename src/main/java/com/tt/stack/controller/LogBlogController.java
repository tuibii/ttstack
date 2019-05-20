package com.tt.stack.controller;

import com.tt.stack.entity.LogBlog;
import com.tt.stack.service.LogBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class LogBlogController {

    @Autowired
    LogBlogService logBlogService;

    @RequestMapping("/log")
    public String toLogBlog(Model model){
        List<LogBlog> logs = logBlogService.getAllLogBlog();
        model.addAttribute("logs",logs);
        return "blog";
    }

}
