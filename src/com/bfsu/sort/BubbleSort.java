package com.bfsu.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        /*int arr[] = {3, 9, -1, 10, 20};*/
        int arr[] = {3, 9, -1, 10, -2};

        boolean flag=false;
        for (int i=0;i<arr.length-1;i++){

            for (int j=0;j<arr.length-1-i;j++){
                int temp=0;
                if(arr[j]>arr[j+1]){
                    flag=true;
                   temp= arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
            if(!flag){
                break;
            }else{
                flag=false;
            }
            System.out.println(Arrays.toString(arr));
        }
    }


}
