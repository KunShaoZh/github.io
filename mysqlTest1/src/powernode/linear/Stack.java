package powernode.linear;

import java.util.Iterator;

/**
 * 基于链表实现栈
 * @param <T>
 */
public class Stack<T> implements Iterable<T>{
    public Node head;
    public int N;

    public Stack() {
        this.head = new Node(null, null);
        N = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<T> {
        private Node cursor;

        public StackIterator() {
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

    private class Node {
        public T item;
        public Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    /**
     * // 判断栈是否为空
     * @return ture、false
     */
    public boolean isEmpty() {
        return this.N == 0;
    }

    /**
     * 获取栈中的元素个数
     * @return 元素个数
     */
    public int size() {
        return this.N;
    }

    /**
     * 弹出栈顶元素
     * @return 返回被弹出的元素
     */
    public T pop() {
        if (N == 0) {
            System.out.println("空栈");
            return null;
        }
        Node current = head.next;
        head.next = head.next.next;
        N--;
        return current.item;
    }

    /**
     * 向栈顶压入元素
     * @param t 元素
     */
    public void push(T t) {
        Node current = head.next;
        head.next = new Node(t, current);
        N++;
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        System.out.println(stack.isEmpty());
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        for (String str : stack) {
            System.out.print(str+" ");
        }
        System.out.println("-----------------------------");
        String result = stack.pop();
        System.out.println("弹出了元素："+result);
        System.out.println(stack.size());
    }
}
