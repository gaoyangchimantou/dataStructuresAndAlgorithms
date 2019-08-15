package com.bfsu.linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode heroNode1=new HeroNode(1,"宋江","及时雨");
        HeroNode heroNode2=new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode heroNode3=new HeroNode(3,"吴用","智多星");
        HeroNode heroNode4=new HeroNode(4,"公孙胜","入云龙");
        SingleLinkedList singleLinkedList =new SingleLinkedList();
        /*singleLinkedList.add(heroNode1);
        singleLinkedList.add(heroNode2);
        singleLinkedList.add(heroNode3);
        singleLinkedList.add(heroNode4);*/
      /*  singleLinkedList.addByOrfder(heroNode1);
        singleLinkedList.addByOrfder(heroNode4);
        singleLinkedList.addByOrfder(heroNode2);
        singleLinkedList.addByOrfder(heroNode3);
        singleLinkedList.addByOrfder(heroNode4);
        singleLinkedList.list();

        HeroNode heroNode2_1=new HeroNode(2,"xiao卤","小麒麟");
        singleLinkedList.updateNode(heroNode2_1);
        singleLinkedList.list();
        singleLinkedList.delNode(1);
        singleLinkedList.delNode(4);
      // singleLinkedList.delNode(3);
        singleLinkedList.list();

        System.out.println(singleLinkedList.getLength(singleLinkedList.getHead()));
        //getNodeLastIndex
        System.out.println(singleLinkedList.getNodeLastIndex(singleLinkedList.getHead(),2));*/
        singleLinkedList.addByOrfder(heroNode1);
        singleLinkedList.addByOrfder(heroNode4);
        singleLinkedList.addByOrfder(heroNode2);
        singleLinkedList.addByOrfder(heroNode3);
        singleLinkedList.list();
       /* System.out.println("反转后.........................");
        SingleLinkedList.reversetList(singleLinkedList.getHead());
        singleLinkedList.list();*/
        System.out.println("你需打印后,不改变链表结构...");
        SingleLinkedList.reversePrint(singleLinkedList.getHead());
    }
}

class SingleLinkedList{
    private HeroNode head=new HeroNode(0,"","");
    public HeroNode getHead() {
        return head;
    }
    //添加节点到单向链表
    //思路，当不考虑编号顺序时
    //1. 找到当前链表的最后节点
    //2. 将最后这个节点的next 指向 新的节点
    public void add(HeroNode heroNode){
        if(head.getNext()!=null){
            HeroNode temp=head.getNext();
            while(true){
                if(temp.getNext()==null){
                    temp.setNext(heroNode);
                    break;
                }else{
                    temp=temp.getNext();
                }
            }
        }else{
            head.setNext(heroNode);
        }

    }
    //第二种添加方式 添加英雄时,根据排名将英雄插入到指定位置
    //如果有这个排名  则添加失败   并给出提示
    public void addByOrfder(HeroNode heroNode){
        HeroNode temp=head;
        boolean flag=false;
        while (true){
            if(temp.getNext()==null){
                break;
            }
            if(temp.getNext().getNo()>heroNode.getNo()){
                //
                break;
            }
            if(temp.getNext().getNo()==heroNode.getNo()){
                flag=true;
                break;
            }
            temp=temp.getNext();
        }
        if(flag){
            System.out.printf("改编号的英雄已存在,无法添加: %d",heroNode.getNo());
        }else{
            heroNode.setNext(temp.getNext());
            temp.setNext(heroNode);
        }

    }
    //修改node
    public void updateNode(HeroNode heroNode){
           if(head.getNext()==null){
               System.out.println("链表为空,无法修改!");
               return ;
           }
            HeroNode temp=head.getNext();
           boolean flag=false;
           while(true){
               if(temp==null){
                   break;
               }
               if (temp.getNo()==heroNode.getNo()){
                   flag=true;
                   break;
               }
               temp=temp.getNext();
           }
           if (flag){
                temp.setName(heroNode.getName());
                temp.setNickName(heroNode.getNickName());
           }else{
               System.out.println("没找到,该节点..");
           }

    }
    public void delNode(int no){
        if(head.getNext()==null){
            System.out.println("链表为空,无法删除!");
            return;
        }
        HeroNode temp=head;
        boolean flag=false;
        while(true){
            if (temp.getNext()==null){
                break;
            }
            if(temp.getNext().getNo()==no){
                //
                flag=true;
                break;
            }
            temp=temp.getNext();
        }
        if (flag){
            temp.setNext(temp.getNext().getNext());
        }else{
            System.out.println("没找到相应的节点...");
        }
    }
    //显示链表[遍历]
    public void list() {
       if(head.getNext()==null){
           System.out.println("链表为空...");
           return;
       }
       HeroNode temp =head.getNext();
       while (true){
           if(temp==null){
               break;
           }
           System.out.println(temp);
           temp=temp.getNext();
       }
    }

    public static int getLength(HeroNode head){
        if(head.getNext()==null){
            return 0;
        }
        HeroNode cur=head.getNext();
        int length=0;
       /* while (true){
            if(cur!=null){
                length++;
            }else{
                break;
            }
            cur=cur.getNext();
        }
        return length;*/
       while (cur!=null){
           length++;
           cur=cur.getNext();
       }
       return length;
    }
    //查找单链表中的倒数第K个节点
    /**
     * 传入头结点,和倒数第几个的个数
     */
    public static HeroNode getNodeLastIndex(HeroNode head,int index){
        if(head.getNext()==null) {
            return null;
        }
        int size= getLength(head);
        if(index<=0||index>size){
            return null;
        }
        HeroNode cur=head.getNext();
        for (int i=0;i<size-index;i++){
            cur=cur.getNext();
        }
        return cur;
    }
    /**
     * 单链表的反转
     */
    public static void reversetList(HeroNode head){

        if(head.getNext()==null||head.getNext().getNext()==null){
            return;
        }
        HeroNode cur=head.getNext();
        HeroNode next=null;//存储head的下一个节点
        HeroNode reversetHead=new HeroNode(0,"","");
        while (cur!=null){
            next=cur.getNext();
            cur.setNext(reversetHead.getNext());//
            reversetHead.setNext(cur);
            cur=next;
        }
        head.setNext(reversetHead.getNext());
    }
    //只是 逆序打印单链表,不改变单链表的结构
    public static void reversePrint(HeroNode head){
        if(head.getNext()==null){
            System.out.println("链表为空,不需要打印!");
        }
        HeroNode temp =head.getNext();
        Stack<HeroNode> heroNodes = new Stack<>();
        while (temp!=null){
            heroNodes.push(temp);
            temp=temp.getNext();
        }
        while (heroNodes.size()>0){
            System.out.println(heroNodes.pop());
        }
    }
}

class HeroNode{
    private int no;
    private String name;
    private String nickName;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }
    private HeroNode next;//指向下一个节点
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public HeroNode getNext() {
        return next;
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", next=" + next +
                '}';
    }
}