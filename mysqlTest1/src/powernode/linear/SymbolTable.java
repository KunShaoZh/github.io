package powernode.linear;

import java.util.HashMap;
import java.util.Map;

/**
 * 链表实现符号表
 * @param <K>
 * @param <V>
 */
public class SymbolTable<K,V>{
    private int count;
    private Node head;

    public SymbolTable() {
        this.count = 0;
        this.head = new Node(null, null, null);
    }

    private class Node{
        private K key;
        private V value;
        private Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public int size() {
        return this.count;
    }

    public void put(K k, V v) {
        //System.out.println(k);
        int a = hash(k);
        System.out.println(a);
        Node cursor = head;
        while (cursor.next != null) {
            cursor = cursor.next;
            if (cursor.key.equals(k)) {
                cursor.value = v;
                return;
            }
        }
        cursor.next = new Node(k, v, null);
        count++;
    }

    public V get(K key) {
        Node cursor = head;
        while (cursor.next != null) {
            cursor = cursor.next;
            if (cursor.key.equals(key))
                return cursor.value;
        }
        return null;
    }

    public void remove(K key) {
        Node cursor = head;
        while (cursor.next != null) {
            if (cursor.next.key.equals(key)) {
                cursor.next = cursor.next.next;
                count--;
                return;
            }
            cursor = cursor.next;
        }
    }

    public static int hash(Object k) {
        //System.out.println(k.hashCode());
        int h;
        return (k == null) ? 0 : (h = k.hashCode()) ^ (h >>> 16);
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        String put = map.put("射手", "黄忠");

        SymbolTable<String, String> symbolTable = new SymbolTable<>();
        System.out.println(symbolTable.size());
        symbolTable.put("射手1号", "孙尚香");
        symbolTable.put("射手2号", "百里守约");
        symbolTable.put("射手3号", "鲁班七号");
        symbolTable.put("射手4号", "李元芳");
        symbolTable.put("射手5号", "后裔");
        System.out.println(symbolTable.size());
        System.out.println(symbolTable.get("射手1号"));
        System.out.println(symbolTable.get("射手4号"));
        symbolTable.remove("射手3号");
        System.out.println(symbolTable.size());
        System.out.println("----------------------------------");
        System.out.println(Integer.toBinaryString(2));

    }

}
