package powernode.binary;

/**
 * 链式存储实现树，树存储符号表格式内容，二叉树的所有api都可以通过三种方式来实现，this结点内部实现，指针递归实现，while循环实现，其中this结点
 * 内部实现与指针递归实现可读性强，代码简洁
 * @param <K>
 * @param <V>
 */
public class BinaryTree<K extends Comparable<K>, V> {
    private Node root; // 记录根节点
    private int count;

    public int size() {
        return this.count;
    }
    /**
     * 向树中插入一个键值对
     * @param key 键
     * @param value 值
     */
    public void put(K key, V value) {
        root = put(root, key, value);
    }

    /**
     * 给指定树node上添加一个键值对，并返回添加元素后的新树
     * @param node 当前结点
     * @param key 键
     * @param value 值
     * @return 逐级返回结点
     */
    private Node put(Node node, K key, V value) {
        if (node == null) {
            count++;
            return new Node(key, value, null, null);
        }
        int syc = key.compareTo(node.key);
        if (syc > 0) {//新结点的 key 大于当前结点的 key，继续找当前结点的右子结点
            node.right = put(node.right, key, value);
        } else if (syc < 0) {//新结点的 key 小于当前结点的 key，继续找当前结点的左子结点
            node.left = put(node.left, key, value);
        } else {//新结点的 key 等于当前结点的 key，把当前结点的 value 进行替换
            node.value = value;
        }
        return node;
    }

    /**
     * 通过指针来实现插入
     * @param key 键
     * @param value 值
     */
    public void putValue(K key, V value) {
        Node cursor = root; // 定义指针指向根节点
        if (cursor == null) {
            cursor = new Node(key, value, null, null);
            root = cursor;
            count++;
        } else {
            while (true) {
                int syc = key.compareTo(cursor.key);
                if (syc > 0) {
                    if (cursor.right == null) {// 如果右子结点为空，说明已经找到最后一个结点，创建新的右子节点
                        cursor.right = new Node(key, value, null, null);
                        count++;
                        break;
                    }
                    cursor = cursor.right;
                } else if (syc < 0) {
                    if (cursor.left == null) {// 如果左子结点为空，说明已经找到最后一个结点，创建新的左子结点
                        cursor.left = new Node(key, value, null, null);
                        count++;
                        break;
                    }
                    cursor = cursor.left;
                } else {
                    cursor.value = value;
                    break;
                }
            }
        }
    }

    /**
     * 根据key，从树中找出对应的值，指针法，第三者角度
     * @param key 键
     * @return value值
     */
    public V get(K key) {
        return get(root, key);
    }

    /**
     * 从指定的树 node 中，查找 key 对应的值，指针法，第三者角度
     * @param node 当前结点
     * @param key 键
     * @return value值
     */
    private V get(Node node, K key) {
        if (node == null) {
            return null;
        }
        int syc = key.compareTo(node.key);
        if (syc > 0) {
            return get(node.right, key);//如果要查询的 key 大于当前结点的 key，则继续找当前结点的右子结点；
        } else if (syc < 0) {
            return get(node.left, key);//如果要查询的 key 小于当前结点的 key，则继续找当前结点的左子结点；
        } else {
            return node.value;
        }
    }

    /**
     * 通过指针实现查询key对应的值
     * @param key 键
     * @return 返回对应键的值
     */
    public V getValue(K key) {
        Node cursor = root;// 定义指针指向根节点
        if (cursor == null) {
            return null;
        }
        while (true) {
            int syc = key.compareTo(cursor.key);
            if (syc > 0) {
                if (cursor.right == null) {// 如果右子结点为空，说明已经找到最后一个结点，没有找到对应key的value
                    return null;
                }
                cursor = cursor.right;
            } else if (syc < 0) {
                if (cursor.left == null) {// 如果左子结点为空，说明已经找到最后一个结点，没有找到对应key的value
                    return null;
                }
                cursor = cursor.left;
            } else {
                return cursor.value;
            }
        }
    }

    /**
     * 根据key，删除对应的键值对
     * @param key 键
     */
    public void delete(K key) {
        root = delete(root, key);
    }

