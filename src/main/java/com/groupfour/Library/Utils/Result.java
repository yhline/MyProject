package com.groupfour.Library.Utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    /**
     * 描述统一格式中的状态编码： “0” 错误 “1” 正确
     */
    private Integer code;

    /**
     * 描述统一格式中的数据： 保存向前端传递的数据
     */
    private Object data;

    /**
     * 描述统一格式中的消息： 错误信息
     */
    private String msg;

    /**
     * 分页查询最大页数记录
     */
    private Long Maxpage;

    /**
     * 无错误信息构造函数
     */
    public Result(Integer code,Object data) {
        this.code=code;
        this.data=data;
    }

    public Result(Integer code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

}
