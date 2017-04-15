package com.company.utils.sort_algorithms;

/**
 * @author Administrator
 * @data 四月 14 2017 15:51.
 */
public class SelectSort {

    public static void selectionSort(int[] arr){
        if (arr == null||arr.length==0){
            return;
        }
        for (int i=0;i<arr.length;i++){
            int min = i ;
            for (int j=i+1;j<arr.length;j++){
                min = arr[min]<arr[j]?min:j;
            }
            if (min!=i) swap(arr, i, min);
        }
    }
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        int[] arr = {11, 5, 2,8,10, 5, 7, 15,3, 7,6,9,1, 2, 3, 4};
        System.out.println("原始数据为：");
        for (int a:arr){
            System.out.print(a+" ");
        }
        System.out.println();
        System.out.println("选择排序后输出为：");
        selectionSort(arr);
        for (int a:arr){
            System.out.print(a+" ");
        }
    }
}
