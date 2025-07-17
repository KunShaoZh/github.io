package powernode.demo;

public class TestApp {
    public static void main(String[] args) {
        Student student1 = new Student(1, 18, "zhangshan");
        Student student2 = new Student(2, 19, "lisi");
        String max = getMax(student2, student1);
        System.out.println(max);
    }

    public static String getMax (Student student1, Student student2) {
        if (student1.compareTo(student2) > 0) {
            return student1.getName();
        } else if (student1.compareTo(student2) == 0) {
            return "zhangsan和lisi一样大";
        } else {
            return student2.getName();
        }
    }
}
