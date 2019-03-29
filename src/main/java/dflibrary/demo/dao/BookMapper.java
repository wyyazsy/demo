package dflibrary.demo.dao;

import dflibrary.demo.pojo.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;




public interface
BookMapper {
//    @Results({
//            @Result(property = "bookid",column ="bookid" ),
//            @Result(property = "bookname",column="bookname"),
//            @Result(property = "bookaddress",column="bookaddress"),
//            @Result(property = "booknumber",column="booknamenumber"),
//            @Result(property = "bookauthor",column="bookauthor"),
//
//    })
    @Select("select*from book")
    public List<Book> selectAll();
    @Select("select*from book where bookname=#{bookname}")
    public Book selectByName(String name);
    @Select("select*from book where bookauthor=#{bookauthor}")
    public List<Book> selectByAuthor(String author);
    @Insert("insert into book(bookname,booknumber,bookaddress,bookauthor)values(#{bookname},#{booknumber},#{bookaddress},#{bookauthor})")
    public void insertBook(Book book);

    @Delete("delete from book where bookid=#{id}")
    public void deleteBookById(Integer id);

    @Delete("delete from book where bookname=#{name}")
    public void deleteBookByName(String name);

    @Update("update book set booknumber=#{booknumber} where bookid=#{bookid}")
    public void updateBookByNumber(Book book);




}
