package com.company.utils.sort_algorithms;

/**
 * @author Administrator
 * @data 四月 14 2017 15:33.
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr){
        if (arr == null || arr.length == 0){
            return;
        }
        for (int i=0;i<arr.length-1;i++){
            for (int j=arr.length-1;j>i;j--){
                if (arr[j]<arr[j-1]){
                    swap(arr, j,j-1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i,int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }


    public static void main(String[] args) {

        int[] arr = {11, 5, 2,8,10, 5, 7, 3, 7,6,9,1, 2, 3, 4};
        System.out.println("原始数据为：");
        for (int a:arr){
            System.out.print(a+" ");
        }
        System.out.println();

        System.out.println("冒泡排序后输出为：");
        bubbleSort(arr);
        for (int a:arr){
            System.out.print(a+" ");
        }
    }
}
