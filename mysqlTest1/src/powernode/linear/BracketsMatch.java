package powernode.linear;

/**
 * 使用栈匹配特殊符号是否成对出现
 */
public class BracketsMatch {
    public static void main(String[] args) {
        System.out.println(isMatch("(不知火舞)(孙尚香)"));
        System.out.println(isMatch("不知火舞((孙悟空))"));
        System.out.println(isMatch("后裔(刘邦(虞姬)(妲己)鲁班)"));
        System.out.println(isMatch("不知火舞(孙悟空))"));
        System.out.println(isMatch("((不知火舞)虞姬"));
    }

    /**
     * 判断括号匹配是否成对出现
     * @param str 字符串
     * @return 括号匹配是否成对出现
     */
    public static boolean isMatch(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char bracket = str.charAt(i);
            if (bracket == '(') {
                stack.push(bracket);
            }
            if (bracket == ')') {
                Character word = stack.pop();
                if (word == null) {
                    return false;
                }
            }
        }
        return stack.size() == 0;
        // 1.扫描字符串
        // 2.从左向右依次获取每一个字符
        // 3.判断当前字符串是否为左括号"（"
        // 4.如果是左括号则放入栈中
        // 5.如果是右括号则去栈中弹出对应的左括号
        // 6.如果弹出的是空值，则表示该字符串不匹配
        // 7.如果字符串遍历结束，栈中依然存在左括号，则该字符串不匹配
        // 8.字符串遍历结束，对应的右括号都能在栈中弹出左括号，并且栈为空，则表示匹配成功
    }
}
