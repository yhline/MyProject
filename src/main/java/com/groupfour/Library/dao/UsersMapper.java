package com.groupfour.Library.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.groupfour.Library.pojo.Users;
import com.groupfour.Library.pojo.utiils.User;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface UsersMapper extends BaseMapper<Users> {
    Users getUsersByIdAndPs(User user);
}
