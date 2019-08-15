package com.bfsu.stack;

public class Calculator {

    public static void main(String[] args) {
       // String exp="3+2*6-2";
        String exp="1+1*2/2";
        int index=0;//指针,用于取出字符串中的值
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 opeStack = new ArrayStack2(10);
        int num1=0;
        int num2=0;
        int res=0;
        int total=0;
        while (true){
            if(index==exp.length()){
                break;
            }
            char charAt = exp.charAt(index);
            if( ArrayStack2.isOper(charAt)){
                //如果是运算符
                if (!opeStack.isEmpty()){
                    if(ArrayStack2.priority(charAt)<=ArrayStack2.priority(opeStack.pick())){
                        //如果传进来的运算符的优先级小于等于栈中的运算符时,就从栈中取出运算符和数字运算
                         num1 = numStack.pop();
                         num2 = numStack.pop();
                        int pop = opeStack.pop();
                        res= ArrayStack2.cal(num1, num2,pop );
                        numStack.push(res);
                        opeStack.push(charAt);
                    }else{
                        //大于的话,直接push进去
                        opeStack.push(charAt);
                    }
                }else{
                    //运算符的栈为空时,直接扔进去
                    opeStack.push(charAt);
                }
            }else{
                //否则就是数字
                numStack.push(charAt-48);
            }
            index++;
        }
        while (true){
           if(opeStack.isEmpty()){
               //System.out.println(total);
               break;
           }
            num1=numStack.pop();
            num2=numStack.pop();
            int a=opeStack.pop();
            int cal = ArrayStack2.cal(num1, num2, a);
            numStack.push(cal);
        }
        System.out.println(numStack.pop());
    }


}

class ArrayStack2 {

    private int maxSize;//栈的大小
    private int[] stack;//数组,数组模拟栈,数据就放在数组里
    private int top=-1;//top代表栈顶,默认值是-1

    public ArrayStack2(int maxSize){
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
        int temp=stack[top];
        top--;
        return temp;

    }
    // 看一下栈顶的值大小
    public int pick(){
        if(isEmpty()){
            throw new RuntimeException("栈为空,无法再弹出!");
        }
       /* int temp=top;
        top--;
        return temp;*/
       return stack[top];

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
    //返回运算符的优先级，优先级是程序员来确定, 优先级使用数字表示
    //数字越大，则优先级就越高.
    public static int priority(int oper) {
        if(oper=='*'||oper=='/'){
            return 1;
        }else if(oper=='+'||oper=='-'){
            return 0;
        }else{
            //不是标准的运算符号
            return -1;
        }
    }
    //判断是不是一个运算符
    public static boolean isOper(char val){
        return val=='+'||val=='-'||val=='*'||val=='/';
    }
    //运算方法
    public static int cal(int num1,int num2,int oper){
        int res=0;//用于存放运算结果
        switch (oper){
            case '+':
                res=num1+num2;
                break;
            case '-':
                res=num2-num1;
                break;
            case '*':
                res=num2*num1;
                break;
            case '/':
                res=num2/num1;
                break;
                default:break;
        }
        return res;
    }

}








