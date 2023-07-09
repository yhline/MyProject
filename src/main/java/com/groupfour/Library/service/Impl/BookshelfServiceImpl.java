package com.groupfour.Library.service.Impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.groupfour.Library.Utils.Code;
import com.groupfour.Library.dao.BookshelfMapper;
import com.groupfour.Library.dao.SubscriptionMapper;
import com.groupfour.Library.exception.BusinessException;
import com.groupfour.Library.pojo.Books;
import com.groupfour.Library.pojo.Bookshelf;
import com.groupfour.Library.pojo.Users;
import com.groupfour.Library.service.BookshelfService;
import com.groupfour.Library.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;



@Service
public class BookshelfServiceImpl extends ServiceImpl<BookshelfMapper, Bookshelf> implements BookshelfService {
    @Autowired
    private BookshelfMapper bookshelfMapper;

    @Autowired
    private SubscriptionService subscriptionService;



    //往书架中添加新书，每本书每个人只能借一本
    @Override
    public Boolean insertBookshels(Books book, Users user){
        if(user==null){
            throw new BusinessException(Code.BUSINESS_ERR,"请先登录！");
        }

        QueryWrapper<Bookshelf> qv= new QueryWrapper<>();
        qv.eq("userId", user.getUserId());
        qv.eq("bookId", book.getBookId());

        if(this.getOne(qv)!=null){
            return false;
        }
        Map<String,Object> map=new HashMap<>();
        map.put("bookId",book.getBookId());
        map.put("bookName",book.getBookName());
        map.put("author",book.getAuthor());
        map.put("userId",user.getUserId());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //格式化当前时间
        Date date = new Date(System.currentTimeMillis());
        map.put("addtime",sdf.format(date));

        return bookshelfMapper.insertBookshelf(map);
    }


    //从书架中移除目标书籍
    @Override
    public Boolean deleteBook(Integer id, HttpServletRequest request){
        Users user = (Users) request.getServletContext().getAttribute("user");
        QueryWrapper<Bookshelf> qv = new QueryWrapper<>();
        qv.eq("bookId",id);
        qv.eq("userId",user.getUserId());
        return this.remove(qv);
    }


    //查询书架中用户订阅的所有图书
    @Override
    public Page<Bookshelf> getPage(Integer key,HttpServletRequest request) {
        Page<Bookshelf> page = new Page<>(key,6);
        Users user = (Users) request.getServletContext().getAttribute("user");
        QueryWrapper<Bookshelf> query = new QueryWrapper<>();
        query.eq("userId",user.getUserId());
        return this.page(page,query);
    }
}
