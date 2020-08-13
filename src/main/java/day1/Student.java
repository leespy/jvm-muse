package day1;

/**
 * Date 2020/8/5 9:11 上午
 * Author muse
 */
public class Student {
    private String name;
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setName("muse");
    }
}
