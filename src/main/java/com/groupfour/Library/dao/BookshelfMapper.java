package com.groupfour.Library.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.groupfour.Library.pojo.Bookshelf;
import org.apache.ibatis.annotations.Mapper;
import java.util.Map;



@Mapper
public interface BookshelfMapper extends BaseMapper<Bookshelf> {
    public Boolean insertBookshelf(Map<String,Object> map);
}
