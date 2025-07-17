package powernode.investigation;

import java.util.ArrayList;
import java.util.List;

public class Test02 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        for (Integer integer : list) {
            System.out.println(integer);
        }
        list.removeAll(list);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
