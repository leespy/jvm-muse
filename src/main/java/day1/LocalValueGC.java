/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package day1;

/**
 * 局部变量表GC和槽位复用
 *
 * Author muse
 */
public class LocalValueGC {

    public static void main(String[] args) {
        LocalValueGC localValueGC = new LocalValueGC();
        localValueGC.Gc1();
        localValueGC.Gc2();
        localValueGC.Gc3();
        localValueGC.Gc4();
        localValueGC.Gc5();
    }

    public void Gc1() {
        int[] a = {1, 2, 3}; // 存在着引用
        System.gc();
    }

    public void Gc2() {
        int[] a = {1, 2, 3};
        a = null; // 失去了引用
        System.gc();
    }

    public void Gc3() {
        {
            int[] a = {1, 2, 3};
        }
        System.gc();
    }

    public void Gc4() {
        {
            int[] a = {1, 2, 3};
        }
        int b = 100;
        System.gc();
    }

    Student student; // 逃逸了
    public void Gc5() {
        student = new Student();
        Gc1(); // Gc1的方法执行完毕，已经执行了出栈帧的操作，a已经失去引用，可以被销毁
        System.gc();
    }

    public void Gc6() {
        Student student = new Student();
        Gc1(); // Gc1的方法执行完毕，已经执行了出栈帧的操作，a已经失去引用，可以被销毁
        System.gc();
    }
}
