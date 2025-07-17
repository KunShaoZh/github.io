package powernode.sort;
/**
 * 冒泡排序案例（适用于有负数的数列）。
 * 仅通过逆序交换就可以实现排序，冒泡排序是如果是内层循环未发现逆序交换，则可以结束整个外层循环，内层循环逐渐递减。
 * 时间复杂度:O(n^2)。
 * 稳定排序算法。
 * */
public class BubblingSort {
    public static void main(String[] args) {
        int[] array = {4, 5, 6, 3, 50, 108, 2, 1, -36};
        sort04(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static int[] sort01 (int [] array) {

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array [j + 1]) {
                    int a = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = a;
                }
            }
        }
        return array;
    }

    public static int[] sort02 (int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = false;// 检查在每一轮的比较中是否发生过逆序交换，如果没有发生，则剩余轮数都不需要排序了
            // 内层循环元素比较次数逐渐递减
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array [j + 1]) {
                    int a = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = a;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        return array;
    }

    public static void sort03 (int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = false;// 检查在每一轮的比较中是否发生过逆序交换，如果没有发生，则剩余轮数都不需要排序了
            // 内层循环元素比较次数逐渐递减
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array [j + 1]) {
                    int a = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = a;
                    flag = true;
                }
            }
            if (!flag) {
                return;
            }
        }
    }

    public static int[] sort04 (int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = false;// 检查在每一轮的比较中是否发生过逆序交换，如果没有发生，则剩余轮数都不需要排序了
            // 内层循环元素比较次数逐渐递减
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array [j + 1]) {
                    int a = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = a;
                    flag = true;
                }
            }
            if (!flag) {
                return array;
            }
        }
        return array;
    }

}
