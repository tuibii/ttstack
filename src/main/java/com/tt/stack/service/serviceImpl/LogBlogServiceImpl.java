package com.tt.stack.service.serviceImpl;

import com.tt.stack.dao.LogBlogDao;
import com.tt.stack.entity.LogBlog;
import com.tt.stack.service.LogBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogBlogServiceImpl implements LogBlogService {

    @Autowired
    LogBlogDao logBlogDao;

    @Override
    public List<LogBlog> getAllLogBlog() {
        return logBlogDao.getAllLogBlog();
    }
}
