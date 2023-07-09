package com.groupfour.Library.pojo;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



//图书信息实体类
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books {
    @TableId("bookId")
    private Integer bookId;
    private String bookName;
    private String author;
    private String publish;
    private String category;
    private Double price;
    private String deadline;
}
