package com.groupfour.Library.pojo;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



//订阅信息表实体类
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("subscription")
public class Subscription {
    @TableId("id")
    private Integer id;
    private Integer bookId;
    private String userId;
    private String userName;
    private String bookName;
    private String subtime;

}
