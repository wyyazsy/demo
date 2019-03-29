package dflibrary.demo.pojo;

import org.apache.ibatis.type.Alias;

@Alias("book")
public class Book {
    private Integer bookid;

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBookaddress() {
        return bookaddress;
    }

    public void setBookaddress(String bookaddress) {
        this.bookaddress = bookaddress;
    }

    public Integer getBooknumber() {
        return booknumber;
    }

    public void setBooknumber(Integer booknumber) {
        this.booknumber = booknumber;
    }

    public String getBookauthor() {
        return bookauthor;
    }

    public void setBookauthor(String bookauthor) {
        this.bookauthor = bookauthor;
    }

    private String bookname;
    private String bookaddress;
    private Integer booknumber;
    private String bookauthor;

    @Override
    public String toString() {
        return "Book{" +
                "bookid=" + bookid +
                ", bookname='" + bookname + '\'' +
                ", bookaddress='" + bookaddress + '\'' +
                ", booknumber=" + booknumber +
                ", bookauthor='" + bookauthor + '\'' +
                '}';
    }
}
