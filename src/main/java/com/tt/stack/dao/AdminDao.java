package com.tt.stack.dao;

import com.tt.stack.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AdminDao {

    @Select("select * from manager where account = #{account}")
    public Admin getAdminByAccount(String account);
}
