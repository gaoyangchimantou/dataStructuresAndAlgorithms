package com.bfsu.search;

public class InsertValueSearch {

    public static void main(String[] args) {
        int arr[] = { 1, 8, 10, 89,1000,1000,1000, 1234 };
        int i = insertValueSearch(arr, 0, arr.length - 1, 1234);
        System.out.println(i);
    }



    public static int insertValueSearch(int[] arr, int left, int right, int findVal){
        System.out.println("调用.......");
        if(left>right||findVal<arr[left]||findVal>arr[right]){
            return -1;


        }

        // 求出mid, 自适应
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);

        int midNum=arr[mid];

        if(findVal<arr[mid]){
            //zuo
            return insertValueSearch(arr,left,mid-1,findVal);
        }else if(findVal>arr[mid]){
            return  insertValueSearch(arr,mid+1,right,findVal);
        }else {
            return mid;
        }

    }
}
