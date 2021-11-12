package com.zhw.interview.naverchina.problems;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description 问题三 用数组和栈实现队列
 * @Author Zhang Hongwei
 * @Date 2021/11/12 10:08
 */
public class Problem3 {
    /**
     * queue implemented by array without general type
     */
    static class MyQueueWithArray{
        int[] e;
        int first;
        int last;

        int maxSize = Integer.MAX_VALUE - 10;

        public MyQueueWithArray(int initialSize) {
            if (initialSize <= 0){
                e = new int[16];
            }else {
                e = new int[initialSize];
            }
        }

        public boolean isEmpty(){
            return last == first;
        }

        public void offer(int v){
            e[last++] = v;
            if (last == e.length){
                resize();
            }
        }

        public Integer poll(){
            if (!isEmpty()){
                return e[first++];
            }else {
                return null;
            }
        }

        public Integer peek(){
            if (!isEmpty()){
                return e[first];
            }else {
                return null;
            }
        }

        private void resize() {
            if (maxSize == e.length){
                throw new OutOfMemoryError();
            }
            int[]  newArr = new int[e.length > Integer.MAX_VALUE / 2 ? maxSize : e.length * 2];
            System.arraycopy(e, first, newArr, 0, last - first);
            last = last - first;
            first = 0;
            e = newArr;
        }

    }


    /**
     * queue implemented by stack with general
     * @param <E>
     */
    static class MyQueueWithStack<E>{
        Deque<E> stackForOffer = new LinkedList<>();
        Deque<E> stackForPoll = new LinkedList<>();

        public void offer(E e){
            stackForOffer.push(e);
        }

        public E poll(){
            if (stackForPoll.isEmpty()){
                while (!stackForOffer.isEmpty()){
                    stackForPoll.push(stackForOffer.pop());
                }
            }
            return stackForPoll.isEmpty() ? null : stackForPoll.pop();
        }

        public boolean isEmpty(){
            return stackForOffer.isEmpty() && stackForPoll.isEmpty();
        }

        public E peek(){
            if (stackForPoll.isEmpty()){
                while (!stackForOffer.isEmpty()) {
                    stackForPoll.push(stackForOffer.pop());
                }
            }
            return stackForPoll.isEmpty() ? null : stackForPoll.peek();
        }
    }
}
