package powernode.investigation;
import powernode.linear.Node;
import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {
    private Node<T> head; // 记录首节点
    private int N; // 记录链表长度，也是元素的个数

    public LinkedList() {
        this.head = new Node<>(null, null);
        this.N = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkIterator<>();
    }

     /*private class LinkIterator<E> implements Iterator<E> {
        private int cursor;
        public LinkIterator() {
            this.cursor = 0;
        }

        @Override
        public boolean hasNext() {
            return cursor < N;
        }

        @Override
        public E next() {
            if (cursor < N) {
                Node<T> first = head.next;// 获取第一个节点
                for (int index = 0; index < cursor; index++) {
                    first = first.next;
                }
                cursor++;
                //noinspection unchecked
                return (E) first.item;
            } else {
                return null;
            }
        }
    }**/

    private class LinkIterator<E> implements Iterator<E> {
        private Node<T> cursor; //定义指针指向头结点

        public LinkIterator() {
            this.cursor = head;
        }

        @Override
        public boolean hasNext() {
            return cursor.next != null;
        }

        @Override
        public E next() {
            if (hasNext()) {
                cursor = cursor.next;
                //noinspection unchecked
                return (E) cursor.item;
            }
            return null;
        }
    }

    /**
     * 清空链表
     */
    public void clear() {
        this.head.item = null;
        this.head.next = null;
        this.N = 0;
    }

    /**
     * 判断链表是否为空
     *
     * @return true、false
     */
    public boolean isEmpty() {
        return this.N == 0;
    }

    /**
     * 获取链表的长度
     *
     * @return N
     */
    public int length() {
        return N;
    }

    /**
     * 获取指定索引i位置的元素
     *
     * @param i 元素索引
     * @return T 元素值
     */
    public T get(int i) {
        if (i < 0 || i >= N) {
            throw new RuntimeException("索引不合法");
        }
        Node<T> next = head.next; // 获取第一个节点
        for (int index = 0; index < i; index++) {
            next = next.next;
        }

        /* * Node<T> n = head;
        for (int index = 0; index <= i ; index++) {
            n = head.next;
        }*/
        return next.item;
    }

    /**
     * 向链表中添加元素t
     *
     * @param t 数据元素
     */
    public void insert(T t) {
        // 创建新节点
        Node<T> node = new Node<>(t, null);
        Node<T> first = head;// 定义指针指向头结点
        for (int index = 0; index < N; index++) {
            first = first.next;
        }
        first.next = node;
        N++;
        // 定义指针指向头结点
       /* * Node<T> cursor = head;
        // 查找最后一个节点
        while (cursor.next != null) {
            // 指针后移
            cursor = cursor.next;
        }
        cursor.next = node;
        N++;*/
    }

    /**
     * 在链表的索引为i的位置插入一个值为t的数据元素
     *
     * @param i 索引值
     * @param t 元素值
     */
    public void insert(int i, T t) {
        if (i < 0 || i >= N) {
            throw new RuntimeException("索引不合法");
        }
        Node<T> prefix = head;
        // 获取索引i的前一个节点
        for (int index = 0; index < i; index++) {
            prefix = prefix.next;
        }
        Node<T> current = prefix.next; // 获取索引i当前节点
        Node<T> node = new Node<>(t, null); // 创建新节点
        node.next = current;
        prefix.next = node;
        N++;
    }

    /**
     * 删除指定位置 i 处的元素，并返回被删除的元素
     *
     * @param i 索引值
     * @return 删除掉的元素值T
     */
    public T remove(int i) {
        if (i < 0 || i >= N) {
            throw new RuntimeException("索引不合法");
        }
        Node<T> cursor = head; // 定义指针指向头结点
        // 获取索引i的前一个节点
        for (int index = 0; index <= i - 1; index++) {
            cursor = cursor.next;
        }
        Node<T> current = cursor.next; // 获取索引i当前节点
        // 前一个节点指向后一个节点
        cursor.next = cursor.next.next;
        N--;
        return current.item;
    }

    /**
     * 查找元素t在链表中第一次出现的位置
     *
     * @param t 数据元素
     * @return 返回索引值
     */
    public int indexOf(T t) {
        if (N == 0) {
            return -1;
        } else {
            Node<T> cursor = head; // 定义指针指向头结点
            for (int index = 0; index < N; index++) {
                cursor = cursor.next;
                if (cursor.item.equals(t)) {
                    return index;
                }
            }
        }
        return -1;
    }

    public void reverse() {
        if (isEmpty()) {
            System.out.println("链表为空");
        } else {
           reverse(head.next);
        }
    }

    /**
     * 单向链表翻转(递归调用直到最后一个结点)
     *
     * @param cursor 当前指针指向的结点
     * @return 当前结点
     */
    public Node<T> reverse(Node<T> cursor) {
        if (cursor.next == null) {
            head.next = cursor;
            return cursor;
        }
        Node<T> next = reverse(cursor.next);
        next.next = cursor;
        cursor.next = null;
        return cursor;
    }

}


