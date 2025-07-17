package powernode.linear;

import java.util.HashSet;
import java.util.Set;

public class TestApp {

    public static void main(String[] args) {
        // 构建节点
        Node<String> head = new Node<>(null, null);
        Node<String> first = new Node<>("aa", null);
        Node<String> second = new Node<>("bb", null);
        Node<String> third = new Node<>("cc", null);
        Node<String> fourth = new Node<>("dd", null);
        Node<String> fifth = new Node<>("ee", null);
        Node<String> sixth = new Node<>("ff", null);
        Node<String> seventh = new Node<>("gg", null);
        //Objects.equals(, );
        // 生成链表
        head.next = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;
        //fifth.next = first; // 生成环


       /*Node<String> node = getMid(head);
        System.out.println(node.item);**/

        TestApp testApp = new TestApp();
        boolean flag = testApp.isCircle(head);
        System.out.println(flag);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        Node<String> headOne = new Node<>(null, null);
        Node<String> one = new Node<>("1", null);
        Node<String> two = new Node<>("2", null);
        Node<String> three = new Node<>("3", null);
        headOne.next = one;
        one.next= two;
        two.next = three;
        Node<String> headTwo = new Node<>(null, null);
        Node<String> fiv = new Node<>("5", null );
        Node<String> six = new Node<>("5", null );
        Node<String> sev = new Node<>("5", null );
        headTwo.next = fiv;
        fiv.next = six;
        six.next = three;
        three.next = sev;
        System.out.println(isCrossPoint(headOne, headTwo));
        System.out.println(isCrossPoint2(headOne, headTwo));



    }

    /**
     * 定义快慢指针
     * @param head 头结点
     * @return 返回链表中的中间结点
     */
    public static Node<String> getMid(Node<String> head) {
        Node<String> fast = head; // 定义快指针
        Node<String> slow = head; // 定义慢指针
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 定义快慢指针来判断链表是否为环型
     * @param head 链表头结点
     * @return 判断链表是否为环型
     */
    public boolean isCircle(Node<String> head) {
        Node<String> fast = head;
        Node<String> slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast==slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取入环结点
     * @param head 头结点
     * @return 返回入环结点
     */
    public Node<String> getCircle(Node<String> head) {
        Node<String> fast = head;
        Node<String> slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        fast = head;// 快指针从头开始移动
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    /**
     * 单向链表翻转，通过定义指针来实现
     * @param head 头结点
     */
    public static void getCursor(Node<String> head) {
        if (head.next == null) {
            System.out.println("空链表");
        } else {
            reverse(head.next, head);
        }
    }

    public static Node<String> reverse(Node<String> cursor, Node<String> head) {
        // 判断是否为链表最后一个结点
        if (cursor.next == null) {
            head.next = cursor;
            return cursor;
        }
        // 找到当前结点的下一个结点
        Node<String> next = reverse(cursor.next, head);
        next.next = cursor;
        cursor.next = null;
        return cursor;
    }

    /**
     * 哈希法判断链表是否相交
     * @param headOne 链表一头结点
     * @param headTwo 链表二头结点
     * @return boolean
     */
    public static boolean isCrossPoint(Node<String> headOne, Node<String> headTwo) {
        if (headOne.next == null || headTwo.next == null) {
            return false;
        }
        Set<Node<String>> set = new HashSet<>();
        Node<String> cursorOne = headOne;
        while (cursorOne.next != null) {
            cursorOne = cursorOne.next;
            set.add(cursorOne);
        }
        Node<String> cursorTwo = headTwo;
        while (cursorTwo.next != null) {
            cursorTwo = cursorTwo.next;
            if (set.contains(cursorTwo)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断链表是否相交
     * 定义双指针，判断计算长短链表长度差，使指针在同一起跑线移动
     * @param headOne 链表一头结点
     * @param headTwo 链表二头结点
     * @return boolean
     */
    public static boolean isCrossPoint2(Node<String> headOne, Node<String> headTwo) {
        if (headOne.next == null || headTwo.next == null) {
            return false;
        }
        int lenOne = 0, lenTwo = 0;
        Node<String> one = headOne, two = headTwo;
        while (one.next != null) {
            one = one.next;
            lenOne++;
        }
        while (two.next != null) {
            two = two.next;
            lenTwo++;
        }
        one = headOne; two = headTwo;
        if (lenOne > lenTwo) {
            for (int i = 0; i < lenOne - lenTwo; i++) {
                one = one.next;
            }
        } else {
            for (int i = 0; i < lenTwo - lenOne; i++) {
                two = two.next;
            }
        }
        while (one != null && two != null) {
            if (one == two) return true;
            one = one.next;
            two = two.next;
        }
        return false;
    }
}
