package day1;

/**
 * 设置最大栈内存为-Xss160K，造成StackOverflowError异常
 * <p>
 * Date 2020/8/5 1:19 下午
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


