package day1;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * 直接内存泄漏 -XX:+PrintGCDetails
 *
 * Date 2020/8/11 8:49 上午
 * Author muse
 */
public class DirectMemoryTest {

    public static void main(String[] args) {
        int num = 1;
        while (true) {
//            if (num >= 100) {
//                break;
//            }
            ByteBuffer.allocateDirect(1*1024*1024);
            // System.out.println("num=" + num++);
        }

//        List<ByteBuffer> total = new ArrayList<>();
//        while (true) {
//            if (num >= 20) {
//                break;
//            }
//            total.add(ByteBuffer.allocateDirect(2000*1024*1024));
//            System.out.println("num=" + num++);
//        }
    }
}
