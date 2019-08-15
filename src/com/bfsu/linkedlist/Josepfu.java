package com.bfsu.linkedlist;

public class Josepfu {

    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);// ����5��С���ڵ�
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
    // ���С���ڵ㣬������һ�����ε�����
    public void addBoy(int nums) {

        if(nums<1){
            System.out.println("������������!");
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
                System.out.println("ѧ�����:"+curBoy.getNo());
                if(curBoy.getNext().equals(first)){
                    return;
                }
                curBoy=curBoy.getNext();
            }
        }*/
       if(first==null){
           System.out.println("��������Ϊ��!!");
       }
       while(true){
           System.out.println("ѧ�����:"+curBoy.getNo());
           if(curBoy.getNext().equals(first)){
               return;
           }
           curBoy=curBoy.getNext();
       }
    }

    /**
     *
     * @param startNo ��ʾ�ӵڼ���С������ʼ����
     * @param countNum ��ʾ������
     * @param nums ��ʾ����ж���С����Ȧ��
     */
    public void countBoy(int startNo,int countNum,int nums){

        //�ȶ����ݽ���У��
        if(startNo<1||countNum<0||nums<0||startNo>nums||first==null){
            System.out.println("���������������!");
            return;
        }
        Boy helper=first;
        //��Ϊ��������Ľڵ��޷���ɾ��.�����½�һ�������ڵ�����ָ����Ҫɾ���Ľڵ����һ���ڵ�
        //�����Ƚ�helperָ��first��ǰһ���ڵ�
        while (true){
            if(helper.getNext()==first){
                break;
            }
            helper=helper.getNext();
        }
        //��n��ʼ��,�ڵ��Ҫ�ƶ�n-1��,��Ϊ����,�Լ�ҲҪ��һ��
        for (int i=0;i<startNo-1;i++){
            first=first.getNext();
            helper=helper.getNext();
        }
        //��ʼ��,�����ҵ��Ľڵ�ɾ����
        /*for (int i=0;i<countNum-1;i++){
            first=first.getNext();
            helper=helper.getNext();
        }*/
        while (true){
            if(first==helper){
                System.out.println(first.getNo()+"��С������Ȧ����....");
                break;
            }
            for (int i=0;i<countNum-1;i++){
                first=first.getNext();
                helper=helper.getNext();
            }
            System.out.println(first.getNo()+"��С����Ȧ��....");
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