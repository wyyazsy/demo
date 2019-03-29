package dflibrary.demo.dao;

import dflibrary.demo.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


public interface UserMapper {
    @Insert("insert into user(name,gender,idnumber,studentid,age)values(#{name},#{gender},#{idnumber},#{studentid},#{age})")
    public void insertUser(User user);

    @Select("select * from user where studentid=#{studentid}")
    public User selectByStudentId(String studentid);


}
