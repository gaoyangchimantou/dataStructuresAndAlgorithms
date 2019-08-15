package com.bfsu.queue;

public class ArrayQueueDemo {


}
//使用数组模拟一个队列arrayQueue
class ArrayQueue{
    private int maxSize;//队列的最大容量
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//该数组用于存放数据,模拟队列
    //创建队列的构造器
    public ArrayQueue(int maxSize){
        this.maxSize=maxSize;
        arr=new int[maxSize];
        front=-1;
        rear=-1;
    }
    //判断队列是否满
    public boolean isFull(){
        //如果队列尾已经到达数组的最后一个,则队列已经满了
        return rear==maxSize-1;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        //如果队列尾等于队列头 ,则说明队列是空的
        return rear==front;
    }

    // 添加数据到队列
    public void addQueue(int n){
        if (isFull()){
            throw new RuntimeException("队列已满,无法再加入新元素!");
        }
        rear++;
        arr[rear]=n;

    }
    // 获取队列的数据, 出队列

    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列空,无法再弹出数据!");
        }
        front++;
        return arr[front];
    }
    //// 显示队列的所有数据
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列是空的!");
            return;
        }
        for (int i=0;i<arr.length;i++){

            System.out.printf("arr[%d]:%d\n",i,arr[i]);
        }
    }
    // 显示队列的头数据， 注意不是取出数据
    public int headQueue() {
        if(isEmpty()){
            throw new RuntimeException("队列为空,没有头元素!");
        }
        return arr[front+1];
    }
}