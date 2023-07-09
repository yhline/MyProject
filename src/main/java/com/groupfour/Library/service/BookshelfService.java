package com.groupfour.Library.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.groupfour.Library.pojo.Books;
import com.groupfour.Library.pojo.Bookshelf;
import com.groupfour.Library.pojo.Users;

import javax.servlet.http.HttpServletRequest;


public interface BookshelfService extends IService<Bookshelf> {

    //调用方法向bookshelf数据库中添加新书
    public Boolean insertBookshels(Books book, Users user);

    //将目标书移除用户书架
    public Boolean deleteBook(Integer id, HttpServletRequest request);

    //查询书架中用户订阅的所有图书
    public Page<Bookshelf> getPage(Integer key,HttpServletRequest request);
}
