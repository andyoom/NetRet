package com.netret;

/**
 * 类描述：
 * 项目名称：NetRet
 * 创建人：andy
 * 创建时间：2016/4/29 14:55
 * 修改备注：
 */
public interface Callback<T> {
    public void onSuccess(T result);

    public void onFail(String msg);

    public void onCookieExpired();
}
