package com.bfsu.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearch {


    public static void main(String[] args) {
        int arr[] = { 1, 8, 10, 89,1000,1000,1000, 1234 };
       /* int i = binarySearch(arr, 0, arr.length - 1, 7);
        System.out.println(i);*/
        List<Integer> integers = binarySearch2(arr, 0, arr.length - 1, 1000);
        System.out.println(integers);

    }

    /**
     *被查找的数组是有序的
     * @param arr
     * @param left 数组左下标
     * @param right 数组右下标
     * @param finalNum 被查找的数
     * @return 返回-1,代表没找到
     */
    public static int binarySearch(int[] arr,int left,int right,int finalNum) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midNum = arr[mid];
        if (finalNum > midNum) {
            //大于的话,递归右查找
            return binarySearch(arr, mid + 1, right, finalNum);
        } else if (finalNum < midNum) {
            //目标值小于中间值的话 递归做查找
            return binarySearch(arr, left, mid - 1, finalNum);
        } else {
            return mid;//如果找到返回  该值的数组下标
        }
    }


    //如果一个数组中有多个重复的值,我将其全部返回,返回到一个数组中

    public static List<Integer> binarySearch2(int[] arr, int left, int right, int finalNum) {

            if (left > right) {
                return new ArrayList<Integer>();
            }
            int mid = (left + right) / 2;
            int midNum = arr[mid];
            if (finalNum > midNum) {
                //大于的话,递归右查找
                return binarySearch2(arr, mid + 1, right, finalNum);
            } else if (finalNum < midNum) {
                //目标值小于中间值的话 递归做查找
                return binarySearch2(arr, left, mid - 1, finalNum);
            } else {
               // return mid;//如果找到返回  该值的数组下标
                //如果找到,再在该值的左右查找 (因为该数组是有序的)
                List<Integer> list=new ArrayList<Integer>();
                int temp=mid-1;
                while (temp>0&&arr[temp]==finalNum){
                    list.add(temp);
                    temp-=1;
                }
                list.add(mid);
                temp=mid+1;
                while (temp<arr.length-1&&arr[temp]==finalNum){
                    list.add(temp);
                    temp+=1;
                }
                return list;
            }
    }



}
