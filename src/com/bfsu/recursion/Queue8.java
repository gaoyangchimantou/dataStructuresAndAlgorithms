package com.bfsu.recursion;

public class Queue8 {
    //定义一个max  共有多少个皇后
    int max=8;
    //定义数组array, 保存皇后放置位置的结果,比如 arr = {0 , 4, 7, 5, 2, 6, 1, 3}
    //这个数组  下标表示第几行,里面的值表示第几列  一个数组不同的值,就代表一个解
    int[] arr=new int[max];

    public static void main(String[] args) {
        Queue8 queue=new Queue8();

        queue.check(0);
    }
    public void check(int n){
        if(n==max){
            //因为N是从0开始的 ,所以当N=8时  就等于要放第九个皇后了,说明皇后已经放完了\
            print();
            return;
        }
        //从0开始往里放数据
        for (int i=0;i<max;i++){
            //现将
            arr[n]=i;
            if(judage(n)){
                //如果不冲突,再检查下一个
                check(n+1);

            }
        }

    }

    //写一个方法,当我们放置第N个皇后后,他是否和前面的皇后冲突
    public boolean judage(int n){
        for (int i=0;i<n;i++){
            //arr[i]==arr[n]说明两个皇后在同一列
            //Math.abs(n-i)==Math.abs(arr[n]-arr[i])说明两个元素在同一斜线上
            //横坐标不用比较,因为n一直在++
            if(arr[i]==arr[n]||Math.abs(n-i)==Math.abs(arr[n]-arr[i])){
                return false;
            }

        }
        return true;
    }

    //写一个方法,可以将皇后摆放的问题输出
    public void print(){
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
