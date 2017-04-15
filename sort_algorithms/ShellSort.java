package com.company.utils.sort_algorithms;

/**
 * @author Administrator
 * @data 四月 14 2017 16:11.
 */
public class ShellSort {
    private static int[] aux;

    public static void shellSort(int[] arr){
        if (arr == null||arr.length == 0){
            return;
        }
        int N = arr.length;
        int h = 1;
        while (h<N/3) h = 3*h+1;//1,4,13,40,121,364
        while (h>=1){
            for (int i = h;i<N;i++){
                for (int j=i;j>=h&&arr[j]<arr[j-h];j -= h){
                    swap(arr,j,j-h);
                }
            }
            h /=3;
        }

    }


    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {

        int[] arr = {11, 5, 2,8,10, 5, 14,23,30,7, 18,32,15,3, 7,6,9,1, 2, 3, 4};
        System.out.println("原始数据为：");
        for (int a:arr){
            System.out.print(a+" ");
        }
        System.out.println();
        System.out.println("希尔排序后输出为：");
        shellSort(arr);
        for (int a:arr){
            System.out.print(a+" ");
        }
    }
}
