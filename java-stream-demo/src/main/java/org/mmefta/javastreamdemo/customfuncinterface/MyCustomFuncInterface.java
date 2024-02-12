package org.mmefta.javastreamdemo.customfuncinterface;
@FunctionalInterface
public interface MyCustomFuncInterface {
    void m1();

    // void m2(int, int);  we cannot do that

    default void m2() {
        System.out.println("Default method-m2");
    }

    default void m3() {
        System.out.println("Default method-m3");
    }

    static void m4 () {
        System.out.println("Static method-m4");
    }
}
