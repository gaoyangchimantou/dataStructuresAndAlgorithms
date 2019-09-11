package com.bfsu.tree;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {

        int arr[] = {4, 6, 8, 5, 9,3,2,2,3,10,15};
        //adjustHeap(arr,1,arr.length);
        heapSort(arr);
        System.out.println(Arrays.toString(arr));


    }


//编写一个堆排序的方法
    public static void heapSort(int[] arr){
        int temp=0;
      //  System.out.println("堆排序");
        for (int i =arr.length/2-1; i >=0 ; i--) {
            adjustHeap(arr,i,arr.length);
        }
        //开始交换,交换之后继续循环
        for (int i = arr.length-1; i >=0 ; i--) {
            temp=arr[i];
            arr[i]=arr[0];
            arr[0]=temp;
            adjustHeap(arr,0,i);

        }

    }

    //将一个数组(二叉树)调整成大顶堆
    /**
     * 功能:完成将以I 对应的非叶子节点的树  调节成大顶堆
     * @param arr
     * @param i 表示非叶子节点在数组中的索引
     * @param length 数组的长度
     */
    public static void adjustHeap(int[] arr,int i,int length){
        int temp =arr[i];//先取出当前的值,保存在临时变量中
        for (int k = 2 * i + 1; k <length; k=2 * k + 1) {
            if(k<length-1&&arr[k]<arr[k+1]){
                //说明左子节点小于右子节点
                k++;
            }
            if(temp<arr[k]){
                arr[i]=arr[k];
                i=k;
            }else {
                break;
            }

        }
        arr[i]=temp;
    }

}
