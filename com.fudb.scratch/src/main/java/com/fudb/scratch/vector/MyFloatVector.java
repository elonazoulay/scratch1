package com.fudb.scratch.vector;

import jdk.incubator.vector.FloatVector;

public class MyFloatVector {
    private final FloatVector first;
    private final FloatVector second;
    private final int size;

    public MyFloatVector(float[] a, float[] b) {
        this.first = FloatVector.fromArray(FloatVector.SPECIES_128, a, 0);
        this.second = FloatVector.fromArray(FloatVector.SPECIES_128, b, 0);
        this.size = a.length;
    }

    public float[] radius() {
        float[] result = new float[size];
        first.pow(2).add(second.pow(2)).sqrt().intoArray(result, 0);
        return result;
    }
}
