package powernode.investigation;

import java.util.Arrays;

public class Test04 {
    public static void main(String[] args) {
        int[] arr01 = new int[10];
        for (int i = 0; i < arr01.length; i++) {
            arr01[i] = (int)(Math.random() * 10);
        }
        int[] arr04 = Arrays.copyOf(arr01, arr01.length);

        System.out.println("arr01数组元素：" + Arrays.toString(arr01));
        System.out.println("arr04数组元素：" + Arrays.toString(arr04));
    }
}
