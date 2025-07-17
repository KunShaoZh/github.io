package powernode.binary.tree;

public class Heap <T extends Comparable<T>>{
    private int N;
    private T[] items;

    public Heap(int capacity) {
        N = 0;
        //noinspection unchecked
        this.items = (T[]) new Comparable[capacity + 1];
    }

    /**
     * 判断索引i处的元素是否小于索引j处的元素
     */
    private boolean less(int i, int j) {
        if (i < 1 || i > N || j < 1 || j > N) {
            throw new RuntimeException("非法索引");
        }
        return items[i].compareTo(items[j]) < 0;
    }

    /**
     * 交换堆中i索引位置和j索引位置的元素
     */
    private void exchange(int i, int j) {
        T temp = items[j];
        items[j] = items[i];
        items[i] = temp;
    }

    /**
     * 往堆中插入一个元素
     */
    public void insert(T t) {
        if (N == items.length - 1) {
            System.out.println("堆满");
            return;
        }
        items[++N] = t;
        swim(N);
    }

    /**
     * 删除堆中的最大元素，并返回这个最大元素
     */
    public T delMax() {
        if (N == 0) {
            System.out.println("堆空");
            return null;
        }
        T max = items[1];
        //交换索引 1 处和索引 N 处的值
        exchange(1, N);
        items[N--] = null;
        sink(1);
        return max;
    }

    /**
     * 使用上浮算法，使索引k处处的元素能在堆中处于正确位置
     * k是新加入元素的位置索引，也是最后一个元素位置索引
     */
    private void swim(int k) {
        while (k > 1) {//如果已经到了根结点，就不需要循环了
            if (less(k/2, k)) {//比较当前结点和其父结点
                exchange(k/2, k);//父结点小于当前结点，需要交换
            }
            k /= 2;
        }
    }

    /**
     * 使用下沉算法，使索引k处处的元素能在堆中处于正确位置
     */
    private void sink(int k) {
        while (2*k <= N){//如果当前已经是最底层了，就不需要循环了
            int maxIndex;//找到子结点中的较大者的索引
            if (2 * k +1 <= N) {//存在右子结点
                if (less(2*k, 2*k+1)) {
                    maxIndex = 2*k+1;
                } else {
                    maxIndex = 2 * k;
                }
            } else {// 右子结点不存在
                maxIndex = 2 * k;
            }
            if(!less(k, maxIndex)) { //比较当前结点和子结点中的较大者，如果当前结点不小，则结束循环
                break;
            }
            exchange(k, maxIndex);
            k = maxIndex;
        }
    }

    public void order() {
        System.out.println("-------------");
        for (int i = 1; i <= N; i++) {
            System.out.print(items[i]);
        }
    }

    public static void main(String[] args) {
        Heap<String> heap = new Heap<>(20);
        heap.insert("S");
        heap.insert("G");
        heap.insert("I");
        heap.insert("E");
        heap.insert("N");
        heap.insert("H");
        heap.insert("O");
        heap.insert("A");
        heap.insert("T");
        heap.insert("P");
        heap.insert("R");
        heap.order();
        String del;
        while((del=heap.delMax())!=null){
            System.out.print(del+",");
        }

    }
}
