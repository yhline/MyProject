package com.groupfour.Library.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.groupfour.Library.pojo.Subscription;
import org.apache.ibatis.annotations.Mapper;
import java.util.Map;



@Mapper
public interface SubscriptionMapper extends BaseMapper<Subscription> {
    public Boolean insertSubscription(Map<String,Object> map);

}
