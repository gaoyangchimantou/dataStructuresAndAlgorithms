package com.bfsu.linkedlist;

public class DoubleLinkedListDemo {

    public static void main(String[] args) {


        // ����
        System.out.println("˫������Ĳ���");
        // �ȴ����ڵ�
        HeroNode2 hero1 = new HeroNode2(1, "�ν�", "��ʱ��");
        HeroNode2 hero2 = new HeroNode2(2, "¬����", "������");
        HeroNode2 hero3 = new HeroNode2(3, "����", "�Ƕ���");
        HeroNode2 hero4 = new HeroNode2(4, "�ֳ�", "����ͷ");
        // ����һ��˫������
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.list();

        // �޸�
        HeroNode2 newHeroNode = new HeroNode2(4, "����ʤ", "������");
        doubleLinkedList.updateNode(newHeroNode);
        System.out.println("�޸ĺ���������");
        doubleLinkedList.list();

        // ɾ��
        doubleLinkedList.del(3);
        System.out.println("ɾ������������~~");
        doubleLinkedList.list();


    }


}

// ����һ��˫���������
class DoubleLinkedList {

    // �ȳ�ʼ��һ��ͷ�ڵ�, ͷ�ڵ㲻Ҫ��, ����ž��������
    private HeroNode2 head = new HeroNode2(0, "", "");

    // ����ͷ�ڵ�
    public HeroNode2 getHead() {
        return head;
    }


        //��ʾ����[����]
        public void list() {
            if(head.getNext()==null){
                System.out.println("����Ϊ��...");
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
    // ���һ���ڵ㵽˫����������.
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

    //�޸� �͵�������ķ���һ��,ֻ�ǰ����ͻ���˫���������
    public void updateNode(HeroNode2 heroNode){
        if(head.getNext()==null){
            System.out.println("����Ϊ��,�޷��޸�!");
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
            System.out.println("û�ҵ�,�ýڵ�..");
        }

    }
    //�ڵ�ɾ������
    public  void  del(int i){
        HeroNode2 temp=head.getNext();
        boolean flag=false;
        while (true){
            if(temp==null){
                //�ѵ�����������,
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
            System.out.println("û�ҵ�");
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
    private HeroNode2 pre;//ָ����һ���ڵ�

    public HeroNode2 getPre() {
        return pre;
    }

    public void setPre(HeroNode2 pre) {
        this.pre = pre;
    }

    private HeroNode2 next;//ָ����һ���ڵ�
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