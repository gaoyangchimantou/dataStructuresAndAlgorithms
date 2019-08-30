package com.bfsu.sort;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr={6,1,2,7,9,3,4,5,10,8};
    }

    public static void myQuickSort(int[] arr,int left,int right){

        int l=left;
        int r=right;
        int pivot=arr[left+right/2];//基准   中轴值
        //while循环额目的是将  比pivot的值大的放到pivot的右边,比pivot值小的放到pivot的左边
        while (l<r){
            //在pivot的左边一直找,直到找到比pivot值大的值时  退出
            while(arr[l]<pivot){
                l++;
            }
            //在puvot的右边一直找,直到找到比pivot的小的值时,退出
            while (arr[r]>pivot){
                r--;
            }

            //然后交换两个值
            int temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
        }

        //这两个步骤只是优化  减少步骤,不写也没错

        //如果交换完后，发现这个arr[l] == pivot值 相等 r--， 前移
        if(arr[l] == pivot) {
            r -= 1;
        }
        //如果交换完后，发现这个arr[r] == pivot值 相等 l++， 后移
        if(arr[r] == pivot) {
            l += 1;
        }
    }

}
