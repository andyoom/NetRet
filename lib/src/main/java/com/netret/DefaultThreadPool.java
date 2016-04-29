package com.netret;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 类描述：线程池 、缓冲队列
 * 项目名称：NetRet
 * 创建人：andy
 * 创建时间：2016/4/29 14:29
 * 修改备注：
 */
public class DefaultThreadPool implements IThreadPool{
    // 阻塞队列最大任务数量
    public static final int BLOCKING_QUEUE_SIZE = 20;
    // 线程池最大值
    public static final int THREAD_POOL_MAX_SIZE = 10;
    // 线程池初始大小
    public static final int THREAD_POOL_SIZE = 6;
    // 缓冲BaseRequest任务队列
    private BlockingQueue<Runnable> blockingQueue;
    //线程池
    private AbstractExecutorService pool;

    private static DefaultThreadPool instance = null;

    private DefaultThreadPool() {
        blockingQueue = new ArrayBlockingQueue<Runnable>(
                DefaultThreadPool.BLOCKING_QUEUE_SIZE);
        pool = new ThreadPoolExecutor(
                THREAD_POOL_SIZE,
                THREAD_POOL_MAX_SIZE, 15L, TimeUnit.SECONDS,
                blockingQueue,
                new ThreadPoolExecutor.DiscardOldestPolicy());
    }

    public static DefaultThreadPool getInstance() {
        if (instance == null) {
            synchronized (DefaultThreadPool.class){
                if(instance == null){
                    instance = new DefaultThreadPool();
                }
            }
        }
        return instance;
    }



    @Override
    public void removeTaskFromQueue(Object obj) {
        blockingQueue.remove(obj);
    }

    @Override
    public void removeAllTask() {
        blockingQueue.clear();
    }

    @Override
    public void shutdown() {
        if (pool != null) {
            pool.shutdown();
        }
    }

    @Override
    public void shutdownRightnow() {
        if (pool != null) {
            pool.shutdownNow();
            try {
                // 设置超时极短，强制关闭所有任务
                pool.awaitTermination(1, TimeUnit.MICROSECONDS);
            } catch (final InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void execute(Runnable r) {
        if (r != null) {
            try {
                pool.execute(r);
            } catch (final Exception e) {
                e.printStackTrace();
            }
        }
    }
}
