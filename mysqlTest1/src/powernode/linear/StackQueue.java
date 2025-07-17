package powernode.linear;

/**
 * 基于栈实现队列
 */
public class StackQueue {
    private Stack<String> stack1;
    private Stack<String> stack2;

    public StackQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public void addQueue(String s) {
        stack1.push(s);
    }

    public String removeQueue() {
        if (stack2.isEmpty()) {
            int size = stack1.size();
            for (int i = 0; i < size; i++) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        StackQueue stackQueue = new StackQueue();
        stackQueue.addQueue("张三");
        stackQueue.addQueue("李四");
        stackQueue.addQueue("王五");
        stackQueue.addQueue("陈七");
        System.out.println(stackQueue.removeQueue());
        System.out.println(stackQueue.removeQueue());
        stackQueue.addQueue("朱八");
        System.out.println(stackQueue.removeQueue());
        System.out.println(stackQueue.removeQueue());
        System.out.println(stackQueue.removeQueue());
        System.out.println(stackQueue.removeQueue());
    }
}
