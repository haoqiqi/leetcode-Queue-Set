package com.haoqiqi.queueDemo;

public class MyCircularQueueDemo01 {
    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
        circularQueue.enQueue(1); // 返回 true
        circularQueue.enQueue(2); // 返回 true
        circularQueue.enQueue(3); // 返回 true
        circularQueue.enQueue(4); // 返回 false，队列已满
        circularQueue.Rear(); // 返回 3
        circularQueue.isFull(); // 返回 true
        circularQueue.deQueue(); // 返回 true
        circularQueue.enQueue(4); // 返回 true
        circularQueue.Rear(); // 返回 4
    }
}

class MyCircularQueue{
    private int capacity;   // 队列的容量
    private int tailIndex;  // 尾指针
    private int headIndex;  // 头指针
    private int[] queue;    // 队列数组

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.capacity = k;
        this.queue = new int[k];
        this.tailIndex = 0;
        this.headIndex = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        // 队列满了
        if(this.tailIndex == this.capacity)
            return false;
        // 循环赋值
        this.queue[(this.headIndex + this.tailIndex) % this.capacity] = value;
        this.tailIndex+=1;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(this.tailIndex == 0)
            return false;
        this.headIndex = (this.headIndex + 1) % this.capacity;
        this.tailIndex-=1;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(this.tailIndex == 0)
            return -1;
        return this.queue[this.headIndex];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(this.tailIndex == 0)
            return -1;
        int tailIndexOfTrue = (this.headIndex + this.tailIndex - 1) % this.capacity;
        return this.queue[tailIndexOfTrue];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return (this.tailIndex == 0);
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (this.capacity == this.tailIndex);
    }
}
