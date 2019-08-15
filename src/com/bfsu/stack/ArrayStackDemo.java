package com.bfsu.stack;



import java.util.Scanner;
import java.util.Stack;

public class ArrayStackDemo {
    public static void main(String[] args) {
        //����һ��ArrayStack �Ƿ���ȷ
        //�ȴ���һ��ArrayStack����->��ʾջ
    /*   ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true; //�����Ƿ��˳��˵�
        Scanner scanner = new Scanner(System.in);

        while(loop) {
            System.out.println("show: ��ʾ��ʾջ");
            System.out.println("exit: �˳�����");
            System.out.println("push: ��ʾ������ݵ�ջ(��ջ)");
            System.out.println("pop: ��ʾ��ջȡ������(��ջ)");
            System.out.println("���������ѡ��");
            key = scanner.next();
            switch (key) {
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("������һ����");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.printf("��ջ�������� %d\n", res);
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

        System.out.println("�����˳�~~~");
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

//����һ�� ArrayStack ��ʾջ
class ArrayStack {

    private int maxSize;//ջ�Ĵ�С
    private int[] stack;//����,����ģ��ջ,���ݾͷ���������
    private int top=-1;//top����ջ��,Ĭ��ֵ��-1

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
    //��ջ
    public void push(int value){
        if (isFull()){
            System.out.println("ջ����,�޷��ټ���!");
            return;
        }
        top++;
        stack[top]=value;
    }
    //��ջ,��ջ
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("ջΪ��,�޷��ٵ���!");
        }
        int temp=top;
        top--;
        return temp;

    }
    //��ʾջ�����[����ջ]�� ����ʱ����Ҫ��ջ����ʼ��ʾ����
    public void list(){
        if (isEmpty()){
            System.out.println("ջΪ��....");
            return;
        }
        for (int i=top;i>=0;i--){
            System.out.println("����-->"+ stack[i]);

        }
    }

}
//ʹ�õ�������,��ģ��ջ
class LinkedListStack {
//SingleLinkedList

    private int maxSize;//ջ�Ĵ�С
    private int top=-1;//top����ջ��,Ĭ��ֵ��-1
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
                System.out.println("ջ����,�޷���push!");
                return;
            }
        singleLinkedList.add(new HeroNode(value,"default","default"));
    }
    public HeroNode pop(){
        if (isEmpty()){
            throw new RuntimeException("ջΪ��,�޷��ٵ���!");
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
            System.out.println("ջΪ��..........");
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