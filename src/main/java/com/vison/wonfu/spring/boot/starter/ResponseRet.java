package com.vison.wonfu.spring.boot.starter;

/**
 *
 * @author caowenpeng
 */
public class ResponseRet {

    public static Integer Success = 0;

    /**
     * 参数错误
     */
    public static Integer parametrErrror = 510;
    /**
     * 未登录
     */
    public static Integer unLogin = 401;

    /**
     * 登录失败
     */
    public static Integer loginFail = 511;
}
