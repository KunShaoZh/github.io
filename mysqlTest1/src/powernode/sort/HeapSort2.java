package powernode.sort;
/**
 * 用堆进行排序，用给定数组构造堆的时间复杂度为O(nlogn)，构造堆的思想与插入排序的思想一致，都是元素比较的索引移动方向与元素写入的索引移动方向正好
 * 相反，区别在于堆是一种二叉树数组，是一层一层的比较和写入，无论是上浮算法还是下沉算法，内层循环时间复杂度都是O(logn)，插入算法内层循环是O(n)
 */
public class HeapSort2 {
    @SuppressWarnings("rawtypes")
    public static void sort(Comparable[] arr, Comparable[] arr01) {
        int n = arr.length;
        // 注意，此时我们的堆是从0开始索引的，父节点与子节点的公式不一样
        // 从(最后一个元素的索引-1)/2开始
        // 最后一个元素的索引 = n-1
        for (int i = (n - 1 - 1) / 2; i >= 0; i--)
            sink(arr, n, i);
        System.out.println("arr堆");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            swim(arr01, i);
        }
        System.out.println("arr01堆");
        for (int i = 0; i < n; i++) {
            System.out.print(arr01[i] + " ");
        }
        System.out.println();

        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            shiftDown(arr, i, 0);
        }

    }

    // 交换堆中索引为i和j的两个元素
    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // 判断索引i处的元素是否小于索引j处的元素
    @SuppressWarnings({"rawtypes", "unchecked"})
    private static boolean less(Comparable[] arr, int i, int j) {
        return arr[i].compareTo(arr[j]) < 0;
    }

    // 原始的shiftDown过程
    private static void shiftDown(Comparable[] arr, int n, int k) {
        while (2 * k + 1 < n) {
            //左孩子节点
            int j = 2 * k + 1;
            //右孩子节点比左孩子节点大
            if (j + 1 < n && arr[j + 1].compareTo(arr[j]) > 0)
                j += 1;
            //比两孩子节点都大
            if (arr[k].compareTo(arr[j]) >= 0) break;
            //交换原节点和孩子节点的值
            swap(arr, k, j);
            k = j;
        }
    }

    // 下沉算法比小
    private static void sink(Comparable[] arr, int n, int k) {
        while (2 * k + 1 < n) {
            int j = 2 * k + 1; //左子节点
            if (j + 1 < n && less(arr, j, j + 1)) {
                j += 1;
            }
            if (!less(arr, k, j)) break;
            swap(arr, k, j);
            k = j;
        }
    }

    // 上浮算法比大
    private static void swim(Comparable[] arr, int k) {
        while (k > 0) {
            if (less(arr, (k-1)/2, k)) {
                swap(arr, (k-1)/2, k);
            }
            k = (k-1)/2;
        }
    }

    // 测试 HeapSort
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{11, 4, 3, 5, 13, 9, 8, 48, 19, 14, 35, 39, 0, 16, 12, 6, 15, 29, 1, 57};
        Integer[] arr01 = new Integer[]{11, 4, 3, 5, 13, 9, 8, 48, 19, 14, 35, 39, 0, 16, 12, 6, 15, 29, 1, 57};
        sort(arr, arr01);
        // 将heapify中的数据逐渐使用extractMax取出来
        // 取出来的顺序应该是按照从大到小的顺序取出来的
        System.out.println("数组arr：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("数组arr01");
        for (int i = 0; i < arr01.length; i++) {
            System.out.print(arr01[i] + " ");
        }
    }
}
