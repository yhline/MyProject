package com.groupfour.Library.controller;


import com.groupfour.Library.Utils.Check;
import com.groupfour.Library.Utils.Code;
import com.groupfour.Library.Utils.Result;
import com.groupfour.Library.pojo.utiils.RegistUser;
import com.groupfour.Library.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



//注册功能模块
@RestController      //标志此类为控制类，且方法返回json对象
@CrossOrigin
public class RegistController {
    @Autowired
    private UsersService usersService;



    //注册请求处理
    @RequestMapping("/regist")
    public Result regist(RegistUser user){  //将前端数据封装成一个实体类接收
        Boolean flag = usersService.regist(user);     //将实体对象作为参数传递给该方法，接收保存结果
        String msg = flag?"注册成功":"注册失败";         //通过结果保存错误信息
        return new Result(flag? Code.SAVE_OK:Code.SAVE_ERR,flag,msg);   //将错误信息和返回结果封装成Result类并返回给前端

    }
}
