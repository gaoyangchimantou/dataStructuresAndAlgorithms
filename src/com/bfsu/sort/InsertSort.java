package com.bfsu.sort;

import java.util.Arrays;

public class InsertSort {


    public static void main(String[] args) {

        int[] arr={2,6,3,9,4};

        insertSort(arr);

    }

    public static void  insertSort(int[] arr){
            for (int i=1;i<arr.length;i++){
                int inserValue=arr[i];//将要带插入的数
                int insertIndex=i-1;//将要待插入的数的前面的数
                while (insertIndex>=0&&arr[insertIndex]>inserValue){
                    arr[insertIndex+1]=arr[insertIndex];
                    insertIndex--;
                }
                /*arr[insertIndex+1]=inserValue;*/
                if(insertIndex + 1 != i) {
                    arr[insertIndex + 1] = inserValue;
                }
            }
        System.out.println(Arrays.toString(arr));

    }

}
