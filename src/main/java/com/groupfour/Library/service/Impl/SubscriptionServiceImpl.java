package com.groupfour.Library.service.Impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.groupfour.Library.dao.SubscriptionMapper;
import com.groupfour.Library.pojo.Books;
import com.groupfour.Library.pojo.Subscription;
import com.groupfour.Library.pojo.Users;
import com.groupfour.Library.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service
public class SubscriptionServiceImpl extends ServiceImpl<SubscriptionMapper,Subscription> implements SubscriptionService {

    @Autowired
    private SubscriptionMapper mapper;

    //向订阅信息表中添加信息
    @Override
    public Boolean insertSubscrption(Books book, Users user){
        Map<String,Object> map=new HashMap<>();
        map.put("bookId",book.getBookId());
        map.put("bookName",book.getBookName());
        map.put("userId",user.getUserId());
        map.put("userName",user.getUserName());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //格式化当前时间
        Date date = new Date(System.currentTimeMillis());
        map.put("addtime",sdf.format(date));

        return mapper.insertSubscription(map);
    }


    //分页查询订阅信息表
    @Override
    public Page<Subscription> getPage(Integer key){        //接收参数key
        Page<Subscription> page=new Page<>(key,8);    //封装查询要求       key是第key页，8是每页数据量
        Page<Subscription> page1 = this.page(page);        //使用mybatis-plus的分页功能，调用分页函数，返回查询结果
        return page1;                                      //返回查询结果
    }

}
