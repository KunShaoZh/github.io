package powernode.sort;

import java.util.Arrays;

/**
 * 用堆进行排序
 */
public class HeapSort<T extends Comparable<T>> {
    private T[] data; // 堆数组
    private int count; // 元素个数
    private int capacity; // 堆数组可容纳的元素个数

    // 构造函数, 通过一个给定数组创建一个最大堆
    // 该构造堆的过程, 时间复杂度为O(nlogn)
    public HeapSort(T[] arr) {
        if (arr == null) {
            throw new RuntimeException("源数组为空");
        }
        int n = arr.length;
        //noinspection unchecked
        this.data = (T[]) new Comparable[n+1];
        this.capacity = n;
        System.arraycopy(arr, 0, data, 1, arr.length);// 向堆中拷贝数据
        System.out.println("构造方法");
        System.out.println(Arrays.toString(data));
        this.count = n;
        // 下沉算法，让元素处在该有的位置上，从第一个不是叶子结点的位置开始
        for (int i = count/2; i >= 1; i--) {// 这里有插入排序的思想，数据检索的顺序和排序顺序相反
            sink(i);
        }
    }

    // 返回堆中的元素个数
    public int size(){
        return count;
    }

    // 返回一个布尔值, 表示堆中是否为空
    public boolean isEmpty(){
        return count == 0;
    }

    // 判断索引i处的元素是否小于索引j处的元素
    private boolean less(int i, int j) {
        return data[i].compareTo(data[j]) < 0;
    }

    // 交换堆中i索引位置和j索引位置的元素
    private void exchange(int i, int j) {
        T temp = data[j];
        data[j] = data[i];
        data[i] = temp;
    }

    /**
     * 往堆中插入一个元素
     */
    public void insert(T t) {
        if (count <= capacity) {
            data[++count] = t;
            swim(count);
        } else {
            System.out.println("堆满");
        }
    }

    public T delMax() {
        if (count == 0) {
            System.out.println("堆空");
            return null;
        }
        T t = data[1];
        exchange(1, count);
        data[count--] = null;
        sink(1);
        return t;
    }

    public void list() {
        for (int i = 1; i < data.length; i++) {
            System.out.print(data[i] + ", ");
        }
        System.out.println();
    }

    /**
     * 使用上浮算法，使索引k处处的元素能在堆中处于正确位置
     * k是新加入元素的位置索引，也是最后一个元素位置索引
     */
    private void swim (int k) {
        while (k > 1) {
            if (less(k/2, k)) {
                exchange(k/2, k);
            }
            k /= 2;
        }
    }

    /**
     * 使用下沉算法，使索引k处处的元素能在堆中处于正确位置
     */
    private void sink(int k) {
        while (2 * k <= count) {//如果当前已经是最底层了，就不需要循环了
            int maxIndex;//找到子结点中的较大者的索引
            if (2 * k + 1 <= count) {//存在右子结点
                if (less(2*k,2*k+1)) {
                    maxIndex = 2 * k + 1;
                } else {
                    maxIndex = 2 * k;
                }
            } else {// 右子结点不存在
                maxIndex = 2 * k;
            }
            if (!less(k, maxIndex)) break;//比较当前结点和子结点中的较大者，如果当前结点不小，则结束循环
            exchange(k, maxIndex);
            k = maxIndex;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{11, 4, 3, 5, 13, 9, 8, 48, 19, 14, 35, 39, 0, 16, 12, 6, 15, 29, 1, 57};
        System.out.println("源数组：");
        System.out.println(Arrays.toString(arr));
        HeapSort<Integer> heapSort = new HeapSort<>(arr);
        System.out.println("堆：");
        heapSort.list();
        heapSort(heapSort, arr);
        System.out.println("排序后数组：");
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(HeapSort<Integer> heapSort, Integer[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            Integer delMax = heapSort.delMax();
            arr[i] = delMax;
        }
    }


}
