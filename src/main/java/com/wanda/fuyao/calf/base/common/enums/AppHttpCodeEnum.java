package com.wanda.fuyao.calf.base.common.enums;

import com.sun.org.apache.bcel.internal.generic.RETURN;

/**
 * @PackName: com.wanda.fuyao.calf.base.common.enums
 * @ClassName: AppHttpCodeEnum
 * @Description: ${TODO}
 * @User: Lion
 * @Date: 2022/03/17  16:50
 */
public enum AppHttpCodeEnum {
    SUCCESS(200,"操作成功"),
    NEED_LOGIN(401,"需要登录后操作"),
    NO_OPERATOR_AUTH(403,"无操作权限"),
    SYSTEM_ERROR(403,"系统错误");


    int code;
    String msg;

    AppHttpCodeEnum(int code, String errorMessage) {
        this.code = code;
        this.msg = errorMessage;
    }

    public int getCode(){
        return code;
    }

    public String getMsg(){
        return msg;
    }
}
