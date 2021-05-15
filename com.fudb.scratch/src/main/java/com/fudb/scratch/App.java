package com.fudb.scratch;

import com.fudb.scratch.vector.MyFloatVector;

import static java.lang.String.format;

public class App {
    public static void main(String[] args) {
        float[] a = {3, 5, 7, 11};
        float[] b = {4, 12, 24, 60};
        MyFloatVector myFloatVector = new MyFloatVector(a, b);
        float[] c = myFloatVector.radius();
        for (int i = 0; i < c.length; i++) {
            System.out.println(format("a: %s, b: %s, c: %s", a[i], b[i], c[i]));
        }
        System.out.println("fudb");
    }
}
