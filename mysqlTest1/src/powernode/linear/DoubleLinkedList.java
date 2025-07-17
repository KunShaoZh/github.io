package powernode.linear;


import java.util.Iterator;

/**
 * 双向链表实现存储线性表
 * @param <T>
 */
public class DoubleLinkedList<T> implements Iterable<T> {
    private Node head; //定义头结点
    private Node last; //定义尾结点，1.双向链表定义尾结点是因为双向链表可以通过last结点反向遍历；2.定义last在插入元素的过程中可以减少时间复杂度
    private int N; // 记录链表的长度

    public DoubleLinkedList() {
        this.head = new Node(null, null, null);
        this.last = null;
        this.N = 0;
    }

    private class Node {
        private T item;
        private Node pre; // 指向前一个结点
        private Node next; // 指向下一个结点

        public Node(T item, Node pre, Node next) {
            this.item = item;
            this.pre = pre;
            this.next = next;
        }
    }

    private class LinkedIterator implements Iterator<T>{
        private Node cursor; //定义指针指向头结点

        public LinkedIterator() {
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

    @Override
    public Iterator<T> iterator() {
        return new LinkedIterator();
    }

    public void clear() {
        this.last = null;
        this.head.pre = null;
        this.head.item = null;
        this.head.next = null;
        this.N = 0;
    }

    public boolean isEmpty() {
        return this.N == 0;
    }

    public int length() {
        return this.N;
    }

    public T get(int i) {
        if (i < 0 || i >= N) {
            throw new RuntimeException("索引不合法");
        }
        Node cursor = head.next; // 获取第一个结点
        for (int index = 0; index < i; index++) {
            cursor = cursor.next;
        }
        return cursor.item;
    }

    public void insert(T t) {
        // 通过遍历获取到链表最后一个结点
        /* Node cursor = head; // 定义指针指向头结点
        while (cursor.next != null) {
            cursor = cursor.next;
        }
        cursor.next = new Node(t, cursor, null);
        this.last = cursor.next;
        N++;**/

        // 通过last结点向链表末尾追加结点，时间复杂度更小
        if (last == null) {
            head.next = new Node(t, head, null);
            last = head.next;
        } else {
            /*Node oldLast = last;
            last = new Node(t, head, null);
            oldLast.next = last;**/
            Node oldLast = last;
            oldLast.next = new Node(t, oldLast, null);
            last = oldLast.next;
        }
        N++;
    }

    public void insert(int i, T t) {
        if (i < 0 || i >= N) {
            throw new RuntimeException("索引不合法");
        }
        Node cursor = head; // 定义指针指向头结点
        for (int index = 0; index < i; index++) { // 找到索引i位置的前一个结点
            cursor = cursor.next;
        }
        Node current = cursor.next; // 获取索引i位置的结点
        Node node = new Node(t, cursor, current);
        cursor.next = node;
        current.pre = node;
        N++;
    }

    public T remove(int i) {
        if (i < 0 || i >= N) {
            throw new RuntimeException("索引不合法");
        }
        Node cursor = head;
        for (int index = 0; index < i; index++) { // 找到索引i位置的前一个结点
            cursor = cursor.next;
        }
        Node current = cursor.next; // 获取索引i位置的结点
        Node current_next = cursor.next.next; // 获取索引i位置的下一个结点
        if (current == last) {
            cursor.next = current_next;
        } else {
            cursor.next = current_next;
            current_next.pre = cursor;
        }
        N--;
        return current.item;
    }

    public int indexOf(T t) {
        if (N == 0) {
            return -1;
        }
        Node cursor = head;
        for (int index = 0; index < N; index++) {
            cursor = cursor.next;
            if (cursor.item.equals(t)) {
                return index;
            }
        }
        return -1;
    }

    public T getFirst() {
        if (isEmpty()) {
            return null;
        }
        return head.next.item;
    }
    
    public T getLast() {
        if (last == null) {
            return null;
        }
        return last.item;
    }

    public static void main(String[] args) {
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        list.insert("乔峰");
        list.insert("虚竹");
        list.insert("段誉");
        list.insert(1,"鸠摩智");
        list.insert(3,"叶二娘");
        for (String str : list) {
            System.out.println(str);
        }
        System.out.println("----------------------");
        String tow = list.get(2);
        System.out.println(tow);
        System.out.println("-------------------------");
        String remove = list.remove(3);
        System.out.println(remove);
        System.out.println(list.length());
        System.out.println("--------------------");
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(">>>>>>>>>>>");
        System.out.println(list.length());
        Iterator<String> iterator = list.iterator();
        System.out.println(iterator.hasNext());
        while (iterator.hasNext()) {
            String next =  iterator.next();
            System.out.println(next);
        }
        System.out.println("<<<<<<<<<<<<<<<<<");
        String a = list.remove(3);
        System.out.println(a);
    }
}
