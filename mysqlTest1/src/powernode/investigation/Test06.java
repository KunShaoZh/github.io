package powernode.investigation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 基数排序、冒泡排序、快速排序、插入排序、选择排序、希尔排序、归并排序测试
 * */
public class Test06 {
    public static void main(String[] args) {
        int[] arr = {10, 6, 36, 2, 100, 238, 78, 16, 8, 99, 3, 67, 6, 1342};
        mergeSort(arr, 0, arr.length - 1, new int[arr.length]);
        System.out.println(Arrays.toString(arr));
        int[] arr01 = new int[100000];
        for (int i = 0; i < arr01.length; i++) {
            arr01[i] = (int)(Math.random() * 100000);
        }
        int[] arr02 = Arrays.copyOf(arr01, arr01.length);
        int[] arr03 = Arrays.copyOf(arr01, arr01.length);
        int[] arr04 = Arrays.copyOf(arr01, arr01.length);
        int[] arr05 = Arrays.copyOf(arr01, arr01.length);
        int[] arr06 = Arrays.copyOf(arr01, arr01.length);
        int[] arr07 = Arrays.copyOf(arr01, arr01.length);


        long start01 = System.currentTimeMillis();
        System.out.println("基数排序开始:" + start01);
        basicSort(arr01);
        long end01 = System.currentTimeMillis();
        System.out.println("基数排序结束:" + end01 + ",用时:" + (end01 - start01));

        long start02 = System.currentTimeMillis();
        System.out.println("冒泡排序开始:" + start02);
        bubblingSort(arr02);
        long end02 = System.currentTimeMillis();
        System.out.println("冒泡排序结束:" + end02 + ",用时:" + (end02 - start02));

        long start03 = System.currentTimeMillis();
        System.out.println("快速排序开始:" + start03);
        quickSort(arr03, 0, arr03.length - 1);
        long end03 = System.currentTimeMillis();
        System.out.println("快速排序结束:" + end03 + ",用时:" + (end03 - start03));

        long start04 = System.currentTimeMillis();
        System.out.println("插入排序开始:" + start04);
        insertSort(arr04);
        long end04 = System.currentTimeMillis();
        System.out.println("插入排序结束:" + end04 + ",用时:" + (end04 - start04));

        long start05 = System.currentTimeMillis();
        System.out.println("选择排序开始:" + start05);
        selectSort(arr05);
        long end05 = System.currentTimeMillis();
        System.out.println("选择排序结束:" + end05 + ",用时:" + (end05 - start05));

        long start06 = System.currentTimeMillis();
        System.out.println("希尔排序开始:" + start06);
        shellSort(arr06);
        long end06 = System.currentTimeMillis();
        System.out.println("希尔排序结束:" + end06 + ",用时:" + (end06 - start06));

        long start07 = System.currentTimeMillis();
        System.out.println("归并排序开始:" + start07);
        mergeSort(arr07, 0, arr07.length - 1, new int[arr07.length]);
        long end07 = System.currentTimeMillis();
        System.out.println("归并排序结束:" + end07 + ",用时:" + (end07 - start07));
    }

    /**
     * 1.基数排序
     * @param arr 待排序数组
     */
    public static void basicSort (int[] arr) {
        // 找数组元素最大值
        int max = arr[0];
        for (int a : arr) {
            if (a > max) {
                max = a;
            }
        }
        // System.out.println("数组元素最大值:" + max);
        // 确定最大值的位数
        int digit = 0;
        while (max != 0) {
            max /= 10;
            digit++;
        }
        // System.out.println("最大元素位数:" + digit);
        // 定义桶，并初始化
        List<List<Integer>> bucket = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            bucket.add(new ArrayList<>());
        }
        // 根据位数从右往左依次取到每个元素的位数进行排序
        int model = 10;
        int div = 1;
        for (int i = 0; i < digit; i++, model *= 10, div *= 10) {
            for (int a : arr) {
                // 获取每个元素的个位数、十位数、百位数
                int num = (a % model) / div;
                // 把num放入到对应索引的桶中
                bucket.get(num).add(a);
            }
            // 把桶中的数据依次写入到原来的数组中，并清空桶，开始下一轮排序
            int index = 0;
            for (List<Integer> list : bucket) {
                for (Integer integer : list) {
                    arr[index] = integer;
                    index++;
                }
                list.clear();
            }
        }
    }

    /**
     * 2.冒泡排序
     * @param arr 待排序数组
     */
    public static void bubblingSort (int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    /**
     * 3.快速排序
     * @param arr 待排序数组
     * @param startIndex 起始索引
     * @param endIndex 结束索引
     */
    public static void quickSort (int[] arr, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int p = arr[startIndex];
            int left = startIndex;
            int right = endIndex;
            while (left != right) {
                while (arr[right] > p && left < right) {
                    right--;
                }
                while (arr[left] <= p && left < right) {
                    left++;
                }
                if (left < right) {
                    int temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                }
            }
            arr[startIndex] = arr[left];
            arr[left] = p;
            /*左右指针重合位置元素与基准元素进行逆序交换后，如果是相等的，那么会一直递归下去，所以左边序列的末位边界应该是左右指针重合位置索引-1，
            右边序列起始是+1
             */
            quickSort(arr, startIndex, left - 1);
            quickSort(arr, left + 1, endIndex);
        }
    }

    /**
     * 4.插入排序(位移法)
     * @param arr 待排序数组
     */
    public static void insertSort (int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            for (int j = i; j >= 1 ; j--) {
                if (arr[j - 1] > temp) {
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 5.选择排序
     * @param arr 待排序数组
     */
    public static void selectSort (int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            int min = arr[minIndex];
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < min) {
                    minIndex = j;
                    min = arr[j];
                }
            }
            if (i != minIndex) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }

    /**
     * 6.希尔排序(位移法)
     * @param arr 待排序数组
     */
    public static void shellSort (int[] arr) {
        for (int gap = arr.length / 2; gap >0; gap/=2) {
            for (int i = gap; i < arr.length; i++) {
                int temp = arr[i];
                for (int j = i; j >= gap; j -= gap) {
                    if (arr[j-gap] > temp) {
                        arr[j] = arr[j-gap];
                        arr[j-gap] = temp;
                    } else {
                        break;
                    }
                }
            }
        }
    }

    /**
     * 7.归并排序
     * @param arr 待排序数组
     * @param left 左边序列起始下标
     * @param right 右边序列结束下标
     * @param temp 定义的临时数组
     */
    public static void mergeSort (int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            int i = left;
            int j = mid + 1;
            int t = 0;
            /*while (i <= mid && arr[i] < arr[j]) {
                temp[t] = arr[i];
                i++;
                t++;
            }
            while (j <= right && arr[j] < arr[i]) {
                temp[t] = arr[j];
                j++;
                t++;
            }*/
            // 先把左右两边的数据按照有序序列方式填充到 temp 数组中,直至左右两边的有序序列，有一边处理完毕为止
            while (i <= mid && j <= right) {
                if (arr[i] <= arr[j]) {
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
                i++;
                t++;
            }
            // 将右边有序数列剩余元素平移到temp数组中
            while (j <= right) {
                temp[t] = arr[j];
                j++;
                t++;
            }
            // 将temp数组中的元素拷贝到aar数组中，放入位置从arr[left]开始，到arr[right]结束，拷贝位置从temp[0]开始，到temp[t-1]结束
            int tempIndex = left;
            t = 0;
            while (tempIndex <= right) {
                arr[tempIndex] = temp[t];
                tempIndex++;
                t++;
            }
        }
    }


}
