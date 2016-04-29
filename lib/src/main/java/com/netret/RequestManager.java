package com.netret;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述：
 * 项目名称：NetRet
 * 创建人：andy
 * 创建时间：2016/4/29 15:33
 * 修改备注：
 */
public class RequestManager {
    ArrayList<Request> requestList = null;

    public RequestManager() {
        // 异步请求列表
        requestList = new ArrayList<Request>();
    }

    /**
     * 添加Request到列表
     */
    public void addRequest(final Request request) {
        requestList.add(request);
    }

    /**
     * 取消网络请求
     */
    public void cancelRequest() {
        if ((requestList != null) && (requestList.size() > 0)) {
            for (final Request request : requestList) {
                if (request.getRequest() != null) {
                    try {
                        request.getRequest().abort();
                        requestList.remove(request.getRequest());
                    } catch (final UnsupportedOperationException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * 无参数调用
     */
    public Request createRequest(final URLData urlData,
                                     final Callback requestCallback) {
        final Request request = new Request(urlData, null,
                requestCallback);
        addRequest(request);

        return request;
    }

    /**
     * 有参数调用
     */
    public Request createRequest(final URLData urlData,
                                     final List<RequestParameter> params,
                                     final Callback requestCallback) {
        final Request request = new Request(urlData, params,
                requestCallback);

        addRequest(request);
        return request;
    }
}
