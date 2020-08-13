package day1;

import java.lang.ref.SoftReference;

/**
 * Date 2020/8/3 9:21 下午
 * Author muse
 */
public class SoftReferenceTest {

    public static void main(String[] args) {

        System.out.println("-Xmx" + Runtime.getRuntime().maxMemory() / 1000000 + "M");
        System.out.println("free" + Runtime.getRuntime().freeMemory() / 1000000 + "M");

        Teacher teacher = new Teacher("aaa", 15);
        SoftReference reference = new SoftReference(teacher);
        teacher=null;
        System.out.println("Student=" + reference.get());
        System.gc();
        System.out.println("---------System.gc()----------");
        System.out.println("Student=" + reference.get());

        byte[] bytes = new byte[22*1000000];
        System.gc();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("---------new byte[1024*1024*1]----------");
        System.out.println("Student=" + reference.get());
    }
}

class Teacher{

    private String name;

    private Integer age;

    public Teacher(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

