package powernode.linear;


/**
 * 数组实现栈
 * @param <T>
 */
public class ArrayStack<T> {
    private T[] stack;
    private int N;
    private int top; // 定义指针指向栈顶

    public ArrayStack(int capacity) {
        //noinspection unchecked
        this.stack = (T[]) new Object[capacity];
        this.N = 0;
        this.top = -1;
    }


    /**
     * 判断是否已经栈满
     * @return boolean
     */
    public boolean isFull() {
        return this.top == stack.length - 1;
    }

    public boolean isEmpty() {
        return this.N == 0;
    }

    public int size() {
        return this.N;
    }

    public void push(T t) {
        if (N == stack.length) {
            reSize(stack.length * 2);
        }
        top++;
        stack[N++] = t;
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("空栈，没有数据");
        }
        if (N < (stack.length / 4)) {
            reSize(stack.length / 2);
        }
        T t = stack[top];
        stack[top] = null;
        top--;
        N--;
        return t;
    }

    public void list(){
        if (isEmpty()){
            throw new RuntimeException("空栈，没有数据");
        }
        for (int i=0; i < N; i++){
            System.out.printf("stack[%s]=%s\n",i,stack[i]);

        }
    }

    @SuppressWarnings("unchecked")
    private void reSize(int newCapacity) {
        T[] temp = stack;
        stack = (T[]) new Object[newCapacity];
        for (int i = 0; i < N; i++) {
            stack[i] = temp[i];
        }
    }

    /**
     * 判断字符串是否回文
     * @param words 字符串
     * @return boolean
     */
    public static boolean detection(String words) {
        ArrayStack<Character> stack = new ArrayStack<>(5);
        // words = words.replaceAll("\\s", ""); 是否去空格
        for (int i = 0; i < words.length(); i++) {
            stack.push(words.charAt(i));
        }
        StringBuilder newValue = new StringBuilder();
        for (int i = 0; i < words.length(); i++) {
            if (!stack.isEmpty()) {
                Character character = stack.pop();
                newValue.append(character);
            }
        }
        return words.equals(newValue.toString());
    }

    public static void main(String[] args) {
        ArrayStack<String> stack = new ArrayStack<>(5);
        stack.push("唐僧");
        stack.push("猪八戒");
        stack.push("孙悟空");
        stack.push("沙僧");
        stack.push("观音");
        stack.list();
        System.out.println(stack.isFull());
        String pop = stack.pop();
        System.out.println(pop);
        stack.list();
        System.out.println(stack.isFull());
        System.out.println(stack.size());
        System.out.println(">>>>>>>>>>>>>>>>>>");
        System.out.println(stack.pop());
        boolean flag = detection("c oo   c");
        System.out.println(flag);
    }
}
