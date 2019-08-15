package com.bfsu.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {


    public static void main(String[] args) {
        //先定义给逆波兰表达式, 为了方便我们将逆波兰表达式的数字和符号使用空格分开
      /*  String suffixExpression="30 4 + 5 * 6 -";
        List<String> listString = PolandNotation.getListString(suffixExpression);
        Stack<String> satck =new Stack<String>();
        for (String s:listString) {
            if(s.matches("\\d+")){
                satck.push(s);
            }else {
                //则是符号
                int num1 = Integer.parseInt(satck.pop());
                int num2 = Integer.parseInt(satck.pop());
                int cal = PolandNotation.cal(s, num1, num2);
                satck.push(cal+"");
            }
        }
        System.out.println("sum-->:"+satck.pop());*/
      String s="1+((2+3)*4)-5";
        List<String> list = PolandNotation.toInfixExpressionList(s);
        System.out.println(list);


        List<String> list1 = parseSuffixExpreesionList(list);
        System.out.println(list1);

        //验证得到的逆波兰表达式的运算结果
        Stack<String> satck =new Stack<String>();
        for (String s1:list1) {
            if(s1.matches("\\d+")){
                satck.push(s1);
            }else {
                //则是符号
                int num1 = Integer.parseInt(satck.pop());
                int num2 = Integer.parseInt(satck.pop());
                int cal = PolandNotation.cal(s1, num1, num2);
                satck.push(cal+"");
            }
        }
        System.out.println("sum-->:"+satck.pop());
    }



    //输入一个逆波兰表达式,一次将数字与符号放入attaylist中
    public static List<String> getListString(String suffixExpression){
        String[] split = suffixExpression.split(" ");
        List<String> list =new ArrayList<String>();
        for (String s:split) {
            list.add(s);
        }
        return list;
    }

    public static int cal(String oper,int num1,int num2){
        if(oper.equals("+")){
            return num2+num1;
        }else if(oper.equals("-")){
            return num2-num1;
        }else if(oper.equals("*")){
            return num2*num1;
        }else if(oper.equals("/")){
            return num2/num1;
        }else {
           return 0;
        }
    }
    //  s="1+((2+3)??4)-5";
    //s="1+((2+3)*4)-5";
    //根据一个中缀字符串获得他的list集合
    public static List<String> toInfixExpressionList(String s) {
        List<String> list = new ArrayList<String>();
        int index=0;
        String str="";
        while (index<s.length()){
            char c = s.charAt(index);

            if(c<48||c>57){

                //如果他是运算符就直接add到list集合中
                list.add(c+"");
                index++;
            }else if(c>=48&&c<=57){
                str="";
                //说明c是数字  还要处理多位数
                /*str+=c+"";*/
                while (index<s.length()&&s.charAt(index)>=48&&s.charAt(index)<=57){
                    str+=s.charAt(index);
                    index++;
                }
                list.add(str);
            }
        }
        return list;
    }
    //parseSuffixExpreesionList
    public static List<String> parseSuffixExpreesionList(List<String> infixExpressionList){
            Stack<String> s1=new Stack<String>();
            List<String>  s2=new ArrayList<String>();
        for (String item:infixExpressionList) {
            if(item.matches("\\d+")){
                //如果是数字,直接加入到集合s2中
                s2.add(item);
            } else if(item.equals("(")){
                //如果遇到左括号时,直接将其压入S1
                s1.push(item);
            }else if(item.equals(")")){
                //如果是右括号,则依次弹出S1栈顶的运算符,并压入S2,并且直至遇到左括号 为止此时,将这一对括号丢弃
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();//将那个对应的左括号也给弹出
            }else{
                while(!s1.isEmpty()&&Operation.getLev(item)<=Operation.getLev(s1.peek())){

                    s2.add(s1.pop());
                }
                //最后不管 运算符级别高低,都将其压入到S1中
               s1.push(item);
            }
        }
            while (!s1.isEmpty()){
                s2.add(s1.pop());
            }
            return s2;
    }
}


class Operation{
    public static int getLev(String oper){
        if(oper.equals("*")||oper.equals("/")){
            return 2;
        }
        if(oper.equals("+")||oper.equals("-")){
            return 1;
        }
        return 0;
    }
}