package com.fudb.scratch;

import com.fudb.scratch.vector.MyFloatVector;
import jdk.incubator.vector.FloatVector;
import org.testng.annotations.Test;

import static java.lang.String.format;

public class TestMyVector2 {
    @Test
    public void testFloatVector() {

        float[] a = {3, 5, 7, 11};
        float[] b = {4, 12, 24, 60};
        MyFloatVector myFloatVector = new MyFloatVector(a, b);
        float[] c = myFloatVector.radius();
        FloatVector floatVector = FloatVector.fromArray(FloatVector.SPECIES_128, c, 0);
        floatVector.mul(2).intoArray(c, 0);
        for (int i = 0; i < c.length; i++) {
            System.out.println(format("a: %s, b: %s, c: %s", a[i], b[i], c[i]));
        }
    }
}
