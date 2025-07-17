package powernode.sort;

import java.util.Arrays;

/**
 * 希尔排序案例（采用分治思想，分组表达式明确，先初始化增量值，对每组元素进行排序，再缩小增量直至增量为1，适用于有负数序列）。
 * 希尔排序插入排序的改进版本，插入排序是希尔排序当增量缩小为1时的情况，增量的值就是确定把数组元素一共分成几组，也叫做步长gap。当刚开始元素很无
 * 序的时候，增量值最大，步长最大，而每组插入排序的元素个数很少，速度很快；当元素基本有序了，步长很小，插入排序对于有序的序列效率很高。
 * 希尔排序比普通插入排序的速度快将近100倍（10万+的数据量）。
 * 时间复杂度:
 * 不稳定排序算法。
 * */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr01 = {5, 3, 6, 4, 108,50, 2, -36, -138, 1, -23};
        group(arr01);
        System.out.println(Arrays.toString(arr01));
        int[] arr02 = {5, 3, 6, 4, 108,50, 2, -36, -138, 1, -23};
        shellSort02(arr02);
        System.out.println(Arrays.toString(arr02));
        int[] arr03 = {6, 2, 5, 4, 3, 1};
        group(arr03);
        System.out.println(Arrays.toString(arr03));

    }

    public static void group (int[] arr) {
        int group = arr.length;
        while (group > 1) {
            group /= 2;
            shellSort01(arr, group);
        }

    }

    /**
     * 逆序交换法
     * @param arr 待排序数组
     * @param group 增量分组
     */
    public static void shellSort01 (int[] arr, int group) {
        if (arr == null) {
            return;
        }
        for (int i = group; i < arr.length; i++) {
            for (int j = i ; j >= group ; j-=group) {
                if (arr[j] < arr[j-group]) {
                    int temp = arr[j-group];
                    arr[j-group] = arr[j];
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
    public static void shellSort02 (int[] arr) {
        if (arr == null) {
            return;
        }
        for (int group = arr.length / 2; group > 0; group /= 2) {
            for (int i = group; i < arr.length; i++) {
                int tmp = arr[i]; // 待插入元素
                for (int j = i - group; j >= 0; j -= group) {
                    if (arr[j] > tmp) {
                        arr[j + group] = arr[j];
                        arr[j] = tmp;
                    } else {
                        break;
                    }
                }
            }
        }
    }
}
