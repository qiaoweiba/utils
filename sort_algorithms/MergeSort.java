package com.company.utils.sort_algorithms;

/**
 * @author Administrator
 * @data 四月 14 2017 16:11.
 */
public class MergeSort {
    private static int[] aux;

    public static void mergeSort(int[] arr){

        aux = new int[arr.length];//一次性分配空间
        mergeSort(arr,0,arr.length-1);
    }

    public static void mergeSort(int[] arr, int lo, int hi) {
        if (lo>=hi) return;
        int mid = lo + (hi - lo) / 2;
        mergeSort(arr,lo,mid);
        mergeSort(arr,mid+1,hi);
        merge(arr, lo, mid, hi);
    }

    public static void merge(int[] arr, int lo, int mid, int hi) {
        int i = lo;
        int j = mid+1;
        for (int k = lo;k<=hi;k++){
            aux[k] = arr[k];
        }
        for (int k=lo;k<=hi;k++){
            if (i>mid) arr[k] = aux[j++];
            else if (j>hi) arr[k] = aux[i++];
            else {
                arr[k] = aux[i] < aux[j] ? aux[i++] : aux[j++];
            }
        }

    }

//    public static void merge(int[] arr, int lo, int mid, int hi) {
//        int[] aux = new int[hi - lo + 1];//归并所需的辅助数组
//        int i = lo;
//        int j = mid+1;
//        int k = 0;
//        while (k<aux.length){
//            if (i>mid) aux[k++] = arr[j++];
//            else if (j>hi) aux[k++] = arr[i++];
//            else {
//                aux[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
//            }
//        }
//        for (int kk = 0;kk<aux.length;kk++){
//            arr[lo + kk] = aux[kk];
//        }
//    }

    public static void main(String[] args) {

        int[] arr = {11, 5, 2,8,10, 5, 14,23,30,7, 15,3, 7,6,9,1, 2, 3, 4};
        System.out.println("原始数据为：");
        for (int a:arr){
            System.out.print(a+" ");
        }
        System.out.println();
        System.out.println("归并排序后输出为：");
        mergeSort(arr);
        for (int a:arr){
            System.out.print(a+" ");
        }
    }
}
