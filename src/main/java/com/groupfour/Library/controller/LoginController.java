package com.groupfour.Library.controller;


import com.groupfour.Library.Utils.Check;
import com.groupfour.Library.Utils.Code;
import com.groupfour.Library.Utils.Result;
import com.groupfour.Library.pojo.Users;
import com.groupfour.Library.pojo.utiils.User;
import com.groupfour.Library.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;



//登录注销功能模块
@RestController
@CrossOrigin
public class LoginController {
    @Autowired
    private UsersService usersService;



    //登录请求处理
    @RequestMapping("/login")
    public Result login(User user,
                        HttpServletRequest request) {
        Check.CheckUser(user);
        Users users = usersService.login(user, request)?usersService.getById(user.getUserId()):null;
        String msg = users!=null?"登录成功":"登录失败,账号或密码错误";
        return new Result(users!=null?Code.FIND_OK:Code.FIND_ERR,users,msg);
    }


    //账户注销功能
    @RequestMapping("/logout")
    public Result logout(HttpServletRequest request){

        Boolean flag = usersService.logout(request);

        String msg = flag ? "注销成功":"注销失败";

        return new Result(flag?Code.DELETE_OK:Code.DELETE_ERR,flag,msg);
    }


}
