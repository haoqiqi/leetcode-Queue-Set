package com.haoqiqi.queueDemo;
/*
https://leetcode-cn.com/problems/perfect-squares/solution/biao-zhun-de-bfs-ti-jie-by-tangweiqun/
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BFSDemo03 {
    public static void main(String[] args) {
        int n = 533;
        Solution3 solution3 = new Solution3();
        int i = solution3.numSquares(n);
        System.out.println(i);
    }
}

class Solution3{
    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<Integer>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(0);
        visited.add(0);
        int step = 0;
        while(!queue.isEmpty()){
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int j = 1; j*j + cur <= n; j++) {
                    int next = j * j + cur;
                    if(next == n)
                        return step;
                    if(next < n && !visited.contains(next)){
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
        }
        return step;
    }
}
