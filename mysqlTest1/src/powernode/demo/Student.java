package powernode.demo;

/**
 * 实现comparable接口进行排序
 * */
public class Student implements Comparable<Student>{

    private int stuId;

    private int age;

    private String name;

    public Student(int stuId, int age, String name) {
        this.stuId = stuId;
        this.age = age;
        this.name = name;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int compareTo(Student o) {
        return this.age - o.age;
    }


}
