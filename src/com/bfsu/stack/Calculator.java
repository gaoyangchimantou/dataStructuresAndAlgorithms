package com.bfsu.stack;

public class Calculator {

    public static void main(String[] args) {
       // String exp="3+2*6-2";
        String exp="1+1*2/2";
        int index=0;//ָ��,����ȡ���ַ����е�ֵ
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
                //����������
                if (!opeStack.isEmpty()){
                    if(ArrayStack2.priority(charAt)<=ArrayStack2.priority(opeStack.pick())){
                        //���������������������ȼ�С�ڵ���ջ�е������ʱ,�ʹ�ջ��ȡ�����������������
                         num1 = numStack.pop();
                         num2 = numStack.pop();
                        int pop = opeStack.pop();
                        res= ArrayStack2.cal(num1, num2,pop );
                        numStack.push(res);
                        opeStack.push(charAt);
                    }else{
                        //���ڵĻ�,ֱ��push��ȥ
                        opeStack.push(charAt);
                    }
                }else{
                    //�������ջΪ��ʱ,ֱ���ӽ�ȥ
                    opeStack.push(charAt);
                }
            }else{
                //�����������
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

    private int maxSize;//ջ�Ĵ�С
    private int[] stack;//����,����ģ��ջ,���ݾͷ���������
    private int top=-1;//top����ջ��,Ĭ��ֵ��-1

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
        int temp=stack[top];
        top--;
        return temp;

    }
    // ��һ��ջ����ֵ��С
    public int pick(){
        if(isEmpty()){
            throw new RuntimeException("ջΪ��,�޷��ٵ���!");
        }
       /* int temp=top;
        top--;
        return temp;*/
       return stack[top];

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
    //��������������ȼ������ȼ��ǳ���Ա��ȷ��, ���ȼ�ʹ�����ֱ�ʾ
    //����Խ�������ȼ���Խ��.
    public static int priority(int oper) {
        if(oper=='*'||oper=='/'){
            return 1;
        }else if(oper=='+'||oper=='-'){
            return 0;
        }else{
            //���Ǳ�׼���������
            return -1;
        }
    }
    //�ж��ǲ���һ�������
    public static boolean isOper(char val){
        return val=='+'||val=='-'||val=='*'||val=='/';
    }
    //���㷽��
    public static int cal(int num1,int num2,int oper){
        int res=0;//���ڴ��������
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








