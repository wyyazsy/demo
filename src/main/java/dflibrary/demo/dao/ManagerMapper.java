package dflibrary.demo.dao;

import dflibrary.demo.pojo.Manager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


public interface ManagerMapper {
    @Select("select * from manager where username=#{username}")
    public Manager selectByUsername(String username);

}
