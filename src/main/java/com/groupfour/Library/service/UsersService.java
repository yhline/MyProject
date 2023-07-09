package com.groupfour.Library.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.groupfour.Library.pojo.Users;
import com.groupfour.Library.pojo.utiils.RegistUser;
import com.groupfour.Library.pojo.utiils.User;
import javax.servlet.http.HttpServletRequest;



public interface UsersService extends IService<Users> {
    //用户登录服务
    public Boolean login(User user,HttpServletRequest request);

    //用户账号注销服务
    public Boolean logout(HttpServletRequest request);

    //用户注册服务
    public Boolean regist(RegistUser user);

    //用户分页查询服务
    public Page<Users> getUsersPage(Integer key, String userId, String conditions);


}
