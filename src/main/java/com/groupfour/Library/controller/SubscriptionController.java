package com.groupfour.Library.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.groupfour.Library.Utils.Code;
import com.groupfour.Library.Utils.Result;
import com.groupfour.Library.pojo.Subscription;
import com.groupfour.Library.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



//订阅信息管理模块
@RestController                                //方法返回Json数据
@RequestMapping("/subscription")            //类访问地址
@CrossOrigin                                   //前后端端口号不同，解决跨域问题
public class SubscriptionController {
    @Autowired
    private SubscriptionService subscriptionService;



    //查询所有订阅记录
    @RequestMapping("/select")
    public Result getPage(@RequestParam(defaultValue = "1",required = false) Integer key){  //接收前端参数key，默认为1
        Page<Subscription> page = subscriptionService.getPage(key);         //调用getPage方法，传第key参数，返回查询结果
        String msg=((page.getPages()!=0)?null:"查询失败");                    //判断查询结果，是否查询到数据
        Long Maxpage = (msg==null?page.getPages():null);                     //获取查询结果的最大页数
        return new Result(page.getPages()==0?Code.FIND_ERR:Code.FIND_OK,page.getRecords(),msg,Maxpage);  //将结果封装为Result类返回给前端
    }



    //删除一条订阅记录
    @RequestMapping("/delete")
    public Result delete(@RequestParam("id") Integer id){          //接收前端传输的书的id
        Boolean flag = subscriptionService.removeById(id);         //通过id删除书，返回删除结果
        String msg = flag?"删除成功":"删除失败";                      //返回错误信息
        return new Result(flag?Code.DELETE_OK:Code.DELETE_ERR,flag,msg);   //封装结果，返回给前端
    }




}
