package com.netret;

/**
 * 类描述：请求线程池接口
 * 项目名称：NetRet
 * 创建人：andy
 * 创建时间：2016/4/29 14:21
 * 修改备注：
 */
public interface IThreadPool {

    /**
     * 删除指定Task
     * @param obj
     */
    void removeTaskFromQueue(final Object obj);

    /**
     * 清空请求队列
     */
    void removeAllTask();

    /**
     * 关闭，并等待任务执行完成，不接受新任务
     */
    void shutdown();

    /**
     * 关闭，立即关闭，并挂起所有正在执行的线程，不接受新任务
     */
    void shutdownRightnow();

    /**
     * 执行任务
     * @param r
     */
    void execute(final Runnable r);
}
