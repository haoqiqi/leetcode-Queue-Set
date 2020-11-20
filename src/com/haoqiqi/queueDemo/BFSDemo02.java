package com.haoqiqi.queueDemo;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BFSDemo02 {
    public static void main(String[] args) {
        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0592";
        Solution2 solution2 = new Solution2();
        int i = solution2.openLock(deadends, target);
        System.out.println(i);
    }
}

class Solution2{
    public int openLock(String[] deadends, String target){
        // 存储所有等待处理的节点
        Queue<String> queue = new LinkedList<>();
        // 储存观测过的节点
        Set<String> visited = new HashSet<>();
        // 储存死锁代码
        Set<String> deads = new HashSet<>();
        for (String s : deadends) {
            deads.add(s);
        }

        // 开始的地方
        int step = 0;
        queue.offer("0000");
        visited.add("0000");

        // BFS
        while(!queue.isEmpty()){
            // 记录大小
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                //迭代队列中已经存在的节点
                String s = queue.poll();
                // 若为死锁代码，则跳过
                if(deads.contains(s)){
                    continue;
                }
                if(s.equals(target)){
                    return step;
                }
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(s, j);
                    if(!visited.contains(up)){
                        queue.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(s, j);
                    if(!visited.contains(down)){
                        queue.offer(down);
                        visited.add(down);
                    }
                }
            }
            // 如果step放上面的话，则比正常的数据多1
            step++;
        }
        return -1;
    }

    // 某位上加一
    private String plusOne(String s, int j){
        char[] c = s.toCharArray();
        if(c[j] == '9') {
            c[j] = '0';
        } else {
            c[j] += 1;
        }
        return new String(c);
    }

    // 某位上减一
    private String minusOne(String s, int j){
        char[] c = s.toCharArray();
        if(c[j] == '0') {
            c[j] = '9';
        } else {
            c[j] -= 1;
        }
        return new String(c);
    }
}

