package com.groupfour.Library.Utils;

public class Code {
    /**
     *增删改查
     *成功 1
     *失败 0
     *增删改无论成功还是失败，都会返回(状态码，提示信息)
     *查询成功：(状态码，数据，提示信息)
     *查询失败：(状态码，null，提示信息)
     */

    /**
     * 1表示成功
     * 11表示新增成功、21表示删除成功、31表示修改成功、41表示查询成功
     * 200表示网络资源正常访问
     */
    public static final Integer SAVE_OK=20011;
    public static final Integer DELETE_OK=20021;
    public static final Integer UPDATE_OK=20031;
    public static final Integer FIND_OK=20041;

    /**
     * 0表示失败
     * 10表示新增失败、20表示删除失败、30表示修改失败、40表示查询失败
     * 200表示网络资源正常访问
     */
    public static final Integer SAVE_ERR=20010;
    public static final Integer DELETE_ERR=20020;
    public static final Integer UPDATE_ERR=20030;
    public static final Integer FIND_ERR=20040;


    //自定义异常编码
    public static final Integer SYSTEM_ERR = 50001;
    public static final Integer SYSTEM_TIMEOUT_ERR = 50002;
    public static final Integer SYSTEM_UNKNOW_ERR = 59999;
    public static final Integer BUSINESS_ERR = 60002;
}