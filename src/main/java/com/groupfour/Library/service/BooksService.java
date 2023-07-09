package com.groupfour.Library.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.groupfour.Library.pojo.Books;
import java.util.Map;



public interface BooksService extends IService<Books> {
    //图书信息显示
    public Page<Books> getBooksPage(Integer key, String bookName);
    public Boolean saveBooks(Map<String,Object> map);
}
