package com.renderer.math;

public class Vector3d {
    public int x;
    public int y;
    public int z;

    public Vector3d(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3d(int valueForXYZ) {
        this(valueForXYZ, valueForXYZ, valueForXYZ);
    }

    public Vector3d() {
        this(0);
    }

    public void absolute() {
        x = Math.abs(x);
        y = Math.abs(y);
        z = Math.abs(z);
    }

    public void negate() {
        x = -x;
        y = -y;
        z = -z;
    }

    public void add(Vector3d vector) {
        x += vector.x;
        y += vector.y;
        z += vector.z;
    }

    public void sub(Vector3d vector) {
        x -= vector.x;
        y -= vector.y;
        z -= vector.z;
    }

    public String toString() {
        return String.format(
            "(x: %d, y: %d, z: %d)",
            x,
            y,
            z);
    }
}
