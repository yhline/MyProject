package com.groupfour.Library.service.Impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.groupfour.Library.Utils.Check;
import com.groupfour.Library.Utils.Code;
import com.groupfour.Library.Utils.Result;
import com.groupfour.Library.dao.UsersMapper;
import com.groupfour.Library.exception.BusinessException;
import com.groupfour.Library.pojo.Users;
import com.groupfour.Library.pojo.utiils.RegistUser;
import com.groupfour.Library.pojo.utiils.User;
import com.groupfour.Library.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {
    @Autowired
    private UsersMapper usersMapper;


    //用户登录服务
    @Override
    public Boolean login(User user, HttpServletRequest request){
        Users users = usersMapper.getUsersByIdAndPs(user);
        if("".equals(user.getUserId())||"".equals(user.getPsWord())){
            throw new BusinessException(Code.BUSINESS_ERR,"登录失败，用户名或密码不能为空！");
        }
        if(users==null){
            return false;
        }
        request.getServletContext().setAttribute("user",users);
        return true;
    }


    //用户注销服务
    @Override
    public Boolean logout(HttpServletRequest request){
        ServletContext servletContext = request.getServletContext();
        Users user = (Users) servletContext.getAttribute("user");
        if(user == null){
            throw new BusinessException(Code.BUSINESS_ERR,"您并未登录，无法执行注销");
        }
        servletContext.removeAttribute("user");
        if(servletContext.getAttribute("user")==null){
            return true;
        }else{
            return false;
        }
    }


    //用户注册服务
    @Override
    public Boolean regist(RegistUser user){  //对注册信息进行判断
        if(user.isEmpty()){         //判断前端传递的参数是否齐全
            throw new BusinessException(Code.SAVE_ERR,"注册失败，请完整填写注册信息");
        }

        Check.Regist(user);           //字符串校验，对前端参数校验

        if(this.getById(user.getUserId())!=null){    //判断用户ID是否被注册
            throw new BusinessException(Code.SAVE_ERR,"注册失败，该用户已存在");
        }

        if(!user.getPsWord().equals(user.getIspsWord())){   //判断两次密码是否相同
            throw new BusinessException(Code.SAVE_ERR,"注册失败，两次输入的密码不同");
        }

        return this.save(new Users(              //通过注册信息创建新用户，将用户保存并返回保存结果
                user.getUserId(),
                user.getPsWord(),
                user.getUserName(),
                user.getGender(),
                user.getEmail(),
                user.getPhone()
        ));
    }


    //分页按条件查询所有用户服务
    @Override
    public Page<Users> getUsersPage(Integer key,String userId,String conditions){
        Page<Users> page = new Page<>(key, 8);
        QueryWrapper<Users> queryWrapper=new QueryWrapper<>();
        if(userId != null||conditions != null){
            if(userId != null){
                queryWrapper.like("userId","%"+userId+"%");
            }
            if(conditions != null){
                queryWrapper.like("userName","%"+conditions+"%");
            }
            return this.page(page,queryWrapper);
        }else{
            return this.page(page,null);
        }
    }

}
