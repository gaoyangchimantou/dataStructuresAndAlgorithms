package com.bfsu.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        int arr[] = { 8, 4, 5, 7, 1, 3, 6, 2 };
        int temp[] = new int[arr.length]; //归并排序需要一个额外空间
        mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println("sort.......=" + Arrays.toString(arr));
    }
    //分+合方法
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if(left < right) {
            int mid = (left + right) / 2; //中间索引
            //向左递归进行分解
            mergeSort(arr, left, mid, temp);
            //向右递归进行分解
            mergeSort(arr, mid + 1, right, temp);
            //合并
            merge(arr, left, mid, right, temp);

        }
    }


    //合并
    public static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i=left;//初始化,待合并的数组左侧坐标
        int j=mid+1;//初始化,待合并的数组的右侧坐标
        int t=0;//将要合并到的数组的下标
        //1. 先把左右两边(有序的数组)按照规则填充到temp中
        //直到左右两边的有序序列  有一边处理完毕
        while(i<=mid&&j<=right){
            //当待合并的两个数组的下标都小于等于数组的最后一个坐标时
            if(arr[i]<=arr[j]){
                temp[t]=arr[i];
                i++;
                t++;
            }else{
                temp[t]=arr[j];
                j++;
                t++;
            }
        }

        //2. 将剩余一边的有序序列一次填充到temp中
        while(i<=mid){
            //这说明,这个数组还没到最后
            //就将这个数组的最后一次放到temp数组中
            temp[t]=arr[i];
            i++;
            t++;
        }
        while(j<=right){
            //这说明,这个数组还没到最后
            //就将这个数组的最后一次放到temp数组中
            temp[t]=arr[j];
            j++;
            t++;
        }
        System.out.println(Arrays.toString(temp));
        //3.将temp中的数组拷贝到arr中,注意 不是每次都全部拷贝
        t=0;
        for (int x=left;x<=right;x++){
            arr[x]=temp[t];
            t++;
        }
       /* t = 0;
        int tempLeft = left; //
        //第一次合并 tempLeft = 0 , right = 1 //  tempLeft = 2  right = 3 // tL=0 ri=3
        //最后一次 tempLeft = 0  right = 7
        while(tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }*/


    }



}
