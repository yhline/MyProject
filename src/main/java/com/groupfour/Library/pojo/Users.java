package com.groupfour.Library.pojo;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



//用户实体类
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    @TableId("userId")
    private String userId;
    private String psWord;
    private String userName;
    private String gender;
    private String email;
    private String phone;
    private int ismaind=0;

    public Users(String userId, String psWord, String userName, String gender, String email, String phone) {
        this.userId = userId;
        this.psWord = psWord;
        this.userName = userName;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
    }

    public Boolean isEmpty(){
        return  "".equals(userId) ||
                "".equals(psWord) ||
                "".equals(userName) ||
                "".equals(gender) ||
                "".equals(email) ||
                "".equals(phone);
    }
}
