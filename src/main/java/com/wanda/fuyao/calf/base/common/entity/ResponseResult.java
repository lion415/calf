package com.wanda.fuyao.calf.base.common.entity;

import com.wanda.fuyao.calf.base.common.enums.AppHttpCodeEnum;
import lombok.Data;

/**
 * @PackName: com.wanda.fuyao.calf.base.common.domain
 * @ClassName: ResponseBody
 * @Description: 统一封装响应数据格式
 * @User: Lion
 * @Date: 2022/03/04  09:32
 */
@Data
public class ResponseResult<T> {
    private Integer code;
    private String msg;
    private T data;

    public ResponseResult(){
        this.code = AppHttpCodeEnum.SUCCESS.getCode();
        this.msg = AppHttpCodeEnum.SUCCESS.getMsg();
    }

    public ResponseResult(T data){
        this.code = AppHttpCodeEnum.SUCCESS.getCode();
        this.msg = AppHttpCodeEnum.SUCCESS.getMsg();
        this.data = data;
    }

    public ResponseResult(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }
    //自定义code 和 msg的返回体，包括成功和失败，只是成功不包含数据data
    public static ResponseResult Result(Integer code,String msg){
        return new ResponseResult(code,msg);
    }
    //枚举入参构建的返回体，包括成功和失败，只是成功不包含数据data
    public static ResponseResult enumsResult(AppHttpCodeEnum appHttpCodeEnum){
        return new ResponseResult(appHttpCodeEnum.getCode(),appHttpCodeEnum.getMsg());
    }
    //空参构建成功返回体，默认使用AppHttpCodeEnum.SUCCESS，不包含数据data
    public static ResponseResult okResult(){
        return new ResponseResult();
    }
    //默认使用AppHttpCodeEnum.SUCCESS，包含数据data
    public static ResponseResult okResult(Object data){
        ResponseResult result = new ResponseResult();
        if(data != null){
            result.setData(data);
        }
        return result;
    }
     //枚举入参构建失败的返回体，
    public static ResponseResult errorResult(AppHttpCodeEnum appHttpCodeEnum){
        return new ResponseResult(appHttpCodeEnum.getCode(),appHttpCodeEnum.getMsg());
    }





/*
    public ResponseResult(Integer code,T data){
        this.code = code;
        this.data = data;
    }

    public ResponseResult(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public ResponseResult(Integer code, String msg,T data){
       this.code = code;
       this.msg = msg;
       this.data = data;
    }

    public static ResponseResult errorResult(int code,String msg){
        ResponseResult result = new ResponseResult();
        return result.error(code,msg);
    }

    public static ResponseResult okResult(){
        ResponseResult result = new ResponseResult();
        return result;
    }

    public static ResponseResult okResult(int code,String msg){
        ResponseResult result = new ResponseResult();
        return result.ok(code,msg);
    }

    public static ResponseResult okResult(Object data){
        ResponseResult result = setAppHttpCodeEnum(AppHttpCodeEnum.SUCCESS,AppHttpCodeEnum.SUCCESS.getMsg());
        if(data != null){
            result.setData(data);
        }
        return result;
    }

    public static ResponseResult setAppHttpCodeEnum(AppHttpCodeEnum enums,String msg){
        return okResult(enums.getCode(),msg);
    }

    public ResponseResult<?> error(Integer code,String msg){
        this.code = code;
        this.msg = msg;
        return this;
    }

    public ResponseResult<?> ok(Integer code,T data){
        this.code = code;
        this.data = data;
        return this;
    }

    public ResponseResult<?> ok(Integer code,String msg,T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
        return this;
    }

    public ResponseResult<?> ok(T data){
        this.data = data;
        return this;
    }
*/
    public Integer getCode(){
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public void setCode(Integer code){
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }

}
