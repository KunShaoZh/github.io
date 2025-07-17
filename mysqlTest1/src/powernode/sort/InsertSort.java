package powernode.sort;

import java.util.Arrays;

/**
 * 插入排序案例（适用于有负数数列）。
 * 注意与冒泡排序的区别，插入排序模型是如果内层循环未发生逆序交换，就可以结束当前循环，插入排序的算法模型与冒泡排序相似，内层循环逐渐递增。
 * 特点:当大部分元素都是有序数列时，效率较高较快。
 * 推荐使用位移法，位移法要比逆序交换法的效率高，速度快（10万+的数据量是2倍关系）。
 * 时间复杂度:O(n^2)。
 * 稳定排序算法。
 * */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr01 = {5, 3, 6, 4, 108,50, 2, -36, -138, 1, -23};
        insertSort01(arr01);
        System.out.println(Arrays.toString(arr01));
        int[] arr02 = {5, 3, 6, 4, 108,50, 2, -36, -138, 1, -23};
        insertSort02(arr02);
        System.out.println(Arrays.toString(arr02));
        int[] arr03 = {5, 3, 6, 4, 108,50, 2, -36, -138, 1, -23};
        insertSort03(arr03);
        System.out.println(Arrays.toString(arr03));
        int[] arr04 = {5, 3, 6, 4, 108,50, 2, -36, -138, 1, -23};
        insertSort04(arr04);
        System.out.println(Arrays.toString(arr04));
    }

    /**
     * 逆序交换法
     * 从左往右插入，从右往左比较
     * @param arr 待排序数组
     */
    public static void insertSort01(int [] arr) {
        int[] array = arr;
        //int temp;
        for (int i = 1; i < arr.length; i++) {
            /*
             * 元素比较的索引移动的方向与插入数据的索引移动方向要正好相反。这也是为什么冒泡排序每一轮只能确定一个最大值的位置。
             * */
            // 内层循环元素比较次数逐渐递增
            for (int j = i; j >= 1; j--) { //从复制的数组开始，从最右到左，依次比较排序
                if (array[j] < array[j-1]) {
                    int temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                } else {
                    break;// 因为i是从1开始的，所以元素的插入顺序是从左往右插入，比较的顺序是从右往左，所以j-1之前的元素已经排好了，如果当前array[j]大于array[j-1]，那就可以提前结束与插入数组元素的比较。
                }
            }
        }
    }

    /**
     * 逆序交换法
     * 从右往左插入，从左往右比较
     * @param arr 待排序数组
     */
    public static void insertSort02 (int[] arr) {
        System.out.println(arr.length);
        for (int i = arr.length - 2; i >= 0; i--) {
            for (int j = i; j < arr.length - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 位移法
     * @param arr 待排序数组
     */
    public static void insertSort03 (int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i]; // 待插入元素
            for (int j = i-1; j >= 0 ; j--) {
                if (arr[j] > temp) { // 新插入的元素和每个元素都比较一下
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                } else {
                    break;
                }
            }
        }
    }

    public static void insertSort04 (int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            for (int j = i; j >= 1 ; j--) {
                if (arr[j-1] < temp) {
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                } else {
                    break;
                }
            }
        }
    }
}
