package powernode.linear;

public class Node <T>{
    public T item;
    public Node<T> next;

    public Node(T item, Node<T> next) {
        this.item = item;
        this.next = next;
    }

    /**
     * 链表翻转，通过this指针内部实现,当事人角度
     * @param head 头结点
     * @return 当前结点
     */
    public Node<T> reverse(Node<T> head) {
        if (this.next == null) {
            head.next = this;
            return this;
        }
        Node<T> next = this.next.reverse(head);
        next.next = this;
        this.next = null;
        return this;
    }
}
