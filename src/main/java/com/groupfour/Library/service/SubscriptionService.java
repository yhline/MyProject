package com.groupfour.Library.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.groupfour.Library.pojo.Books;
import com.groupfour.Library.pojo.Subscription;
import com.groupfour.Library.pojo.Users;


public interface SubscriptionService extends IService<Subscription> {
    public Boolean insertSubscrption(Books book, Users user);

    public Page<Subscription> getPage(Integer key);

}
