package powernode.sort;


import java.util.Arrays;

/**
 * 归并排序案例（采用分治思想，通过二分法确定每一次分解mid，采用递归调用，适用于有负数序列）。
 * 归并排序与快速排序思想十分相似，都是采用了分治思想，都使用了递归调用，都定义了双指针，但是区别在于：1.快速排序是先排序，再根据基准元素进行分组
 * 再排序，先排序后分解，边排序边分解；归并排序是先分组，分解到最后再进行排序，最后合并序列，先分解后排序。2.快速排序使用的是逆序交换法，不占用额
 * 外存储空间；归并排序每次要对两组序列进行排序合并，使用了空间换时间的方式（原因是分组采用的是二分法，已知left、right、mid），占用了额外存储空
 * 间。3.快速排序是根据上一轮的基准元素进行分组，归并排序是通过二分法进行分组。
 * 时间复杂度:(nlogn)。
 * 稳定排序算法（在归并时采用空间换时间的方式）。
 * */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr01 = {5, 3, 6, 4, 108,50, 2, -36, -138, 1, -23};
        int[] temp01 = new int[arr01.length];
        separate(arr01, 0, arr01.length - 1, temp01);
        System.out.println(Arrays.toString(arr01));
        int[] arr02 = {5, 3, 6, 4, 108,50, 2, -36, -138, 1, -23};
        int[] temp02 = new int[arr02.length];
        mSort03(arr02, 0, arr02.length-1, temp02);
        System.out.println(Arrays.toString(arr02));

    }

    /**
     * 采用分治思想，通过递归向下分解，最后再排序合并
     * @param arr 待排序数组
     * @param left 定义左指针
     * @param right 定义右指针
     * @param temp 临时数组
     */
    public static void separate (int[] arr, int left, int right, int[] temp) {
        if (left < right) { //递归结束条件
            int mid = (left+right)/2;
            // 向左进行分解
            separate(arr, left, mid, temp);
            // 向右进行分解
            separate(arr, mid + 1, right, temp);
            // 合并排序
            mSort02(arr, left, right, mid, temp);
        }
    }

    /**
     * 归并排序，对每组序列进行排序合并
     * @param arr 待排序数组
     * @param left 左边序列起始下标
     * @param right 右边序列结束下标
     * @param mid 右边序列起始下标
     * @param temp 临时数组
     */
    public static void mSort01 (int[] arr, int left, int right, int mid, int[] temp) {
        int i = left; //左边序列的初始索引值
        int j = mid + 1; // 右边序列的初始索引值
        int t = 0; // 临时数组temp的初始索引值
        /*
         * 先把左右两边的数据按照有序序列方式填充到 temp 数组中
         * 直至左右两边的有序序列，有一边处理完毕为止
         */
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) { //使用等于号保证序列稳定性
                temp[t] = arr[i];
                t++;
                i++;
            } else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }
        // 将左边有序序列剩余元素平移到temp数组中
        while (i <= mid) {
            temp[t] = arr[i];
            t++;
            i++;
        }
        // 将右边有序数列剩余元素平移到temp数组中
        while (j <= right) {
            temp[t] = arr[j];
            t++;
            j++;
        }
        // 将temp数组中的元素拷贝到aar数组中，放入位置从arr[left]开始，到arr[right]结束，拷贝位置从temp[0]开始，到temp[t-1]结束
        int tempIndex = left;
        t = 0;
        while (tempIndex <= right) {
            arr[tempIndex] = temp[t];
            t++;
            tempIndex++;
        }
    }

    /**
     * 归并排序，对每组序列进行排序合并
     * @param arr 待排序数组
     * @param left 左边序列起始下标
     * @param right 右边序列结束下标
     * @param mid 右边序列起始下标
     * @param temp 临时数组
     */
    public static void mSort02 (int[] arr, int left, int right, int mid, int[] temp) {
        int i = left; //左边序列的初始索引值
        int j = mid + 1; // 右边序列的初始索引值
        int t = 0; // 临时数组temp的初始索引值
        /*
         * 先把左右两边的数据按照有序序列方式填充到 temp 数组中
         * 直至左右两边的有序序列，有一边处理完毕为止
         */
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) { //使用等于号保证序列稳定性
                temp[t] = arr[i];
                t++;
                i++;
            } else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }
        // 将左边有序序列剩余元素平移到temp数组中
        while (i <= mid) {
            temp[t] = arr[i];
            t++;
            i++;
        }
        // 将右边有序数列剩余元素平移到temp数组中
        while (j <= right) {
            temp[t] = arr[j];
            t++;
            j++;
        }
        // 将temp数组中的元素拷贝到arr数组中，放入位置从arr[left]开始，到arr[right]结束，拷贝位置从temp[0]开始，到temp[t-1]结束
        int tempIndex = left;
        for (int k = 0; k <= t-1; k++) {
            arr[tempIndex] = temp[k];
            tempIndex++;
        }
    }

    public static void mSort03 (int[] arr, int left, int right, int[] temp) {
        if (left < right) { //递归结束条件，不符合条件就会一直分解
            int mid = (left + right)/2;
            mSort03(arr, left, mid, temp);
            mSort03(arr, mid+1, right, temp);
            int i = left; //左边序列的初始索引值
            int j = mid + 1; // 右边序列的初始索引值
            int t = 0; // 临时数组temp的初始索引值
            /*
             * 先把左右两边的数据按照有序序列方式填充到 temp 数组中
             * 直至左右两边的有序序列，有一边处理完毕为止
             */
            while (i <= mid && j <= right) {
                if (arr[i] <= arr[j]) { //使用等于号保证序列稳定性
                    temp[t] = arr[i];
                    t++;
                    i++;
                } else {
                    temp[t] = arr[j];
                    t++;
                    j++;
                }
            }
            // 将左边有序序列剩余元素平移到temp数组中
            while (i <= mid) {
                temp[t] = arr[i];
                t++;
                i++;
            }
            // 将右边有序数列剩余元素平移到temp数组中
            while (j <= right) {
                temp[t] = arr[j];
                t++;
                j++;
            }
            // 将temp数组中的元素拷贝到aar数组中，放入位置从arr[left]开始，到arr[right]结束，拷贝位置从temp[0]开始，到temp[t-1]结束
            int tempIndex = left;
            for (int k = 0; k <= t-1; k++) {
                arr[tempIndex] = temp[k];
                tempIndex++;
            }
        }
    }
}
