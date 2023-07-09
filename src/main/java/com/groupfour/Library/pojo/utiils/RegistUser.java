package com.groupfour.Library.pojo.utiils;

import com.alibaba.druid.support.ibatis.SpringIbatisBeanNameAutoProxyCreator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistUser {
    private String userId;
    private String psWord;
    private String ispsWord;
    private String userName;
    private String gender;
    private String email;
    private String phone;

    public Boolean isEmpty(){         //判断前端参数是否有空值
        return  "".equals(userId) ||
                "".equals(psWord) ||
                "".equals(ispsWord) ||
                "".equals(userName) ||
                "".equals(gender) ||
                "".equals(email) ||
                "".equals(phone);
    }
}
