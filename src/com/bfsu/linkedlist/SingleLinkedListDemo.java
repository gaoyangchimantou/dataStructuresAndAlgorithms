package com.bfsu.linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode heroNode1=new HeroNode(1,"�ν�","��ʱ��");
        HeroNode heroNode2=new HeroNode(2,"¬����","������");
        HeroNode heroNode3=new HeroNode(3,"����","�Ƕ���");
        HeroNode heroNode4=new HeroNode(4,"����ʤ","������");
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

        HeroNode heroNode2_1=new HeroNode(2,"xiao±","С����");
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
       /* System.out.println("��ת��.........................");
        SingleLinkedList.reversetList(singleLinkedList.getHead());
        singleLinkedList.list();*/
        System.out.println("�����ӡ��,���ı�����ṹ...");
        SingleLinkedList.reversePrint(singleLinkedList.getHead());
    }
}

class SingleLinkedList{
    private HeroNode head=new HeroNode(0,"","");
    public HeroNode getHead() {
        return head;
    }
    //��ӽڵ㵽��������
    //˼·���������Ǳ��˳��ʱ
    //1. �ҵ���ǰ��������ڵ�
    //2. ���������ڵ��next ָ�� �µĽڵ�
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
    //�ڶ�����ӷ�ʽ ���Ӣ��ʱ,����������Ӣ�۲��뵽ָ��λ��
    //������������  �����ʧ��   ��������ʾ
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
            System.out.printf("�ı�ŵ�Ӣ���Ѵ���,�޷����: %d",heroNode.getNo());
        }else{
            heroNode.setNext(temp.getNext());
            temp.setNext(heroNode);
        }

    }
    //�޸�node
    public void updateNode(HeroNode heroNode){
           if(head.getNext()==null){
               System.out.println("����Ϊ��,�޷��޸�!");
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
               System.out.println("û�ҵ�,�ýڵ�..");
           }

    }
    public void delNode(int no){
        if(head.getNext()==null){
            System.out.println("����Ϊ��,�޷�ɾ��!");
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
            System.out.println("û�ҵ���Ӧ�Ľڵ�...");
        }
    }
    //��ʾ����[����]
    public void list() {
       if(head.getNext()==null){
           System.out.println("����Ϊ��...");
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
    //���ҵ������еĵ�����K���ڵ�
    /**
     * ����ͷ���,�͵����ڼ����ĸ���
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
     * ������ķ�ת
     */
    public static void reversetList(HeroNode head){

        if(head.getNext()==null||head.getNext().getNext()==null){
            return;
        }
        HeroNode cur=head.getNext();
        HeroNode next=null;//�洢head����һ���ڵ�
        HeroNode reversetHead=new HeroNode(0,"","");
        while (cur!=null){
            next=cur.getNext();
            cur.setNext(reversetHead.getNext());//
            reversetHead.setNext(cur);
            cur=next;
        }
        head.setNext(reversetHead.getNext());
    }
    //ֻ�� �����ӡ������,���ı䵥����Ľṹ
    public static void reversePrint(HeroNode head){
        if(head.getNext()==null){
            System.out.println("����Ϊ��,����Ҫ��ӡ!");
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
    private HeroNode next;//ָ����һ���ڵ�
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