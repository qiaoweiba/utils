package com.company.utils.sort_algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 * @data 四月 14 2017 23:02.
 */
public class RadixSort {

    public static void radixSort(int[] arr){
        if (arr == null || arr.length == 0){
            return;
        }
        int maxBit = getMaxBit(arr);

        for (int i=1;i<=maxBit;i++){
            List<LinkedList<Integer>> list = distribute(arr, i);//分配
            collecte(arr, list);//收集
        }

    }

    public static List<LinkedList<Integer>> distribute(int[] arr, int iBit) {
        List<LinkedList<Integer>> l = new ArrayList<LinkedList<Integer>>();
        for (int n = 0;n<10;n++){
            l.add(new LinkedList<Integer>());
        }
        for (int j=0;j<arr.length;j++){
            l.get(getNBit(arr[j], iBit)).add(arr[j]);
        }
        return l;
    }

    public static void collecte(int[] a,List<LinkedList<Integer>> list){
        int k=0;
        for (LinkedList<Integer> l:list){
            for (int ele:l){
                a[k++] = ele;
            }
        }
    }
    /**
     * 获取x的第n位，如果没有则为0
     * @param x
     * @param n
     * @return
     */
    public static int getNBit(int x,int n){
        String sx = x + "";
        if (sx.length()<n)
            return 0;
        else
            return sx.charAt(sx.length()-n )-'0';
    }
    /**
     * 获取最大位数
     * @param arr
     * @return
     */
    public static int getMaxBit(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int a:arr){
            int len = (a+"").length();//转化为字符串求长度
            max = max<len?len:max;
        }
        return max;
    }


    public static void swap(int[] arr, int i,int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }


    public static void main(String[] args) {

        int[] arr = {11, 95,43,21, 2,8,10, 5,0,21,13, 67, 83, 18,28,14,77,6,9,91, 62, 93, 4};
        System.out.println("原始数据为：");
        for (int a:arr){
            System.out.print(a+" ");
        }
        System.out.println();

        System.out.println("基数排序后输出为：");
        radixSort(arr);
        for (int a:arr){
            System.out.print(a+" ");
        }
    }
}
