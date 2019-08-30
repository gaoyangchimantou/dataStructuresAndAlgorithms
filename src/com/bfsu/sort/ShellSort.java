package com.bfsu.sort;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        int [] arr = {8,9,1,7,2,3,5,4,6,0};
        /*shellSort(arr);*/
        shellSort2(arr);
    }

    /*public static void shellSort(int[] arr){
        //假设 数组长度为10  而步数先按5来算
        int temp=0;
        for(int i=5;i<arr.length;i++){
            for (int j=i-5;j>=0;j-=5){
                if(arr[j]>arr[j+5]){
                    temp=arr[j];
                    arr[j]=arr[j+5];
                    arr[j+5]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }*/
    public static void shellSort(int[] arr){
        //假设 数组长度为10  而步数先按5来算
        for(int gap=arr.length/2;gap>=1;gap/=2){
        int temp=0;
        for(int i=gap;i<arr.length;i++){
            for (int j=i-gap;j>=0;j-=gap){
                if(arr[j]>arr[j+gap]){
                    temp=arr[j];
                    arr[j]=arr[j+gap];
                    arr[j+gap]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    }

    /**
     * 运用了插入排序法
     *
     * @param arr
     */
    //优化---->采用插入法来替换 直接的替换法
    public static void shellSort2(int[] arr){

        for (int gap=arr.length/2;gap>=1;gap/=2){
                for (int i=gap;i<arr.length;i++) {
                    int j=i;//将要插入的元素的下标
                    int temp=arr[j];//将要被插入的数
                    if(arr[j]<arr[j-gap]){
                        //如果将要插入的数,小于他前面(步长个单位的元素)的数时,(因为前面的数组已经是有序的了,最后面的那个就一定是最大的那个)
                        //就需要插入
                        while (j-gap>=0&&temp<arr[j-gap]){
                            //移动
                            arr[j]=arr[j-gap];
                            j-=gap;
                        }
                        arr[j]=temp;
                    }
                }
        }
        System.out.println(Arrays.toString(arr));

    }




}
