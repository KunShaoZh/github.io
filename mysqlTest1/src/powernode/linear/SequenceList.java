package powernode.linear;

import java.util.Iterator;

/**
 * 数组实现存储线性表
 * @param <T>
 */
public class SequenceList<T> implements Iterable<T>{
    private T[] element;// 存储元素的数组
    private int N;// 线性表的长度，也是元素个数

    /**
     * @param capacity 数组容量大小
     */
    @SuppressWarnings("unchecked")
    public SequenceList(int capacity) {
        this.element = (T[]) new Object[capacity];
        this.N = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Siterable<>();
    }

    private class Siterable<E> implements Iterator<E>{
        private int cursor; // 定义指针指向索引0，数组遍历从索引0到N-1

        public Siterable() { // 无参构造
            this.cursor = 0;
        }

        @Override
        public boolean hasNext() {
            return cursor < N;
        }

        // 获取元素
        @Override
        public E next() {
            if (hasNext()) {
                //noinspection unchecked
                return (E) element[cursor++];
            }
            return null;
        }
    }


    /**
     * 清空线性表
     */
    public void clear() {
        for (int i = 0; i < N; i++) {
            element[i] = null;
        }
        this.N = 0;
    }

    /**
     * 判断线性表是否为空，是返回true，否返回false
     * @return true、false
     */
    public boolean isEmpty() {
        return this.N == 0;
    }

    /**
     * 获取线性表中元素的个数
     * @return N
     */
    public int length() {
        return N;
    }

    /**
     * 读取并返回第i个元素的值
     * @param i 元素索引
     * @return 元素值
     */
    public T get(int i) {
        if (i < 0 || i >= N) {
            throw new RuntimeException("索引不合法");
        }
        return element[i];
    }

    /**
     * 在线性表的第i个元素之前插入一个值为t的数据元素
     * @param i 索引
     * @param t 元素
     */
    public void insert(int i, T t) {
        if (i < 0 || i >= N) {
            throw new RuntimeException("索引不合法");
        }
        // 插入元素时判断是否扩容
        if (N == this.element.length) {
            reSize(element.length * 2);
        }
        //先把 i 处的元素及其后面的元素依次向后移动一位，元素向后移动最后面的元素先移动
        for (int index = N; index > i ; index--) {
            element[index] = element[index - 1];
        }

        /* *for (int index = i; index < N; index++) {
            element[index + 1] = element[index];
        }*/
        element[i] = t;
        // 元素个数+1
        N++;
    }

    /**
     * 向线性表中添加一个元素t
     * @param t 数据元素
     */
    public void insert(T t) {
        // 插入元素时判断是否扩容
        if (N == this.element.length) {
            reSize(element.length * 2);
        }
        element[N]=t;
        // 元素个数+1
        N++;
    }

    /**
     * 删除并返回线性表中第i个数据元素
     * @param i 索引
     * @return 删除元素
     */
    public T remove(int i) {
        if (i < 0 || i >= N) {
            throw new RuntimeException("索引不合法");
        }
        // 如果数组元素小于原来的 1/4 那么久减少原来的 1/2 的内存空间
        if (N < (this.element.length / 4)) {
            reSize(element.length / 2);
        }
        T t = element[i];
        //索引 i 后面的元素依次向前移动一位即可，元素向前移动最前面的元素先移动
        for (int index = i; index < N - 1; index++) {
            element[index] = element[index + 1];
        }
        element[N-1] = null; // 最后一个元素赋值null
        N--;
        return t;
    }

    /**
     * 返回线性表中首次出现的指定元素的位序号，若不存在则返回-1
     * @param t 数据元素
     * @return 元素索引
     */
    public int indexOf(T t) {
        int index = -1;
        for (int i = 0; i < N; i++) {
            if (element[i].equals(t)) {
                index = i;
            }
        }
        return index;
    }

    /**
     * 数组容量修改
     * @param newCapacity 新数组容量
     */
    @SuppressWarnings("unchecked")
    private void reSize(int newCapacity) {
        // 记录旧数组
        T[] temp = element;
        // 创建新数组
        element = (T[]) new Object[newCapacity];
        // 把旧数组中的元素拷贝到新数组中
        for (int i = 0; i < N; i++) {
            element[i] = temp[i];
        }
    }

    // 测试
    public static void main(String[] args) {
        SequenceList<String> stringSequenceList = new SequenceList<>(5);
        for (String s : stringSequenceList) {
            System.out.println(s);
        }
        //System.out.println(stringSequenceList.get(0));
        System.out.println("<<<<<<<<<<<<<<<<");
        stringSequenceList.insert("zhangsan");
        stringSequenceList.insert("lisi");
        stringSequenceList.insert("chenqi");
        stringSequenceList.insert(1, "wangwu");
        System.out.println(stringSequenceList.length());
        for (String s : stringSequenceList) {
            System.out.println(s);
        }
        System.out.println(">>>>>>>>>>");
        String remove = stringSequenceList.remove(0);
        System.out.println(remove);
        System.out.println(stringSequenceList.get(0));
        System.out.println(stringSequenceList.get(1));
        System.out.println(stringSequenceList.get(2));
        /*System.out.println(stringSequenceList.get(3));
        System.out.println(stringSequenceList.get(4));**/
        stringSequenceList.clear();
        for (String s : stringSequenceList) {
            System.out.println(s);
        }
        System.out.println("===============");
        for (String s : stringSequenceList) {
            System.out.println(s);
        }
        /* *stringSequenceList.clear();
        System.out.println(stringSequenceList.length());
        System.out.println(stringSequenceList.isEmpty());
        System.out.println(stringSequenceList.get(3));*/
        System.out.println("==========");

        Iterator<String> iterator = stringSequenceList.iterator();
        System.out.println(iterator.hasNext());
        String next = iterator.next();
        System.out.println(next);
        System.out.println("-----------------");
        stringSequenceList.forEach(System.out::println);

        System.out.println(">>>>>>>>>>>>");
        while (iterator.hasNext()) {
            String n = iterator.next();
            System.out.println(n);
        }
    }


}
