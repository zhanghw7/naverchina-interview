package com.zhw.interview.naverchina.problems;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description 问题2
 * @Author Zhang Hongwei
 * @Date 2021/11/12 10:50
 */
public class Problem2 {
    static class CachedData{
        Object data;
        ReentrantReadWriteLock lock;
        boolean isValid ;

        public CachedData(Object data) {
            this.data = data;
            isValid = true;
            lock = new ReentrantReadWriteLock();
        }

        public Object processCachedData(){
            lock.readLock().lock();
            try {
                if (!isValid) {
                    lock.readLock().unlock();
                    return update();
                }else {
                    return data;
                }
            } finally {
                lock.readLock().unlock();
            }
        }

        public Object update(){
            lock.writeLock().lock();
            try {
                //update
                isValid = true;
                return data;
            } finally {
                lock.writeLock().unlock();
            }
        }
    }
}
