package com.groupfour.Library.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.groupfour.Library.pojo.Books;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;



@Mapper
public interface BooksMapper extends BaseMapper<Books> {
    public Boolean insertBooks(Map<String, Object> books);
}
