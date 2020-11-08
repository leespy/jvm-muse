package day1;

/**
 * 设置最大栈内存为-Xss160K，造成StackOverflowError异常
 * <p>
 * Author muse
 */
public class StackOverflowTest {

    public static void main(String[] args) {
        while (true) {
            count();
        }
    }

    private static void count() {
        Student student = new Student();
        count();
    }
}


