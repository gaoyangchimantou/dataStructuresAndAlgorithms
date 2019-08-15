package com.bfsu.linkedlist;

public class Josepfu {

    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);// 加入5个小孩节点
        circleSingleLinkedList.showBoy();
        circleSingleLinkedList.countBoy(1,2,5);
    }

}

class CircleSingleLinkedList {

    private Boy first;
    public Boy getFirst() {
        return first;
    }

    public void setFirst(Boy first) {
        this.first = first;
    }
    // 添加小孩节点，构建成一个环形的链表
    public void addBoy(int nums) {

        if(nums<1){
            System.out.println("输入数量不对!");
            return;
        }
        Boy curBoy=null;
        for (int i=1;i<=nums;i++){
            if(i==1){
                Boy boy=new Boy(i);
                first=boy;
                first.setNext(first);
                curBoy=boy;
            }else {
                Boy boy=new Boy(i);
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy=boy;
            }
        }
    }

    public void showBoy(){
        Boy curBoy=first;
       /* while (true){
            if(curBoy!=null){
                System.out.println("学生编号:"+curBoy.getNo());
                if(curBoy.getNext().equals(first)){
                    return;
                }
                curBoy=curBoy.getNext();
            }
        }*/
       if(first==null){
           System.out.println("环形链表为空!!");
       }
       while(true){
           System.out.println("学生编号:"+curBoy.getNo());
           if(curBoy.getNext().equals(first)){
               return;
           }
           curBoy=curBoy.getNext();
       }
    }

    /**
     *
     * @param startNo 表示从第几个小孩儿开始数数
     * @param countNum 表示数几下
     * @param nums 表示最初有多少小孩在圈中
     */
    public void countBoy(int startNo,int countNum,int nums){

        //先对数据进行校验
        if(startNo<1||countNum<0||nums<0||startNo>nums||first==null){
            System.out.println("输入的数据有问题!");
            return;
        }
        Boy helper=first;
        //因为单向链表的节点无法自删除.所以新建一个辅助节点让他指向需要删除的节点的上一个节点
        //首先先将helper指向first的前一个节点
        while (true){
            if(helper.getNext()==first){
                break;
            }
            helper=helper.getNext();
        }
        //从n开始数,节点就要移动n-1次,因为报数,自己也要报一下
        for (int i=0;i<startNo-1;i++){
            first=first.getNext();
            helper=helper.getNext();
        }
        //开始数,并将找到的节点删除掉
        /*for (int i=0;i<countNum-1;i++){
            first=first.getNext();
            helper=helper.getNext();
        }*/
        while (true){
            if(first==helper){
                System.out.println(first.getNo()+"号小孩留在圈里了....");
                break;
            }
            for (int i=0;i<countNum-1;i++){
                first=first.getNext();
                helper=helper.getNext();
            }
            System.out.println(first.getNo()+"号小孩出圈了....");
            helper.setNext(first.getNext());
            first=first.getNext();
        }

    }
}

class Boy{
    private int no;

    public Boy(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    private Boy next;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
}