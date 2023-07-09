package com.groupfour.Library.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.groupfour.Library.Utils.Code;
import com.groupfour.Library.Utils.Result;
import com.groupfour.Library.pojo.Books;
import com.groupfour.Library.service.BooksService;
import com.groupfour.Library.service.BookshelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;



//图书管理模块
@CrossOrigin
@RequestMapping("/books")
@RestController
public class BooksController {
    //自动注入图书服务类
    @Autowired
    private BooksService booksService;

    //自动注入书架服务类
    @Autowired
    private BookshelfService bookshelfService;



    //图书信息分页条件查询接口
    @RequestMapping("/page")
    public Result getBooksPage(@RequestParam(required = false,defaultValue = "1") Integer key,
                               @RequestParam(required = false,defaultValue = "") String bookName) {
        Page<Books> page = booksService.getBooksPage(key, bookName);
        String msg=page.getPages()!=0?null:"查询失败";
        Long Maxpage = (msg==null?page.getPages():null);

        return new Result(page.getPages()==0?Code.FIND_ERR:Code.FIND_OK,page.getRecords(),msg,Maxpage);
    }


    //添加新书接口
    @RequestMapping("/insert")
    public Result insertBook(@RequestParam Map<String,Object> map){
        Boolean flag = booksService.saveBooks(map);
        String msg = flag?"添加成功":"添加失败";
        return new Result(flag?Code.UPDATE_OK:Code.UPDATE_ERR,flag,msg);
    }


    //删除目标图书
    @RequestMapping("/delete")
    public Result deleteBook(@RequestParam("bookId") String bookId){
        if(bookshelfService.getById(bookId)!=null){
            return new Result(Code.DELETE_ERR,false,"删除失败，还有用户未归此本书");
        }
        Boolean flag = booksService.removeById(bookId);
        String msg = flag?"删除成功":"删除失败";
        return new Result(flag?Code.DELETE_OK:Code.DELETE_ERR,flag,msg);
    }


    //修改图书信息
    @RequestMapping("/update")
    public Result updateBook(Books book){
        Boolean flag = booksService.updateById(book);
        String msg = flag?"修改修改":"修改失败";
        return new Result(flag?Code.UPDATE_OK:Code.UPDATE_ERR,flag,msg);
    }
}
