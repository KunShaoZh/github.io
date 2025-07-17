package powernode.investigation;

public class Test01 {
    public static void main(String[] args) {
        int a = 68;
        a %= 100;
        System.out.println(a);

        int mold = 10;
        int div = 1;
        for (int i = 0; i < 4; i++, mold *= 10, div *= 10) {
            System.out.println("i的值：" + i);
            System.out.println("mold的值：" + mold);
            System.out.println("div的值" + div);
        }


    }
}
