package powernode.linear;

import java.util.Iterator;

/**
 * 链表实现队列
 * @param <T>
 */
public class Queue<T> implements Iterable<T>{
    private Node head;
    private int N;
    private Node last; // 定义最后一个结点可以在链表末尾插入元素时降低时间复杂度，否则要通过遍历才能获得最后一个结点

    public Queue() {
        this.head = new Node(null, null);
        this.last = null;
        this.N = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }

    private class Node {
        private T item;
        private Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    private class QueueIterator implements Iterator<T> {
        private Node cursor;

        public QueueIterator() {
            this.cursor = head;
        }

        @Override
        public boolean hasNext() {
            return cursor.next != null;
        }

        @Override
        public T next() {
            if (hasNext()) {
                cursor = cursor.next;
                return cursor.item;
            }
            return null;
        }
    }

    /**
     * 判断队列是否为空
     * @return true、false
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * 返回队列中元素的个数
     * @return 元素个数
     */
    public int size() {
        return this.N;
    }

    /**
     * 写法一：向队列中添加一个元素
     */
    public void addQue(T t) {
        if (last == null) {
            last = new Node(t, null);
            head.next = last;
        } else {
            Node oldLast = last;
            last = new Node(t, null);
            oldLast.next =  last;
        }
        N++;
    }

    /**
     * 写法一：从队列中拿出一个元素
     * @return 返回被拿出的元素
     */
    public T deleteQue() {
        if (N == 0) {
            System.out.println("空队列");
            return null;
        }
        Node current = head.next;
        head.next = head.next.next;
        N--;
        if (N == 0) {
            last = null;
        }
        return current.item;
    }

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        queue.addQue("a");
        queue.addQue("b");
        queue.addQue("c");
        queue.addQue("d");
        for (String str : queue) {
            System.out.print(str+" ");
        }
        System.out.println("-----------------------------");
        String result = queue.deleteQue();
        System.out.println("出列了元素："+result);
        System.out.println(queue.size());
    }


}
