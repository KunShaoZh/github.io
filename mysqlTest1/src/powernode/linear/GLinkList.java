package powernode.linear;

public class GLinkList {
    private GoodsNode head; //定义头结点

    public GLinkList() {
        this.head = new GoodsNode(0, "", 0.0, null);
    }

    /**
     * 添加商品结点
     * @param goodsNode 商品结点
     */
    public void add(GoodsNode goodsNode) {

        // 定义指针指向头结点
        GoodsNode cursor = head;
        /*while (true) {
            if (cursor.next == null) {
                break;
            }
            cursor = cursor.next;
        }**/
        while (cursor.next != null) {
            cursor = cursor.next;
        }
        cursor.next = goodsNode;
    }


    /**
     * 添加商品结点(按商品id顺序添加)
     * @param goodsNode 商品结点
     */
    public void addByOrder(GoodsNode goodsNode) {
        // 定义指针指向头结点
        GoodsNode cursor = head;
        /*boolean flag = false;
        while (true) {
            if (cursor.next == null) {
                break;
            }
            if (cursor.next.Gid > goodsNode.Gid) {
                break;
            } else if (cursor.next.Gid == goodsNode.Gid){
                flag = true;
                break;
            }
            cursor = cursor.next;
        }
        if (flag) {
            System.out.println("不能添加该商品，已经存在了...");
        } else {
            goodsNode.next = cursor.next;
            cursor.next = goodsNode;
        }**/
        while (cursor.next != null && cursor.next.Gid < goodsNode.Gid) {
            cursor = cursor.next;
        }

        if (cursor.next != null && cursor.next.Gid == goodsNode.Gid) {
            System.out.println("不能添加该商品，已经存在了...");
        } else {
            goodsNode.next = cursor.next;
            cursor.next = goodsNode;
        }
    }

    /**
     * 修改商品结点
     * @param goodsNode 商品结点
     */
    public void updateGoods(GoodsNode goodsNode) {
        if (head.next == null) {
            System.out.println("链表为空...");
        } else {
            //定义指针指向头结点
            GoodsNode cursor = head;
            boolean flag = false;
            while (cursor.next != null) {
                cursor = cursor.next;
                if (cursor.Gid == goodsNode.Gid) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                cursor.Gname = goodsNode.Gname;
                cursor.Gprice = goodsNode.Gprice;
            } else {
                System.out.println("没有找到该结点");
            }
        }
    }

    /**
     * 删除商品结点
     * @param goodsNode 商品结点
     */
    public void removeGoods(GoodsNode goodsNode) {
        if (head.next == null) {
            System.out.println("链表为空...");
        } else {
            //定义指针指向头结点
            GoodsNode cursor = head;
            boolean flag = false;
            while (cursor.next != null) {
                if (cursor.next.Gid == goodsNode.Gid) {
                    flag = true;
                    break;
                }
                cursor = cursor.next;
            }
            if (flag) {
                cursor.next = cursor.next.next;
            } else {
                System.out.println("没有找到该结点");
            }
        }
    }
}
