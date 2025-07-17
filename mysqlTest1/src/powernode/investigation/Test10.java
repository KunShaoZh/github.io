package powernode.investigation;

import powernode.linear.Node;

public class Test10 {
    public static void main(String[] args) {
        Node<String> first = new Node<>("zhangsan", null);
        first.next = new Node<>("wangwu", new Node<>("chenqi", null));


        /*Node<String> current = first.next;
        Node<String> third = new Node<>("lisi", null);
        third.next = current;
        first.next = third;*/
        Node<String> second = first.next;
        first.next = second.next;
        System.out.println(first.item);
        System.out.println(first.next.item);
        System.out.println(second.item);
        System.out.println(second.next.item);



        // System.out.println(current.item);
        //System.out.println(third.next.item);


    }
}
