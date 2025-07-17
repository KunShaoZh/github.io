package powernode.investigation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test12 {
    public static void main(String[] args) {
        int[] array01 = {53, 3, 542, 728, 14, 214, 47, 52};
        basicSort(array01);
        System.out.println("基数排序（不支持负数）：" + Arrays.toString(array01));
        int[] array02 = {4, 6, 5, 3, 50, 108, 2, 1, -36};
        bubblingSort(array02);
        System.out.println("冒泡排序：" + Arrays.toString(array02));
        int[] array03 = {4, 5, 6, 3, 50, 108, 2, 1, -36, -23};
        quickSort(array03, 0, array03.length - 1);
        System.out.println("快速排序：" + Arrays.toString(array03));
        int[] array04 = {4, 6, 5, 3, 50, 108, 2, 1, -36};
        insertSort(array04);
        System.out.println("插入排序：" + Arrays.toString(array04));
        int[] array05 = {4, 6, 5, 3, 50, 108, 2, 1, -36};
        selectSort(array05);
        System.out.println("选择排序：" + Arrays.toString(array05));
        int[] array06 = {4, 6, 5, 3, 50, 108, 2, 1, -36};
        shellSort(array06);
        System.out.println("希尔排序：" + Arrays.toString(array06));
        int[] array07 = {4, 6, 5, 3, 50, 108, 2, 1, -36};
        mergeSort(array07, 0, array07.length - 1, new int[array07.length]);
        System.out.println("归并排序：" + Arrays.toString(array07));
    }

    public static void basicSort(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int digit = 0;
        while (max != 0) {
            max /= 10;
            digit++;
        }
        List<List<Integer>> bucket = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            bucket.add(new ArrayList<>());
        }
        int mold = 10;
        int div = 1;
        for (int i = 0; i < digit; i++, mold *= 10, div *= 10) {
            for (int a : arr) {
                int num = a % mold / div;
                bucket.get(num).add(a);
            }
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

    public static void bubblingSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                return;
            }
        }
    }

    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int p = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right) {
            while (left < right && arr[right] > p) {
                right--;
            }
            while (left < right && arr[left] <= p) {
                left++;
            }
            if (left < right) {
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
            }
        }
        arr[startIndex] = arr[left];
        arr[left] = p;
        quickSort(arr, startIndex, left - 1);
        quickSort(arr, left + 1, endIndex);
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            for (int j = i; j >= 1 ; j--) {
                if (arr[j-1] > temp) {
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                } else {
                    break;
                }
            }
        }
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            int min = arr[minIndex];
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < min) {
                    minIndex = j;
                    min = arr[j];
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }

        }
    }

    public static void shellSort(int[] arr) {
        for (int gap = arr.length/2; gap > 0; gap /= 2) {
            for (int i = 0; i < arr.length; i++) {
                int temp = arr[i];
                for (int j = i-gap; j >= 0 ; j-=gap) {
                    if (arr[j] > temp) {
                        arr[j+gap] = arr[j];
                        arr[j] = temp;
                    } else {
                        break;
                    }
                }
            }
        }
    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid, temp);
        mergeSort(arr, mid + 1, right, temp);
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j<= right) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                i++;
                t++;
            } else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }
        while (i <= mid) {
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right) {
            temp[t] = arr[j];
            t++;
            j++;
        }
        int tempIndex = left;
        for (int k = 0; k <= t-1; k++) {
            arr[tempIndex] = temp[k];
            tempIndex++;
        }
    }
}
