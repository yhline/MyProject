package com.groupfour.Library.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.groupfour.Library.Utils.Code;
import com.groupfour.Library.Utils.Result;
import com.groupfour.Library.pojo.Books;
import com.groupfour.Library.pojo.Bookshelf;
import com.groupfour.Library.pojo.Users;
import com.groupfour.Library.service.BooksService;
import com.groupfour.Library.service.BookshelfService;
import com.groupfour.Library.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;



//用户书架模块（组长：董波）
@RestController
@CrossOrigin
@RequestMapping("bookshelf")
public class BookshelfController {
    @Autowired
    private BooksService booksService;

    @Autowired
    private BookshelfService bookshelfService;

    @Autowired
    private SubscriptionService subscriptionService;


    //向书架中添加书 同时向订阅信息表中插入一条数据
    @RequestMapping("/insert")
    public Result insertBookshelf(@RequestParam("id") String id, HttpServletRequest request){
        Books book = booksService.getById(id);
        Users users = (Users) request.getServletContext().getAttribute("user");

        Boolean flag = bookshelfService.insertBookshels(book, users);
        if(flag){
            subscriptionService.insertSubscrption(book, users);
            return new Result(Code.SAVE_OK,true,"添加成功");
        }else{
            return new Result(Code.SAVE_ERR,false,"图书未能成功加入书架,书架中可能已经存在同样的书");
        }
    }


    //将目标书移除书架
    @RequestMapping("/delete")
    public Result deleteBookshelf(@RequestParam("id")Integer id,
                                  HttpServletRequest request){
        Boolean flag = bookshelfService.deleteBook(id,request);
        String msg = flag?"移除成功":"移除失败";
        return new Result(flag?Code.DELETE_OK:Code.DELETE_ERR,flag,msg);
    }


    //查询书架中所有的图书
    @RequestMapping("/page")
    public Result selectAll(@RequestParam(defaultValue = "1",required = false) Integer key,
                                         HttpServletRequest request){
        Page<Bookshelf> page= bookshelfService.getPage(key,request);
        Boolean flag = page.getPages()==0;
        String msg = flag?"书架为空":null;
        return new Result(flag?Code.FIND_ERR:Code.FIND_OK,page.getRecords(),msg,page.getPages());
    }

}
