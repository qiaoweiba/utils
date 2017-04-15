package com.company.utils.sort_algorithms;

/**
 * @author Administrator
 * @data 四月 14 2017 16:11.
 */
public class QuickSort {
    private static int[] aux;

    public static void quickSort(int[] arr){
        quickSort(arr,0,arr.length-1);
    }

    public static void quickSort(int[] a, int lo, int hi) {
        if (lo>=hi) return;
        int j = partition(a,lo,hi);
        quickSort(a,lo,j-1);
        quickSort(a,j+1,hi);
    }

    public static int partition(int[] a,int lo,int hi){
        int pivot = a[lo];
        int i = lo;
        int j = hi+1;
        while (true){
            while (a[++i]<pivot) if (i==hi) break;
            while (a[--j]>pivot) if (j==lo) break;
            if (i>=j) break;
            swap(a, i, j);
        }
        swap(a,lo,j);
        return j;

    }

    public static void swap(int[] arr, int i,int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }




    public static void main(String[] args) {

        int[] arr = {11, 5, 2,8,10, 5, 14,23,30,7,57, 15,3, 7,6,9,1, 2, 3, 4};
        System.out.println("原始数据为：");
        for (int a:arr){
            System.out.print(a+" ");
        }
        System.out.println();
        System.out.println("快速排序后输出为：");
        quickSort(arr);
        for (int a:arr){
            System.out.print(a+" ");
        }
    }
}
