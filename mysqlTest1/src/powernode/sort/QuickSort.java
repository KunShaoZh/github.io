package powernode.sort;

import java.util.Arrays;
/**
 * 快速排序案例（采用分治法，分组边界随机，与每一轮的基准元素有关，所以采用递归调用，适用于有负数数列）。
 * 仅通过逆序交换就可以实现排序的算法，通过基准元素控制需要逆序交换的步长，是冒泡排序的改进版。
 * 时间复杂度:O(n^2)。
 * 不稳定排序算法。
 * */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 3, 50, 108, 2, 1, -36, -23};
        partition01(arr, 0, 9);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 采用分治思想，通过递归先排序，再根据基准元素分组再排序
     * @param array 待排序数组
     * @param startIndex 定义左指针
     * @param endIndex 定义右指针
     */
    public static void separate(int[] array, int startIndex, int endIndex) {
        //递归结束条件为 startIndex 大于或等于 endIndex
        if (startIndex >= endIndex) {
            return;
        }
        // 得到基准元素的索引位置
        int l = partition(array, startIndex, endIndex);
        // 根据基准元素把数组分成两部分进行递归分组
        separate(array, startIndex, l-1);
        separate(array, l+1, endIndex);
    }

    /**
     * 分治法（使用双边循环），根据基准元素对序列进行排序
     * @param array 待排序数组
     * @param startIndex 起始下标
     * @param endIndex 结束下标
     * @return 重合位置指针索引
     */
    public static int partition (int[] array, int startIndex, int endIndex) {
        int p = array[startIndex]; // 基准元素（可随机取元素）,如果基准元素从最左边开始，先移动右指针；反之先移动左指针
        int l = startIndex;// 左指针
        int r = endIndex;// 右指针
        while (l != r) {
            //控制右指针向左移动，找到小于基准元素的那个数
            while ((l<r) && (array[r] > p)) {
                r--;
            }
            // 控制左指针向右移动，找到大于基准元素的那个数
            while ((l<r) && (array[l] <= p)) {
                l++;
            }
            // 交换l指正和r指正所指的元素
            if (l < r) {
                int temp = array[l];
                array [l] = array[r];
                array [r] = temp;
            }
        }
        //交换基准元素和重合点的元素
        array[startIndex] = array[l];
        array[l] = p;
        //partition(array, startIndex, l-1);
        //partition(array, l, endIndex);
        return l;
    }

    /**
     * 分治法（使用双边循环）
     * @param array 待排序数组
     * @param startIndex 起始下标
     * @param endIndex 结束下标
     * @return
     */
    public static void partition01 (int [] array, int startIndex, int endIndex) {
        //递归结束条件为 startIndex 大于或等于 endIndex
        if (startIndex >= endIndex) {
            return;
        }
        int p = array[startIndex]; // 基准元素（可随机取元素),如果基准元素从最左边开始，先移动右指针；反之先移动左指针
        int l = startIndex;// 左指针
        int r = endIndex;// 右指针
        while (l != r) {
            //控制右指针向左移动，找到小于基准元素的那个数
            while ((l<r) && (array[r] > p)) {
                r--;
            }
            // 控制左指针向右移动，找到大于基准元素的那个数
            while ((l<r) && (array[l] <= p)) {
                l++;
            }
            // 交换l指针和r指针所指的元素
            if (l < r) {
                int temp = array[l];
                array [l] = array[r];
                array [r] = temp;
            }
        }
        //交换基准元素和重合点的元素
        array[startIndex] = array[l];
        array[l] = p;
        // 根据基准元素把数组分成两部分进行递归排序
        /*左右指针重合位置元素与基准元素进行逆序交换后，如果是相等的，那么会一直递归下去，所以左边序列的末位边界应该是左右指针重合位置索引-1，
            右边序列起始是+1
         */
        partition01(array, startIndex, l-1);
        partition01(array, l+1, endIndex);

    }
}
