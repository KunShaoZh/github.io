package powernode.investigation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 基数排序、冒泡排序、快速排序、插入排序、选择排序、希尔排序、归并排序练习(90分钟以内)
 */
public class Test07 {
    public static void main(String[] args) {
        int[] arr01 = {10, 6, 36, 2, 100, 238, 78, 16, 8, 99, 3, 67, 6, 1342, 63};
        basicSort(arr01);
        System.out.println(Arrays.toString(arr01));
        int[] arr02 = {10, 6, 36, 2, 100, 238, 78, 16, 8, 99, 3, 67, 6, 1342, 63};
        bubblingSort(arr02);
        System.out.println(Arrays.toString(arr02));
        int[] arr03 = {10, 6, 36, 2, 100, 238, 78, 16, 8, 99, 3, 67, 6, 1342, 63};
        quickSort(arr03, 0, arr03.length - 1);
        System.out.println(Arrays.toString(arr03));
        int[] arr04 = {10, 6, 36, 2, 100, 238, 78, 16, 8, 99, 3, 67, 6, 1342, 63};
        insertSort(arr04);
        System.out.println(Arrays.toString(arr04));
        int[] arr05 = {10, 6, 36, 2, 100, 238, 78, 16, 8, 99, 3, 67, 6, 1342, 63};
        selectSort(arr05);
        System.out.println(Arrays.toString(arr05));
        int[] arr06 = {10, 6, 36, 2, 100, 238, 78, 16, 8, 99, 3, 67, 6, 1342, 63};
        shellSort(arr06);
        System.out.println(Arrays.toString(arr06));
        int[] arr07 = {10, 6, 36, 2, 100, 238, 78, 16, 8, 99, 3, 67, 6, 1342, 63};
        mergeSort(arr07, 0, arr07.length - 1, new int[arr07.length]);
        System.out.println(Arrays.toString(arr07));
    }


    public static void basicSort (int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int digit = 0;
        while (max > 0) {
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
            for (int j = 0; j < arr.length; j++) {
                int num = (arr[j] % mold) / div;
                bucket.get(num).add(arr[j]);
            }
            int index = 0;
            for (List<Integer> list : bucket) {
                for (Integer l : list) {
                    arr[index] = l;
                    index++;
                }
                list.clear();
            }
        }
    }

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

    public static void quickSort (int[] arr, int starIndex, int endIndex) {
        if (starIndex < endIndex) {
            int p = arr[starIndex];
            int l = starIndex;
            int r = endIndex;
            while (l != r) {
                while (l < r && arr[r] > p) {
                    r--;
                }
                while (l < r && arr[l] <= p) {
                    l++;
                }
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
            arr[starIndex] = arr[l];
            arr[l] = p;
            quickSort(arr, starIndex, l - 1);
            quickSort(arr, l + 1, endIndex);
        }
    }

    public static void insertSort (int[] arr) {
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

    public static void selectSort (int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }

    public static void shellSort (int[] arr) {
        for (int gap = arr.length / 2; gap > 0 ; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int temp = arr[i];
                for (int j = i - gap; j >= 0 ; j -= gap) {
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

    public static void mergeSort (int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            int i = left;
            int j = mid + 1;
            int t = 0;
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
            t = 0;
            int tempIndex = left;
            while (tempIndex <= right) {
                arr[tempIndex] = temp[t];
                t++;
                tempIndex++;
            }
        }
    }
}
