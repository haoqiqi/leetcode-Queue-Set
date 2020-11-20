package com.haoqiqi.queueDemo;


import java.util.LinkedList;
import java.util.Queue;

public class BFSDemo01 {
    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'}, {'1','1','0','1','0'}, {'1','1','0','0','0'}, {'0','0','0','0','1'}};
        Solution1 solution = new Solution1();
        int i = solution.numIslands(grid);
        System.out.println(i);
    }
}

class Solution1{
    public int numIslands(char[][] gird){
        int count = 0;
        for (int i = 0; i < gird.length; i++) {
            for (int j = 0; j < gird[0].length; j++) {
                // 搜索条件
                if(gird[i][j] == '1'){
                    BFS(gird, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void BFS(char[][] gird, int i, int j){
        // 存储所有等待处理的节点
        Queue<int[]> list = new LinkedList<int[]>();
        int step = 0;
        // 初始化
        list.add(new int[] {i,j});
        // BFS
        while(!list.isEmpty()){
            step++;
            //迭代队列中已经存在的节点
            int[] cur = list.remove();
            i = cur[0]; j = cur[1];
            //
            if(i >= 0 && i < gird.length &&  j >= 0 && j < gird[0].length &&  gird[i][j] == '1'){
                gird[i][j] = '0';
                list.add(new int[] { i + 1, j });
                list.add(new int[] { i - 1, j });
                list.add(new int[] { i, j + 1 });
                list.add(new int[] { i, j - 1 });
                System.out.println("i:" + i + ", j:" + j);
            }
        }
        System.out.println("step:" + step);
    }
}
