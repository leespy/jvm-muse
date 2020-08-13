package day1;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Date 2020/8/10 1:09 上午
 * Author muse
 */
public class FireCPUTest {

    private static Executor executor = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        executor.execute(() -> {
            while (true) {
                System.out.println("i'm working!");
            }
        });
        executor.execute(() -> {
            while (true) {
                System.out.println("i'm sleeping!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        executor.execute(() -> {
            while (true) {
                System.out.println("i'm sleeping too!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
