package com.groupfour.Library.service.Impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.groupfour.Library.dao.BooksMapper;
import com.groupfour.Library.pojo.Books;
import com.groupfour.Library.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;



@Service
public class BookServiceIpml extends ServiceImpl<BooksMapper, Books> implements BooksService {
    @Autowired
    private BooksMapper mapper;


    //分页查询图书信息
    @Override
    public Page<Books> getBooksPage(Integer key, String bookName){
        Page<Books> page=new Page<>(key,8);
        if(bookName!=null){
            QueryWrapper<Books> query = new QueryWrapper<>();
            query.like("bookName","%"+bookName+"%");
            return this.page(page,query);
        }else{
            return this.page(page);
        }
    }


    //保存新的图书
    @Override
    public Boolean saveBooks(Map<String,Object> map){
        return mapper.insertBooks(map);
    }

}
