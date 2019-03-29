package dflibrary.demo.dao;

import dflibrary.demo.pojo.Userbook;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserbookMapper {
    @Select("select * from userbook")
    public List<Userbook> selectUserbooks();

    @Select("select * from userbook where studentid=#{id}")
    public List<Userbook> selectById(String id);

    @Insert("insert into userbook values(#{studentid},#{bookname})")
    public void insertOne(Userbook userbook);

    @Delete("delete from userbook where studentid=#{studentid} and bookname=#{bookname}")
    public void  delete(String studentid,String bookname);
}
