package com.bfsu.sort;

import java.util.Arrays;

public class SelectSort {


    public static void main(String[] args) {

        int [] arr = {101, 34, 119, 1, -1, 90, 123};



            /*for(int i=0;i<arr.length;i++){
                int minIndex=i;
                int minEle=arr[minIndex];
              for (int j=i+1;j<arr.length;j++){
                  if(minEle>arr[j]){
                      minIndex=j;
                      minEle=arr[minIndex];
                  }
              }
              //arr[i]=minEle;
              arr[minIndex]=arr[i];
              arr[i]=minEle;
          }

        System.out.println(Arrays.toString(arr));*/
        for(int i=0;i<arr.length-1;i++){
            int minIndex=i;
            int minEle=arr[minIndex];
            for (int j=i+1;j<arr.length;j++){
                if(minEle>arr[j]){
                    minIndex=j;
                    minEle=arr[minIndex];
                }
            }
            //arr[i]=minEle;
            arr[minIndex]=arr[i];
            arr[i]=minEle;
        }

        System.out.println(Arrays.toString(arr));


    }


}
