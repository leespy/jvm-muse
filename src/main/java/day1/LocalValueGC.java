/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package day1;

/**
 * 局部变量表GC和槽位复用
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

    // 大家都说，这个会被垃圾回收  但是，不会！
    public void Gc1() {
        int[] a = {1, 2, 3}; // 存在着引用
        System.gc();
    }

    // 可以被回收
    public void Gc2() {
        int[] a = {1, 2, 3};
        a = null; // 失去了引用
        System.gc();
    }

    // a已经不在自己的作用域，不能。存在局部变量表中，并且没有失去引用，
    public void Gc3() {
        {
            int[] a = {1, 2, 3};
        }
        System.gc();
    }

    // 能！槽位复用
    public void Gc4() {
        {
            int[] a = {1, 2, 3};
        }
        int b = 100;
        System.gc();
    }

    // 会被垃圾回收 会不会？  会！
    public void Gc5() {
        Gc1(); // Gc1的方法执行完毕，已经执行了出栈帧的操作，a已经失去引用，可以被销毁
        System.gc();
    }
}
