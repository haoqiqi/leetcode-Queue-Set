package com.haoqiqi.queueDemo;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  boolean add(E e)
 *           将指定的元素插入此队列（如果立即可行且不会违反容量限制），在成功时返回 true，如果当前没有可用的空间，则抛出 IllegalStateException。
 *  E element()
 *           获取，但是不移除此队列的头。
 *  boolean offer(E e)
 *           将指定的元素插入此队列（如果立即可行且不会违反容量限制），当使用有容量限制的队列时，此方法通常要优于 add(E)，后者可能无法插入元素，而只是抛出一个异常。
 *  E peek()
 *           获取但不移除此队列的头；如果此队列为空，则返回 null。
 *  E poll()
 *           获取并移除此队列的头，如果此队列为空，则返回 null。
 *  E remove()
 *           获取并移除此队列的头。
 */

public class QueueDemo01 {
    public static void main(String[] args) {
        // 1. Initialize a queue.
        Queue<Integer> q = new LinkedList();
        // 2. Get the first element - return null if queue is empty.
        System.out.println("The first element is: " + q.peek());    // The first element is: null
        // 3. Push new element.
        q.offer(5);
        q.offer(13);
        q.offer(8);
        q.offer(6);
        // 4. Pop an element.
        q.poll();
        // 5. Get the first element.
        System.out.println("The first element is: " + q.peek());    // The first element is: 13
        // 7. Get the size of the queue.
        System.out.println("The size is: " + q.size()); // The size is: 3
    }
}
