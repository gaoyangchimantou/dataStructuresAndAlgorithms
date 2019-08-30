package com.bfsu.sort;

import java.util.Arrays;

//基数排序
public class RadixSort {


    public static void main(String[] args) {
        int arr[] = { 53, 3, 542, 748, 14, 214};

        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void radixSort(int[] arr){

        //先创建10个桶,每个桶的大小(即长度)为被排序数组的长度的大小
        int[][] bucket=new int[10][arr.length];
        //而需要被循环的次数,就是数组中最大的数的   位数.
        //先默认最大的数 为数组的第一个数
        int maxNum=arr[0];
        for (int i=1;i<arr.length;i++){
            if(maxNum<arr[i]){
                maxNum=arr[i];
            }
        }
        //创建一个数组,记录各个桶的下标
        int[] bucketElementCount=new int[10];
        //求出最的数的位数
        int weiShu=(maxNum+"").length();
        int temp=0;
        for (int i=0 ,n=1;i<weiShu;i++,n*=10){
           for (int j=0;j<arr.length;j++){
            //依次取出各个位数的值,先取出个位
               temp=arr[j] /n % 10;
               bucket[temp][bucketElementCount[temp]]=arr[j];
               bucketElementCount[temp]++;
           }
           //全部放完之后,在依次取出,放回原数组arr中
            int index=0;
            for(int x=0;x<10;x++){
                    for (int w = 0; w < bucketElementCount[x]; w++) {
                        arr[index] = bucket[x][w];
                        index++;
                    }
                bucketElementCount[x]=0;
            }
        }
    }

}
