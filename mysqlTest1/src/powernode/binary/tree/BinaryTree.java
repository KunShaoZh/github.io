package powernode.binary.tree;

import java.util.Stack;

public class BinaryTree {
    private Node root;

    public void setRoot(Node root) {
        this.root = root;
    }

    /**
     * 前序遍历，结点内部实现，递归this
     */
    public void preOrder(){
        if (this.root !=null){
            this.root.preOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    /**
     * 中序遍历，结点内部实现，递归this
     */
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("根结点为空");
        }
    }

    /**
     * 后序遍历，结点内部实现，递归this
     */
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("根结点为空");
        }
    }

    /**
     * 前序遍历，通过自定义指针递归实现，第三者角度
     */
    public void preOrder2() {
        if (this.root == null) {
            System.out.println("根结点为空");
        } else {
            preOrder2(root);
        }
    }


    /**
     * 前序遍历，通过自定义指针递归实现，第三者角度
     * @param cursor 根结点指针
     */
    private void preOrder2(Node cursor) {
        if (cursor == null) {
            return;
        }
        System.out.println(cursor);
        if (cursor.left != null) {
            preOrder2(cursor.left);
        }
        if (cursor.right != null) {
            preOrder2(cursor.right);
        }
    }

    /**
     * 中序遍历，通过自定义指针递归实现，第三者角度
     */
    public void infixOrder2() {
        if (this.root == null) {
            System.out.println("根结点为空");
        } else {
            infixOrder2(root);
        }
    }

    /**
     * 中序遍历，通过自定义指针递归实现，第三者角度
     */
    private void infixOrder2(Node cursor) {
        if (cursor == null) {
            return;
        }
        if (cursor.left != null) {
            infixOrder2(cursor.left);
        }
        System.out.println(cursor);
        if (cursor.right != null) {
            infixOrder2(cursor.right);
        }
    }

    /**
     * 后序遍历，通过自定义指针递归实现，第三者角度
     */
    public void postOrder2() {
        if (this.root == null) {
            System.out.println("根结点为空");
        } else {
            postOrder2(root);
        }
    }

    /**
     * 后序遍历，通过自定义指针递归实现，第三者角度
     */
    private void postOrder2(Node cursor) {
        if (cursor == null) {
            return;
        }
        if (cursor.left != null) {
            postOrder2(cursor.left);
        }
        if (cursor.right != null) {
            postOrder2(cursor.right);
        }
        System.out.println(cursor);
    }

    /**
     * 前序遍历，自定义指针，通过while循环和stack实现
     */
    public void preWhileOrder() {
        if (this.root == null) {
            System.out.println("根结点为空");
        } else {
            preWhileOrder(root);
        }
    }

    /**
     * 前序遍历，自定义指针，通过while循环和stack实现
     */
    private void preWhileOrder(Node cursor) {
        if (cursor == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(cursor);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.println(node); // 访问节点
            // 先右后左，保证左子树先被处理
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    /**
     * 中序遍历，自定义指针，通过while循环和stack实现
     */
    public void infixWhileOrder() {
        if (this.root == null) {
            System.out.println("根结点为空");
        } else {
            infixWhileOrder(root);
        }
    }

    /**
     * 中序遍历，自定义指针，通过while循环和stack实现
     */
    private void infixWhileOrder(Node cursor) {
        if (cursor == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node current = cursor;
        while (current != null || !stack.isEmpty()) {
            // 先访问最左侧的节点，将其入栈，然后转向右子树
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            // 然后处理栈顶元素，转向其右子树
            current = stack.pop();
            System.out.println(current); // 访问节点
            current = current.right; // 转向右子树，为下一轮循环做准备
        }
    }


    /**
     * 后续遍历，自定义指针，通过while循环和stack实现
     */
    public void postWhileOrder() {
        if (this.root == null) {
            System.out.println("根结点为空");
        } else {
            postWhileOrder(root);
        }
    }

    /**
     * 后续遍历，自定义指针，通过while循环和stack实现
     */
    private void postWhileOrder(Node cursor) {
        if (cursor == null) {
            return;
        }
        Stack<Node> stack1 = new Stack<>(); // 主栈，用于存放节点以供后续处理
        Stack<Node> stack2 = new Stack<>(); // 辅助栈，用于存放即将处理的节点（反向顺序）
        stack1.push(cursor); // 初始节点入栈
        while (!stack1.isEmpty()) { // 当主栈不为空时，继续处理节点
            Node node = stack1.pop(); // 从主栈中弹出一个节点进行处理，但不立即访问它（为了后序访问）
            stack2.push(node); // 将该节点推入辅助栈中，稍后访问（因为是反向的）
            if (node.left != null) { // 如果存在左子树，则将左子树入主栈继续处理（深度优先）
                stack1.push(node.left);
            }
            if (node.right != null) { // 如果存在右子树，则将右子树入主栈继续处理（深度优先）
                stack1.push(node.right);
            }
        }
        // 最后，从辅助栈中弹出节点并按顺序访问，实现后序遍历的顺序（左右根 -> 根右左 -> 根左右）
        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop()); // 访问节点
        }
    }

    /**
     * 根据结点id进行遍历查找，前序遍历，结点内部实现，递归this
     */
    public Node preSearch(int no) {
        if (root == null) {
            System.out.println("根结点为空");
            return null;
        } else {
            return this.root.preSearch(no);
        }
    }

    /**
     * 根据结点id进行遍历查找，中序遍历，结点内部实现，递归this
     */
    public Node infixSearch(int no) {
        if (root == null) {
            System.out.println("根结点为空");
            return null;
        } else {
            return this.root.infixSearch(no);
        }
    }

    /**
     * 根据结点id进行遍历查找，后序遍历，结点内部实现，递归this
     */
    public Node postSearch(int no) {
        if (root == null) {
            System.out.println("根结点为空");
            return null;
        } else {
            return this.root.postSearch(no);
        }
    }

    /**
     * 根据结点id进行遍历查找，前序遍历，通过自定义指针递归实现，第三者角度
     */
    public Node preSearch2(int no) {
        if (this.root == null) {
            return null;
        } else {
            return preSearch2(root, no);
        }
    }

    /**
     * 根据结点id进行遍历查找，前序遍历，通过自定义指针递归实现，第三者角度
     */
    private Node preSearch2(Node cursor, int no) {
        if (cursor.no == no) {
            return cursor;
        }
        Node node = null;
        if (cursor.left != null) node = preSearch2(cursor.left, no);
        if (node != null) return node;
        if (cursor.right != null) node = preSearch2(cursor.right, no);
        return node;
    }

    /**
     * 根据结点id进行遍历查找，中序遍历，通过自定义指针递归实现，第三者角度
     */
    public Node infixSearch2(int no) {
        if (this.root == null) {
            return null;
        } else {
            return infixSearch2(root, no);
        }
    }

    /**
     * 根据结点id进行遍历查找，中序遍历，通过自定义指针递归实现，第三者角度
     */
    private Node infixSearch2(Node cursor, int no) {
        Node node = null;
        if (cursor.left != null) node = infixSearch2(cursor.left, no);
        if (node != null) return node;
        if (cursor.no == no) {
            return cursor;
        }
        if (cursor.right != null) node = infixSearch2(cursor.right, no);
        return node;
    }

    /**
     * 根据结点id进行遍历查找，后序遍历，通过自定义指针递归实现，第三者角度
     */
    public Node postSearch2(int no) {
        if (this.root == null) {
            return null;
        } else {
            return postSearch2(root, no);
        }
    }

    /**
     * 根据结点id进行遍历查找，后序遍历，通过自定义指针递归实现，第三者角度
     */
    private Node postSearch2(Node cursor, int no) {
        Node node = null;
        if (cursor.left != null) node = postSearch2(cursor.left, no);
        if (node != null) return node;
        if (cursor.right != null) node = postSearch2(cursor.right, no);
        if (node != null) return node;
        if (cursor.no == no) {
            return cursor;
        }
        return null;
    }

    /**
     * 根据结点id进行遍历查找，前序遍历，自定义指针，通过while循环和stack实现
     */
    public Node preWhileSearch(int no) {
        if (this.root == null) {
            return null;
        } else {
            return preWhileSearch(root, no);
        }
    }

    /**
     * 根据结点id进行遍历查找，前序遍历，自定义指针，通过while循环和stack实现
     */
    private Node preWhileSearch(Node cursor, int no) {
        if (cursor == null) {
            return null;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(cursor);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (node.no == no) return node;
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return null;
    }

    /**
     * 根据结点id进行遍历查找，中序遍历，自定义指针，通过while循环和stack实现
     */
    public Node infixWhileSearch(int no) {
        if (this.root == null) {
            return null;
        } else {
            return infixWhileSearch(root, no);
        }
    }

    /**
     * 根据结点id进行遍历查找，中序遍历，自定义指针，通过while循环和stack实现
     */
    private Node infixWhileSearch(Node cursor, int no) {
        if (cursor == null) return null;
        Stack<Node> stack = new Stack<>();
        while (cursor != null || !stack.isEmpty()) {
            while (cursor != null) {
                stack.push(cursor);
                cursor = cursor.left;
            }
            cursor = stack.pop();
            if (cursor.no == no) return cursor;
            cursor = cursor.right;
        }
        return null;
    }

    /**
     * 根据结点id进行遍历查找，前序遍历，自定义指针，通过while循环和stack实现
     */
    public Node postWhileSearch(int no) {
        if (this.root == null) {
            return null;
        } else {
            return postWhileSearch(root, no);
        }
    }

    /**
     * 根据结点id进行遍历查找，前序遍历，自定义指针，通过while循环和stack实现
     */
    private Node postWhileSearch(Node cursor, int no) {
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(cursor);
        while (!stack1.isEmpty()) {
            Node node = stack1.pop();
            stack2.push(node);
            if (node.left != null) stack1.push(node.left);
            if (node.right != null) stack1.push(node.right);
        }
        while (!stack2.isEmpty()) {
            Node node = stack2.pop();
            if (node.no == no) {
                return node;
            }
        }
        return null;
    }

}
