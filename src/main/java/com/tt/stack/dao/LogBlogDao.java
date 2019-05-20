package com.tt.stack.dao;

import com.tt.stack.entity.LogBlog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface LogBlogDao {

    @Select("select * from logblog")
    public List<LogBlog> getAllLogBlog();

}
