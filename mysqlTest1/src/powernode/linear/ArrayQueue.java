package powernode.linear;

import java.util.Iterator;

/**
 * 数组实现队列
 * @param <T>
 */
public class ArrayQueue<T> implements Iterable<T>{

    private T[] array;

    private int headPoint;// 定义指针指向队头

    private int lastPoint;// 定义指针指向队尾

    private int count; // 记录元素个数

    public ArrayQueue(int capacity) {
        //noinspection unchecked
        this.array = (T[]) new Object[capacity];
        this.headPoint = -1;
        this.lastPoint = -1;
        this.count = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<T> {
        private int cursor;
        private int head; // 定义指针指向队头,队列遍历从队头开始到队尾
        private int last; // 定义指针指向队尾

        public QueueIterator() {
            this.cursor = 0;
            this.head = headPoint;
        }

        @Override
        public boolean hasNext() {
            return cursor < count;
        }

        @Override
        public T next() {
            if (hasNext()) {
                if (head == array.length - 1) {
                    head = 0;
                    cursor++;
                    return array[head];
                } else {
                    cursor++;
                    return array[head++];
                }
            }
            return null;
        }
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == array.length;
    }

    public void addQueue(T t) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        if (lastPoint == array.length - 1) {
            lastPoint = 0;
            array[lastPoint] = t;
        } else {
            array[++lastPoint] = t;
        }
        count++;
    }

    public T removeQueue() {
        if (isEmpty()) {
            return null;
        }
        if (headPoint == array.length - 1) {
            headPoint = 0;
            T current = array[headPoint];
            array[headPoint] = null;
            count--;
            return current;
        } else {
            T current = array[++headPoint];
            array[headPoint] = null;
            count--;
            return current;
        }
    }

    public T peek() {
        return array[headPoint+1];
    }

    public void listQueue() {
        if (isEmpty()) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.printf("queue[%s]=%s\n", i, array[i]);
        }
    }

    public static void main(String[] args) {
        /*ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(5);
        queue.add("张三");
        for (String s : queue) {
            System.out.println(s);
        }
        queue.add("李四");
        String peek = queue.peek();
        System.out.println(peek);
        System.out.println(queue.size());
        String remove = queue.remove();
        System.out.println("删除队头元素：" + remove);
        for (String s : queue) {
            System.out.println(s);
        }**/
        ArrayQueue<String> arrayQueue = new ArrayQueue<>(5);
        System.out.println(arrayQueue.isEmpty());
        arrayQueue.addQueue("张三");
        arrayQueue.addQueue("李四");
        arrayQueue.addQueue("王五");
        arrayQueue.addQueue("陈七");
        arrayQueue.addQueue("朱八");
        System.out.println(arrayQueue.isFull());
        arrayQueue.listQueue();
        System.out.println(arrayQueue.peek());
        System.out.println(arrayQueue.removeQueue());
        System.out.println(arrayQueue.peek());
        System.out.println(">>>>>>>>>>>>>>>>");
        arrayQueue.listQueue();
        System.out.println(arrayQueue.lastPoint);
        System.out.println("第一次遍历");
        for (String s : arrayQueue) {
            System.out.println(s);
        }

        arrayQueue.addQueue("不知火舞");
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<");
        arrayQueue.listQueue();
        System.out.println(arrayQueue.lastPoint);
        System.out.println(arrayQueue.removeQueue());
        arrayQueue.listQueue();
        System.out.println("队列闭环");


    }


}
