package powernode.investigation;

import java.util.ArrayList;
import java.util.List;

public class Test08 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(5);
        System.out.println(list);

        /*for (Integer l : list) {
            if (l == 2) {
                list.remove(l);
            }
        }*/

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 2) {
                list.remove(i);
            }
        }

        System.out.println(list);
    }
}
