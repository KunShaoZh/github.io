package powernode.sort;

import java.util.Arrays;
/**
 * 选择排序案例（适用于有负数的序列），选择排序不稳定，原因是相等元素的次序在排序后不能够保持在排序前的相对次序，也就是说排序如果涉及到不相邻两元素
 * 发生位置交换，则就是不稳定排序。
 * 与插入排序算法的思想正好相反。插入排序是与已插入元素进行比较再确定是否要将待插入元素前移，选择排序是比较未插入元素之后再与未插入元素的首位进行
 * 位置交换。
 * 时间复杂度:O(n^2)
 * 不稳定排序算法。
 * */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr01 = {5, 3, 6, 4, 108,50, 2, -36, -138, 1, -23};
        selectSort02(arr01);
        System.out.println(Arrays.toString(arr01));
    }

    public static void selectSort01(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int index = i;
            int min = arr[index];
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < min) {
                    //更新最小值
                    min = arr[j];
                    index = j;
                }
            }
            //将最小值放进 arr[i]
            if (i != index) {
                arr[index] = arr[i];
                arr[i] = min;
            }
        }
    }

    public static void selectSort02 (int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            int min = arr[minIndex];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                //arr[minIndex] = arr[i];
                //arr[i] = min;
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
}
