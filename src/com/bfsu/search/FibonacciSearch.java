package com.bfsu.search;

import java.util.Arrays;

public class FibonacciSearch {

    public static int maxSize=20;

    //斐波那契查找算法
    public static void main(String[] args) {
        int [] arr = {1,8, 10, 89, 1000, 1234};

        System.out.println("index=" + fibSearch(arr, 89));// 0
    }

    //用非递归方法获得一个斐波那契数组
    public static int[] fib(){

        int[] f=new int[maxSize];
        f[0]=1;
        f[1]=1;
        for (int i=2;i<maxSize;i++){
            f[i]= f[i-1]+ f[i-2];
        }
        return f;
    }
    //使用 斐波那契查找算法
    //使用非递归的方法查找

    /**
     *
     * @param arr 数组
     * @param key 我们需要查找的关键码
     * @return
     */
    public static int fibSearch(int[] arr,int key){
        int low=0;
        int high=arr.length-1;
        int k=0;//表示斐波那契分割数值的下标
        int mid=0;//存放mid值
        int[] f=fib();
        //获取到斐波那契分割数值的下标
        while (high>f[k]-1){
            k++;
        }
        //因为 f[k] 值 可能大于 a 的 长度，因此我们需要使用Arrays类，构造一个新的数组，并指向temp[]
        //不足的部分会使用0填充
        //实际上需求使用a数组最后的数填充 temp
        //举例:
        //temp = {1,8, 10, 89, 1000, 1234, 0, 0}  => {1,8, 10, 89, 1000, 1234, 1234, 1234,}

        int[] temp = Arrays.copyOf(arr, f[k]);
        for (int i = high+1; i <temp.length ; i++) {
            temp[i]=arr[high];
        }
        while (low<=high){
            mid=low+f[k-1]-1;
            if(key<temp[mid]){
                //向数组的前面查找,即左查找
                high=mid-1;
                k--;
            }else if(key>temp[mid]){
                //向数组的后面查找,即右查找
                low=mid+1;
                k-=2;
            }else {
                if(mid<=high){
                    return mid;
                }else {
                    return high;
                }
            }

        }
        return -1;
    }

}
