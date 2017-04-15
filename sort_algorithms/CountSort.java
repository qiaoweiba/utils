package com.company.utils.sort_algorithms;

import java.util.Arrays;

/**
 * @author Administrator
 * @data 四月 14 2017 23:02.
 */
public class CountSort {
    
    public static void countSort(int[] arr){
        if (arr == null || arr.length == 0){
            return;
        }
        int max = max(arr);
        int[] count = new int[max+1];
        Arrays.fill(count,0);
        for (int i=0;i<arr.length;i++){
            count[arr[i]]++;
        }
        int k=0;
        for (int i = 0;i<count.length;i++){
            for (int j = 0; j < count[i]; j++) arr[k++] = i;
        }
    }


    public static int max(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int a:arr){
            max = a>max?a:max;
        }
        return max;
    }



    public static void main(String[] args) {

        int[] arr = {11, 5,43,21, 2,8,10, 5,0,21,13, 27,7, 3, 18,28,14,7,12,6,9,1, 2, 3, 4};
        System.out.println("原始数据为：");
        for (int a:arr){
            System.out.print(a+" ");
        }
        System.out.println();

        System.out.println("计数排序后输出为：");
        countSort(arr);
        for (int a:arr){
            System.out.print(a+" ");
        }
    }
}
