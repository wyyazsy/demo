package dflibrary.demo.controller;

import dflibrary.demo.dao.BookMapper;
import dflibrary.demo.dao.ManagerMapper;
import dflibrary.demo.dao.UserMapper;
import dflibrary.demo.dao.UserbookMapper;
import dflibrary.demo.pojo.Book;
import dflibrary.demo.pojo.Manager;
import dflibrary.demo.pojo.Userbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;



@Controller

public class mana {
    //BOOK分页条件
    private int i=0;

    @Autowired
    BookMapper bookMapper;
    @Autowired
    ManagerMapper managerMapper;
    @Autowired
    UserbookMapper userbookMapper;
    @Autowired
    UserMapper userMapper;
    @Transactional
    @RequestMapping("library.com")
    public String  getLogin(){
        return "login";
    }
    @RequestMapping("page")
    public String  getLogin1(){
        return "pagehelper";
    }
    @RequestMapping("login")
    public String login(String u, String p, Model model){
         Manager manager =managerMapper.selectByUsername(u);
        if(manager==null||!manager.getPassword().equals(p)){
            model.addAttribute("loginerror","账号或密码不正确");
            return "login";
        }
        return "main";
    }

    @RequestMapping("selectAll")
    public String selectAll(Model model,@RequestParam(name = "s", value = "s", required = false) String s,Integer h){
        if(!(h==null)){
            i=h;
        }

        List<Book> list =bookMapper.selectAll();
        if(s.equals("hhh")){
            i++;
            int a=(list.size()-1)/2;
            if(i>a){
                i=a;
            }
        }
        if(s.equals("qqq")){
            i--;
            if(i<0){
                i=0;
            }
        }
        model.addAttribute("mylist", list.subList(i*2,i*2+2));
        return "shuju";
    }
    @RequestMapping("selectByName")
    public String selectByName(Model model,String name){

        Book book=bookMapper.selectByName(name);
        if(book==null){
            model.addAttribute("error","查询图书不存在");
            return "test";
        }else{
            model.addAttribute("mylist",book);
            return "book";
        }
    }

    @RequestMapping("selectTest")
    public String selectTest(){
        return "test";
    }


    @RequestMapping("jieshu")
    public String jieShu(){
        return "jieshu";
    }
    @RequestMapping("userbookadd")

    public String adduserbook(Model model,String studentid,String name){
        Book book=bookMapper.selectByName(name);
        if(userMapper.selectByStudentId(studentid)==null||book==null){
            model.addAttribute("error","学生证号错误或查询图书不存在");
            return "jieshu";
        }else {
            Userbook userbook=new Userbook();
            userbook.setStudentid(studentid);
            userbook.setBookname(name);
            userbookMapper.insertOne(userbook);
           book.setBooknumber(book.getBooknumber()-1);
            bookMapper.updateBookByNumber(book);
            return "success";
        }
        }


        @RequestMapping("huanshu")
        public String huanShu(){
            return "huanshu";
        }
        @RequestMapping("userbookdesc")
        public String userbookdesc(Model model,String studentid,String name){
            Book book=bookMapper.selectByName(name);
            if(userMapper.selectByStudentId(studentid)==null||book==null){
                model.addAttribute("error","学生证号错误或查询图书不存在");
                return "huanshu";
            }else {
                userbookMapper.delete(studentid,name);
                book.setBooknumber(book.getBooknumber()+1);
                bookMapper.updateBookByNumber(book);


                return "success";
            }
        }

        @RequestMapping("userbookall")
    public String userbookall(Model model,@RequestParam(name = "s", value = "s", required = false) String s){
        List<Userbook> list=userbookMapper.selectUserbooks();
        if(list==null){
                model.addAttribute("error", "暂未有人借书");
                return "userbookzs";
            }else{
            model.addAttribute("mylist",list);
            return "userbookzs";
        }
    }

}





















