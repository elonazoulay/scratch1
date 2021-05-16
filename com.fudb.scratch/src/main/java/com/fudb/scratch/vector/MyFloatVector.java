package com.fudb.scratch.vector;

import jdk.incubator.vector.FloatVector;

import java.util.Arrays;

import static java.util.Objects.requireNonNull;

public class MyFloatVector {
    private final float[] first;
    private final float[] second;
    private final int size;

    public MyFloatVector(float[] a, float[] b) {
        requireNonNull(a);
        requireNonNull(b);
        if (a.length != b.length) {
            throw new IllegalStateException("a and b must have equal lengths");
        }
        this.first = Arrays.copyOf(a, a.length);
        this.second = Arrays.copyOf(b, b.length);
        this.size = a.length;
    }

    public float[] radius() {
        float[] result = new float[size];
        int upperBound = FloatVector.SPECIES_PREFERRED.loopBound(size);
        int i = 0;
        for (; i < upperBound; i += FloatVector.SPECIES_PREFERRED.length()) {
            var va = FloatVector.fromArray(FloatVector.SPECIES_PREFERRED, first, i);
            var vb = FloatVector.fromArray(FloatVector.SPECIES_PREFERRED, second, i);
            va.pow(2);
            vb.pow(2);
            va.add(vb).sqrt().intoArray(result, i);
        }
        for (; i < size; i++) {
            result[i] = ((Double) Math.sqrt(first[i] * first[i] + second[i] * second[i])).floatValue();
        }
        return result;
    }
}
