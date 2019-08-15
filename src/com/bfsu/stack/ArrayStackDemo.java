package com.bfsu.stack;



import java.util.Scanner;
import java.util.Stack;

public class ArrayStackDemo {
    public static void main(String[] args) {
        //测试一下ArrayStack 是否正确
        //先创建一个ArrayStack对象->表示栈
    /*   ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true; //控制是否退出菜单
        Scanner scanner = new Scanner(System.in);

        while(loop) {
            System.out.println("show: 表示显示栈");
            System.out.println("exit: 退出程序");
            System.out.println("push: 表示添加数据到栈(入栈)");
            System.out.println("pop: 表示从栈取出数据(出栈)");
            System.out.println("请输入你的选择");
            key = scanner.next();
            switch (key) {
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.printf("出栈的数据是 %d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

        System.out.println("程序退出~~~");
*/


        LinkedListStack linkedListStack=new LinkedListStack();
        linkedListStack.push(1);
        linkedListStack.push(2);
        linkedListStack.push(3);
        linkedListStack.push(4);
        linkedListStack.list();
        linkedListStack.pop();
        linkedListStack.list();
    }

}

//定义一个 ArrayStack 表示栈
class ArrayStack {

    private int maxSize;//栈的大小
    private int[] stack;//数组,数组模拟栈,数据就放在数组里
    private int top=-1;//top代表栈顶,默认值是-1

    public ArrayStack(int maxSize){
        this.maxSize=maxSize;
        stack=new int[maxSize];
    }
    public boolean isFull(){
        return top==maxSize-1;
    }
    public boolean isEmpty(){
        return top==-1;
    }
    //入栈
    public void push(int value){
        if (isFull()){
            System.out.println("栈已满,无法再加入!");
            return;
        }
        top++;
        stack[top]=value;
    }
    //出栈,弹栈
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈为空,无法再弹出!");
        }
        int temp=top;
        top--;
        return temp;

    }
    //显示栈的情况[遍历栈]， 遍历时，需要从栈顶开始显示数据
    public void list(){
        if (isEmpty()){
            System.out.println("栈为空....");
            return;
        }
        for (int i=top;i>=0;i--){
            System.out.println("遍历-->"+ stack[i]);

        }
    }

}
//使用单向链表,来模拟栈
class LinkedListStack {
//SingleLinkedList

    private int maxSize;//栈的大小
    private int top=-1;//top代表栈顶,默认值是-1
    private SingleLinkedList singleLinkedList =new SingleLinkedList();

    public boolean isFull(){
        if(!isEmpty()){
          return maxSize==singleLinkedList.size();
        }
        return false;
    }
    public boolean isEmpty(){
       return singleLinkedList.getHead().getNext()==null;
    }
    public void push(int value){
            if (isFull()){
                System.out.println("栈已满,无法再push!");
                return;
            }
        singleLinkedList.add(new HeroNode(value,"default","default"));
    }
    public HeroNode pop(){
        if (isEmpty()){
            throw new RuntimeException("栈为空,无法再弹出!");
        }
        HeroNode temp=singleLinkedList.getHead().getNext();
        while (true){
            if (temp.getNext()==null){

                break;
            }
            temp=temp.getNext();
        }
        singleLinkedList.delNode(temp.getNo());
        return temp;

    }

    public void list(){
        if (isEmpty()){
            System.out.println("栈为空..........");
            return;
        }
        SingleLinkedList.reversePrint(singleLinkedList.getHead());
    }
}

//-----------------------------------------------------------------------------------------------
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

    public int size(){

        /*int temp=0;
        HeroNode tempNode=head;
        while (true){
            if(tempNode.getNext()!=null){
                temp++;
                tempNode=tempNode.getNext();
            }else{
                break;
            }
        }
        return temp;*/
        int temp=0;
        HeroNode tempNode=head.getNext();
        while (true){
            if(tempNode!=null){
                temp++;
                tempNode=tempNode.getNext();
            }else{
                break;
            }
        }
        return temp;
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