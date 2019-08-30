package com.bfsu.hashtab;

public class HashTabDemo {

    public static void main(String[] args) {
        /*Emp emp1=new Emp(1,"111");
        Emp emp2=new Emp(2,"222");
        Emp emp3=new Emp(3,"333");
        Emp emp4=new Emp(4,"444");
        EmpLinkedList list=new EmpLinkedList();
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);
        list.add(emp4);
        list.list(1);*/
        Emp emp1=new Emp(1,"111");
        Emp emp2=new Emp(2,"222");
        Emp emp3=new Emp(3,"333");
        Emp emp4=new Emp(4,"444");
        HashTab hashTab=new HashTab(10);
        hashTab.add(emp1);
        hashTab.add(emp2);
        hashTab.add(emp3);
        hashTab.add(emp4);

        hashTab.findEmp(4);
    }

}

class HashTab{
    public EmpLinkedList[] empLinkedLists;
    public int size;
    public HashTab(int size){
        this.size=size;
        empLinkedLists=new EmpLinkedList[size];
        for (int i = 0; i <empLinkedLists.length ; i++) {
            empLinkedLists[i]=new EmpLinkedList();
        }
    }
    //编写散列函数, 使用一个简单取模法
    public int hashFun(int id){
        return id%size;
    }

    public void add(Emp emp){
        int i = hashFun(emp.getId());
        empLinkedLists[i].add(emp);
    }
    public void list(){
        for (int i = 0; i <empLinkedLists.length ; i++) {
            empLinkedLists[i].list(i);
        }
    }
    public void findEmp(int id){
        int i = hashFun(id);
        Emp empById = empLinkedLists[i].getEmpById(id);
        if(empById!=null){
            System.out.println("找到了..."+empById.getId());
        }else {
            System.out.println("没找到...");
        }
    }
}



class EmpLinkedList{
    public Emp head;
    public void add(Emp emp){
        if(head==null){
            head=emp;
            return;
        }
        Emp temp=head;
        while (true){
           if(temp.next==null){
               break;
           }
           temp=temp.next;
        }
        temp.next=emp;
    }
    public void list(int no){
        if(head==null){
            System.out.println("该链表为空!");
            return;

        }
        Emp temp=head;
        while (true){
            if(temp!=null){
                System.out.println("第"+no+"个链表"+temp.getId()+"-----"+temp.getName());
            }else {
                break;
            }
            temp=temp.next;
        }
    }
    public Emp getEmpById(int id){

        if(head==null){
            System.out.println("该链表为空...");
            return null;
        }
        Emp temp=head;
        while (true){
            if(temp.getId()==id){
                //找到了
                break;
            }
            if(temp.next==null){
                //到了链表的最后  ,即没找到
                temp=null;
                break;
            }
            temp=temp.next;
        }
        return temp;
    }
}

class Emp{
    private int id;
    private String name;
    public Emp next;


    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}