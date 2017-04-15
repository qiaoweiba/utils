package com.company.utils.sort_algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 * @data 四月 14 2017 23:02.
 */
public class BucketSort {

    public static void bucketSort(int[] arr){
        if (arr == null || arr.length == 0){
            return;
        }
        int bucketNums = 10;//这里默认为10，规定待排数[0,100)
        List<LinkedList<Integer>> buckets = new ArrayList<LinkedList<Integer>>();//桶的索引
        for (int i=0;i<bucketNums;i++){
            buckets.add(new LinkedList<Integer>());
        }

        //划分桶
        for (int i=0;i<arr.length;i++){
            buckets.get(arr[i] / bucketNums).add(arr[i]);
        }

        //对每个桶进行排序
        for(int i=0;i<bucketNums;i++){
            if (!buckets.get(i).isEmpty()){
                Collections.sort(buckets.get(i));//对每个桶进行快排
            }
        }

        //还原排好序的数组
        int k=0;
        for (List<Integer> bucket:buckets){
            for (int a:bucket){
                arr[k++] = a;
            }
        }
    }





    public static void main(String[] args) {

        int[] arr = {11, 95,43,21, 2,8,10, 5,0,21,13, 67, 83, 18,28,14,77,6,9,91, 62, 93, 4};
        System.out.println("原始数据为：");
        for (int a:arr){
            System.out.print(a+" ");
        }
        System.out.println();

        System.out.println("桶排序后输出为：");
        bucketSort(arr);
        for (int a:arr){
            System.out.print(a+" ");
        }
    }
}
