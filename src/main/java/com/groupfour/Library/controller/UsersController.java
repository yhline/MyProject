package com.groupfour.Library.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.groupfour.Library.Utils.Check;
import com.groupfour.Library.Utils.Code;
import com.groupfour.Library.Utils.Result;
import com.groupfour.Library.pojo.Users;
import com.groupfour.Library.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



//用户管理模块
@CrossOrigin
@RequestMapping("/users")
@RestController
public class UsersController {
    //自动注入UserService类
    @Autowired
    private UsersService usersService;



    //分页查询请求处理
    @RequestMapping("/page")
    public Result getUsersPage(@RequestParam(defaultValue = "1",required = false) Integer key,
                               @RequestParam(defaultValue = "",required = false) String userId,
                               @RequestParam(defaultValue = "",required = false) String conditions
                               ){
        Page<Users> page =usersService.getUsersPage(key,userId,conditions);
        String msg=page.getPages()!=0?null:"查询失败";
        Long Maxpage = (msg==null?page.getPages():null);
        return new Result(page.getPages()==0?Code.FIND_ERR:Code.FIND_OK,page.getRecords(),msg,Maxpage);
    }


    //删除用户请求处理
    @RequestMapping("/delete")
    public Result deleteUsers(@RequestParam("userId") String userId){
        Boolean flag = usersService.removeById(userId);
        String msg = flag ? "删除成功" : "删除失败";
        return new Result(flag? Code.DELETE_OK:Code.DELETE_ERR,flag,msg);
    }


    //修改用户信息请求处理
    @RequestMapping("/update")
    public Result updateUsers(Users users){
        Boolean flag = usersService.updateById(users);
        String msg = flag ? "修改成功" : "修改失败";
        return new Result(flag?Code.UPDATE_OK:Code.UPDATE_ERR,flag,msg);

    }


    //添加用户请求处理
    @RequestMapping("/insert")
    public Result insert(Users users){

        if(users.isEmpty()){
            return new Result(Code.SAVE_ERR,false,"请填写全部注册信息");
        }

        Check.CheckUsers(users);


        if(usersService.getById(users.getUserId())!=null){
            return new Result(Code.SAVE_ERR,false,"该用户已经存在");
        }
        Boolean flag = usersService.save(users);
        String msg = flag ? "添加用户成功" : "添加用户失败";
        return new Result(flag?Code.SAVE_OK:Code.SAVE_ERR,flag,msg);

    }


}
