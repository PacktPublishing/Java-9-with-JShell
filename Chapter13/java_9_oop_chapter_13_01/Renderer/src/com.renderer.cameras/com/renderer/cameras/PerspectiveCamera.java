package com.renderer.cameras;

import com.renderer.math.Vector3d;

public class PerspectiveCamera extends Camera {
    protected Vector3d direction;
    protected Vector3d vector;
    protected int fieldOfView;
    protected int nearClippingPlane;
    protected int farClippingPlane;

    public Vector3d getDirection() {
        return direction;
    }

    public void setDirection(Vector3d newDirection) {
        direction = newDirection;
    }

    public Vector3d getVector() {
        return vector;
    }

    public void setVector(Vector3d newVector) {
        vector = newVector;
    }

    public int getFieldOfView() {
        return fieldOfView;
    }
    
    public void setFieldOfView(int newFieldOfView) {
        fieldOfView = newFieldOfView;
    }

    public int nearClippingPlane() {
        return nearClippingPlane;
    }

    public void setNearClippingPlane(int newNearClippingPlane) {
        this.nearClippingPlane = newNearClippingPlane;
    }

    public int farClippingPlane() {
        return farClippingPlane;
    }

    public void setFarClippingPlane(int newFarClippingPlane) {
        this.farClippingPlane = newFarClippingPlane;
    }

    public PerspectiveCamera(Vector3d location, 
        Vector3d direction, Vector3d vector, 
        int fieldOfView, int nearClippingPlane, 
        int farClippingPlane) {
        super(location);
        this.direction = direction;
        this.vector = vector;
        this.fieldOfView = fieldOfView;
        this.nearClippingPlane = nearClippingPlane;
        this.farClippingPlane = farClippingPlane;
    }

    @Override
    public void render() {
        System.out.println(
            String.format("Created camera at %s",
                location));
        System.out.println(
            String.format("Set camera direction to %s",
                direction));
        System.out.println(
            String.format("Set camera vector to %s",
                vector));
        System.out.println(
            String.format("Set camera perspective field of view to: %d",
                fieldOfView));
        System.out.println(
            String.format("Set camera near clipping plane to: %d", 
                nearClippingPlane));
        System.out.println(
            String.format("Set camera far clipping plane to: %d",
                farClippingPlane));
    }
}
