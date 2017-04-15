package com.company.utils.sort_algorithms;

/**
 * @author Administrator
 * @data 四月 14 2017 15:33.
 */
//堆排序是借助堆来实现的选择排序，思想同简单的选择排序，以下以大顶堆为例。
// 注意：如果想升序排序就使用大顶堆，反之使用小顶堆。
// 原因是堆顶元素需要交换到序列尾部。

public class HeapSort {

    public static void heapSort(int[] arr){
        if (arr == null || arr.length == 0){
            return;
        }
        //建立大顶堆
        for (int i=arr.length/2;i>=0;i--){
            heapAdjust(arr, i, arr.length - 1);
        }
        for (int i=arr.length-1;i>=0;i--){
            swap(arr,0,i);
            heapAdjust(arr,0,i-1);
        }
    }

    /**
     * 堆调整，除了start之外，start~end均满足打定对的定义。
     * @param arr
     * @param start
     * @param end
     */
    public static void heapAdjust(int[] arr, int start, int end) {
        for (int i=2*start+1;i<=end;i=2*start+1){
            if (i<end&&arr[i]<arr[i+1]) i++;
            if (arr[start]>=arr[i]) break;//已经为大顶堆，=保持稳定性
            swap(arr,start,i);
            start = i;//下一轮筛选
        }
    }

    public static void swap(int[] arr, int i,int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }


    public static void main(String[] args) {

        int[] arr = {11, -5,43,21, 2,8,10, 5,0,21,13, 7, 3, 18,28,14,7,6,9,1, 2, 3, 4};
        System.out.println("原始数据为：");
        for (int a:arr){
            System.out.print(a+" ");
        }
        System.out.println();

        System.out.println("堆排序后输出为：");
        heapSort(arr);
        for (int a:arr){
            System.out.print(a+" ");
        }
    }
}
