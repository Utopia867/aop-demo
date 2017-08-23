package com.example.demo.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Utopia on 2017/8/22.
 */
@ApiModel(description="统一返回对象")
public class AjaxResp {

    /* 成功 */
    public static final int SUCCESS = 1;

    /* 失败 */
    public static final int FAILURE = 0;

    /* 用户待审核或暂停 */
    public static final int FAILURE_ACCOUNT_SUSPEND = 403;
    /* 用户密码不正确 */
    public static final int FAILURE_ACCOUNT_AUTHENTICATION = 403;
    /* 参数非法 */
    public static final int FAILURE_PARAM_ILLEGALITY = 0;
    /* 多用户操作错误 */
    public static final int FAILURE_SYNCHRONIZED = 0;


    /* 服务器错误 */
    public static final int ERROR_SERVER_500 = 500;

    @ApiModelProperty(value = "返回状态码")
    public int code;
    @ApiModelProperty(value = "返回信息")
    public String msg = "";
    @ApiModelProperty(value = "返回实际数据")
    public Object data;

    public AjaxResp() {
    }

    public AjaxResp(int code, String msg, Object data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public AjaxResp(int code, Object data) {
        super();
        this.code = code;
        this.data = data;
    }

    public AjaxResp(int code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = null;
    }

    public AjaxResp(int code) {
        super();
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


}
