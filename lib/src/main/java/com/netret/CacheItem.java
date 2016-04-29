package com.netret;

import java.io.Serializable;

/**
 * 类描述：
 * 项目名称：NetRet
 * 创建人：andy
 * 创建时间：2016/4/29 15:27
 * 修改备注：
 */
public class CacheItem implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 存储的key */
    private final String key;

    /** JSON字符串 */
    private String data;

    /** 过期时间的时间戳 */
    private long timeStamp = 0L;

    public CacheItem(final String key, final String data, final long expiredTime) {
        this.key = key;
        this.timeStamp = System.currentTimeMillis() + expiredTime * 1000;
        this.data = data;
    }

    public String getKey() {
        return key;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public String getData() {
        return data;
    }
}
