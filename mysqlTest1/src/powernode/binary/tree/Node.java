package powernode.binary.tree;

public class Node{
    public int no;
    public String name;
    public Node right;
    public Node left;

    public Node(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    /**
     * 前序遍历，this指针内部实现，当事人角度
     */
    public void preOrder() {
        System.out.println(this);
        if(this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    /**
     * 中序遍历，this指针内部实现，当事人角度
     */
    public void infixOrder() {
        if(this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    /**
     * 后序遍历，this指针内部实现，当事人角度
     */
    public void postOrder() {
        if(this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    /**
     * 根据结点id进行遍历查找，前序遍历
     */
    public Node preSearch(int no) {
        // 判断是否是当前结点
        if (this.no == no) {
            return this;
        }
        Node node = null;
        // 判断当前结点的左子结点是否为空，如果不是空，则递归前序查找,如果左递归前序查找，找到结点，则返回
        if (this.left != null) node = this.left.preSearch(no);
        // 左递归前序查找，找到结点，则返回否则继续判断
        if (node != null) return node;
        // 当前的结点的右子结点是否为空，如果不空，则继续像右递归前序查找
        if (this.right != null) {
            node = this.right.preSearch(no);
        }
        return node;
    }

    /**
     * 根据结点id进行遍历查找，中序遍历
     */
    public Node infixSearch(int no) {
        Node node = null;
        // 判断当前结点的左子结点是否为空，如果不是空，则递归前序查找,如果左递归前序查找，找到结点，则返回
        if (this.left != null) node = this.left.infixSearch(no);
        // 左递归前序查找，找到结点，则返回否则继续判断
        if (node != null) return node;
        // 判断是否是当前结点
        if (this.no == no) return this;
        // 当前的结点的右子结点是否为空，如果不空，则继续像右递归前序查找
        if (this.right != null) node = this.right.infixSearch(no);
        return node;
    }

    /**
     * 根据结点id进行遍历查找，后序遍历
     */
    public Node postSearch(int no) {
        Node node = null;
        // 判断当前结点的左子结点是否为空，如果不是空，则递归前序查找,如果左递归前序查找，找到结点，则返回
        if (this.left != null) node = this.left.postSearch(no);
        // 左递归前序查找，找到结点，则返回否则继续判断
        if (node != null) return node;
        // 当前的结点的右子结点是否为空，如果不空，则继续像右递归前序查找
        if (this.right != null) node = this.right.postSearch(no);
        if (node != null) return node;
        // 判断是否是当前结点
        if (this.no == no) return this;
        return null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
