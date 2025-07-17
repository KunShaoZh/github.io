package powernode.linear;

public class GoodsNode {
    int Gid;
    String Gname;
    double Gprice;
    GoodsNode next; // 定义指针指向下一个节点

    public GoodsNode(int gid, String gname, double gprice, GoodsNode next) {
        Gid = gid;
        Gname = gname;
        Gprice = gprice;
        this.next = next;
    }
}
