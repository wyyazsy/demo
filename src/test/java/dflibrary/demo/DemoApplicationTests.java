package dflibrary.demo;

import com.github.pagehelper.PageHelper;
import dflibrary.demo.dao.BookMapper;
import dflibrary.demo.dao.UserMapper;
import dflibrary.demo.dao.UserbookMapper;
import dflibrary.demo.pojo.Book;
import dflibrary.demo.pojo.User;
import dflibrary.demo.pojo.Userbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    BookMapper bookMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserbookMapper userbookMapper;
    @Autowired




@Test
    public  void aaa(){
    PageHelper.startPage(0,8);
         List<Book> list =bookMapper.selectAll();

    }
}