    /**
     * 删除指定树node上的键为key的键值对，并返回删除后的新树
     * @param node 当前结点
     * @param key 键
     * @return 逐级返回结点
     */
    private Node delete(Node node, K key) {
        if(node == null) {
            return null;
        }
        int syc = key.compareTo(node.key);
        if (syc > 0) {
            node.right = delete(node.right, key);//新结点的 key 大于当前结点的 key，继续找当前结点的右子结点
        } else if (syc < 0) {
            node.left = delete(node.left, key);//新结点的 key 小于当前结点的 key，继续找当前结点的左子结点
        } else { // 结点替换
            //新结点的key等于当前结点的key,当前x就是要删除的结点
            //1.如果当前结点的右子树不存在，则直接返回当前结点的左子结点，当左子结点也为null时，则返回的结果为null
            if (node.right == null) {
                count--;
                return node.left;
            }
            //2.如果当前结点的左子树不存在，则直接返回当前结点的右子结点，当右子结点也为null时，则返回的结果为null
            if (node.left == null) {
                count--;
                return node.right;
            }
            //3.当前结点的左右子树都存在
            //3.1 找到右子树中最小的结点
            Node minNode = node.right;
            while (minNode.left != null) {
                minNode = minNode.left;
            }
            //3.2 删除右子树中最小的结点
            Node n = node.right;
            while (n.left != null) {
                if (n.left.left == null) {
                    if (n.left.right != null) {// 判断最小结点是否有右子节点
                        n.left = n.left.right;// 如果最小结点有右子结点，则让最小结点父节点指向最小结点的右子结点
                        break;// 这里一定要结束循环，否则n.left被重新赋值以后还会进入到循环
                    } else {
                        n.left = null;// 最小结点没有右子结点，让最小结点指向null
                    }
                } else {
                    n = n.left;
                }
            }
            //3.3 让被删除结点的左子树成为最小结点minNode的左子树，让被删除结点的右子树成为最小结点minNode的右子树
            minNode.left = node.left;
            minNode.right = node.right;
            //3.4 让被删除结点的父节点指向最小结点 minNode
            node = minNode;
            count--;
        }
        return node;
    }

    /**
     * 找出二叉树中最小的键
     * @return 最小键
     */
    public K min() {
        return min(root);
    }

    private K min(Node node) {
        if (node == null) { // 判断根结点是否为空
            return null;
        }
        if (node.left != null) {
            return min(node.left);
        } else {
            return node.key;
        }
    }

    public K minKey() {
        Node cursor = root;
        if (cursor == null) {
            return null;
        }
        while (cursor.left != null) {
            cursor = cursor.left;
        }
        return cursor.key;
    }

    /**
     * 找出二叉树中最大键
     * @return 最大键
     */
    public K max() {
        return max(root);
    }

    private K max(Node node) {
        if (node == null) { // 判断根结点是否为空
            return null;
        }
        if (node.right != null) {
            return max(node.right);
        } else {
            return node.key;
        }
    }

    public K maxKey() {
        Node cursor = root;
        if (cursor == null)
            return null;
        while (cursor.right != null) {
            cursor = cursor.right;
        }
        return cursor.key;
    }

    private class Node {
        private K key;
        private V value;
        private Node left;
        private Node right;

        public Node(K key, V value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        BinaryTree<Integer, String> bt = new BinaryTree<>();
        bt.put(20, "二哈");
        bt.put(16, "张三");
        bt.put(9, "李四");
        bt.put(15, "王五");
        System.out.println(bt.size());
        bt.put(3,"老三");
        System.out.println(bt.get(3));
        System.out.println(bt.size());
        bt.delete(3);
        System.out.println(">>>>>>>>>>>>>>>>>>>");
        System.out.println(bt.get(3));
        System.out.println(bt.size());
        System.out.println("--------------------");
        bt.put(3, "关羽");
        bt.put(18, "张飞");
        bt.put(13, "黄忠");
        bt.put(14, "赵云");
        bt.put(33, "马超");
        bt.delete(9);
        System.out.println(bt.size());
        System.out.println(bt.get(14));
        bt.delete(99);
        System.out.println(bt.min());
        System.out.println(bt.minKey());
        System.out.println(bt.max());
        System.out.println(bt.maxKey());
    }

}
