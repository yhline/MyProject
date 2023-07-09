package com.groupfour.Library.pojo;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



//书架表实体类
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("bookshelf")
public class Bookshelf {
    @TableId("id")
    private Integer id;
    private Integer bookId;
    private String userId;
    private String bookName;
    private String author;
    private String addtime;
}
