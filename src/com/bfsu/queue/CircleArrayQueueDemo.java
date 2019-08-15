package com.bfsu.queue;

public class CircleArrayQueueDemo {


}
class CircleArray{
    private int maxSize;
    //指向队列的第一个元素,即arr[front] 即为数组的第一个元素
    //front的初始值为0
    private int front;
    //队列尾
    //rear的含义做一个调整:即rear指向队列的最后一个元素的后一个元素,因为希望空出一个空间座位约定
    //rear的初始值为0
    private int rear;
    private int[] arr;//该属性用于存放数据,模拟队列

    public CircleArray(int maxSize){
        this.maxSize=maxSize;
        arr=new int[maxSize];
    }
    //判断队列是否满
    public boolean isFull(){
        return (rear+1)%maxSize==front;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return rear==front;
    }
    // 添加数据到队列
    public void addQueue(int n){
      if(isFull()){
          throw  new RuntimeException("队列已满,无法添加新数据!");
      }
      arr[rear]=n;
      rear=(rear+1)%maxSize;
    }
    //从队列中获取数据
    public int getQueue(){
        if(isEmpty()){
            throw  new RuntimeException("队列shi空的!");
        }
        int value=arr[front];
        front=(front+1)%maxSize;
        return value;
    }

    public  void  showQueue(){
        if(isEmpty()){
            throw  new RuntimeException("队列shi空的!");
        }
        for (int i=front;i<front+maxSize;i++){
            System.out.printf("a[%d]=%d",i,arr[i%maxSize]);
        }
    }
    // 求出当前队列有效数据的个数
    public int size() {
        // rear = 2
        // front = 1
        // maxSize = 3
        return (rear + maxSize - front) % maxSize;
    }

    // 显示队列的头数据， 注意不是取出数据
    public int headQueue() {
        // 判断
        if (isEmpty()) {
            throw new RuntimeException("队列空的，没有数据~~");
        }
        return arr[front];
    }



}