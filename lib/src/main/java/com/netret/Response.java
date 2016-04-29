package com.netret;

/**
 * 类描述：Response实体类
 * 项目名称：NetRet
 * 创建人：andy
 * 创建时间：2016/4/29 14:11
 * 修改备注：
 */
public class Response<T> {
    private boolean isError;//是否出错
    private int errorType;//错误类型
    private String msg; //请求返回信息
    private T result;   //请求返回JSON数据

    public boolean hasError() {
        return isError;
    }

    public void setError(boolean error) {
        isError = error;
    }

    public int getErrorType() {
        return errorType;
    }

    public void setErrorType(int errorType) {
        this.errorType = errorType;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
