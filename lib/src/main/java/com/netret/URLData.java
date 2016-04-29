package com.netret;

/**
 * 类描述：
 * 项目名称：NetRet
 * 创建人：andy
 * 创建时间：2016/4/29 14:14
 * 修改备注：
 */
public class URLData {
    private String key;//请求方法
    private long expires;//缓存有效时间
    private String netType;//请求方式 GET POST
    private String url;//请求URL
    private String mockClass;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public long getExpires() {
        return expires;
    }

    public void setExpires(long expires) {
        this.expires = expires;
    }

    public String getNetType() {
        return netType;
    }

    public void setNetType(String netType) {
        this.netType = netType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMockClass() {
        return mockClass;
    }

    public void setMockClass(String mockClass) {
        this.mockClass = mockClass;
    }
}
