package powernode.binary.tree;

public class TestApp {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        Node root = new Node(1,"孙尚香");
        Node node2 = new Node(2,"夏侯惇");
        Node node3 = new Node(3,"貂蝉");
        Node node4 = new Node(4,"吕布");
        Node node5 = new Node(5,"虞姬");
        Node node6 = new Node(6,"王昭君");
        Node node7 = new Node(7, "程咬金");
        Node node8 = new Node(8, "李元芳");
        Node node9 = new Node(9, "小乔");
        Node node10 = new Node(10, "安其拉");
        Node node11 = new Node(11, "姜子牙");
        Node node12 = new Node(12, "张良");
        root.setLeft(node2);
        node2.setLeft(node3);
        root.setRight(node4);
        node4.setRight(node5);
        node4.setLeft(node6);
        node2.setRight(node7);
        node3.setRight(node8);
        node7.setLeft(node9);
        node3.setLeft(node10);
        node5.setLeft(node11);
        node5.setRight(node12);

        binaryTree.setRoot(root);
        binaryTree.preOrder();
        System.out.println("-------------------");
        binaryTree.preOrder2();
        System.out.println("-------------------");
        binaryTree.preWhileOrder();
        System.out.println("===================");
        binaryTree.infixOrder();
        System.out.println("===================");
        binaryTree.infixOrder2();
        System.out.println("===================");
        binaryTree.infixWhileOrder();
        System.out.println(">>>>>>>>>>>>>>>>>>>");
        binaryTree.postOrder();
        System.out.println(">>>>>>>>>>>>>>>>>>>");
        binaryTree.postOrder2();
        System.out.println(">>>>>>>>>>>>>>>>>>>");
        binaryTree.postWhileOrder();
        System.out.println(">>>>>>>>>>>>>>>>>>");
        System.out.println(binaryTree.preSearch(5));
        System.out.println(binaryTree.preSearch2(5));
        System.out.println(binaryTree.preWhileSearch(5));
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println(binaryTree.infixSearch(4));
        System.out.println(binaryTree.infixSearch2(4));
        System.out.println(binaryTree.infixWhileSearch(4));
        System.out.println("{{{{{{{{{{{{{{{{{{{{{{{{{");
        System.out.println(binaryTree.postSearch(8));
        System.out.println(binaryTree.postSearch2(8));
        System.out.println(binaryTree.postWhileSearch(8));

    }
}
