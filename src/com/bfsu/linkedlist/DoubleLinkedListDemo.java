package com.bfsu.linkedlist;

public class DoubleLinkedListDemo {

    public static void main(String[] args) {


        // 测试
        System.out.println("双向链表的测试");
        // 先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
        // 创建一个双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.list();

        // 修改
        HeroNode2 newHeroNode = new HeroNode2(4, "公孙胜", "入云龙");
        doubleLinkedList.updateNode(newHeroNode);
        System.out.println("修改后的链表情况");
        doubleLinkedList.list();

        // 删除
        doubleLinkedList.del(3);
        System.out.println("删除后的链表情况~~");
        doubleLinkedList.list();


    }


}

// 创建一个双向链表的类
class DoubleLinkedList {

    // 先初始化一个头节点, 头节点不要动, 不存放具体的数据
    private HeroNode2 head = new HeroNode2(0, "", "");

    // 返回头节点
    public HeroNode2 getHead() {
        return head;
    }


        //显示链表[遍历]
        public void list() {
            if(head.getNext()==null){
                System.out.println("链表为空...");
                return;
            }
            HeroNode2 temp =head.getNext();
            while (true){
                if(temp==null){
                    break;
                }
                System.out.println(temp);
                temp=temp.getNext();
            }
        }
    // 添加一个节点到双向链表的最后.
    public void add(HeroNode2 heroNode) {
        HeroNode2 temp=head;
        while(true){
            if(temp.getNext()==null){
                break;
            }
            temp=temp.getNext();
        }
        temp.setNext(heroNode);
        heroNode.setPre(temp);
    }

    //修改 和单向链表的方法一样,只是把类型换成双向链表就行
    public void updateNode(HeroNode2 heroNode){
        if(head.getNext()==null){
            System.out.println("链表为空,无法修改!");
            return ;
        }
        HeroNode2 temp=head.getNext();
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
    //节点删除方法
    public  void  del(int i){
        HeroNode2 temp=head.getNext();
        boolean flag=false;
        while (true){
            if(temp==null){
                //已到链表的最后面,
                break;
            }
            if(temp.getNo()==i){
                flag=true;
                break;
            }
            temp=temp.getNext();
        }
        if(flag){
            temp.getPre().setNext(temp.getNext());
            if(temp.getNext()!=null){
                temp.getNext().setPre(temp.getPre());
            }
        }else{
            System.out.println("没找到");
        }
    }
}

class HeroNode2{
    private int no;
    private String name;
    private String nickName;

    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }
    private HeroNode2 pre;//指向下一个节点

    public HeroNode2 getPre() {
        return pre;
    }

    public void setPre(HeroNode2 pre) {
        this.pre = pre;
    }

    private HeroNode2 next;//指向下一个节点
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
    public HeroNode2 getNext() {
        return next;
    }

    public void setNext(HeroNode2 next) {
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