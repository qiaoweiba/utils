package com.company.utils.sort_algorithms;

/**
 * @author Administrator
 * @data 四月 14 2017 16:11.
 */
public class InsertSort {
    public static void insertionSort(int[] arr){
        if(arr == null||arr.length == 0){
            return;
        }
        for (int i=1;i<arr.length;i++){
            for (int j=i;j>0;j--){
                if (arr[j]<arr[j-1]) swap(arr, j, j - 1);
            }
        }

    }
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {

        int[] arr = {11, 5, 2,8,10, 5, 30,7, 15,3, 7,6,9,1, 2, 3, 4};
        System.out.println("原始数据为：");
        for (int a:arr){
            System.out.print(a+" ");
        }
        System.out.println();
        System.out.println("插入排序后输出为：");
        insertionSort(arr);
        for (int a:arr){
            System.out.print(a+" ");
        }
    }
}
