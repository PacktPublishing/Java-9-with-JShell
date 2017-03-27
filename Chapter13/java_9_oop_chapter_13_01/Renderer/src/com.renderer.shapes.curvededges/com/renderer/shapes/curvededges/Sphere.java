package com.renderer.shapes.curvededges;

import com.renderer.math.Vector3d;
import com.renderer.shapes.Shape;
import com.renderer.lights.Light;

public class Sphere extends Shape {
    protected int radius;

    public Sphere(Vector3d location, int radius) {
        super(location);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int newRadius) { 
        radius = newRadius;
    }

    @Override
    public void render() {
        if (!isValidForRender()) {
            System.out.println(
                "Setup wasn't completed to render the sphere.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(
            "Drew sphere at %s with radius equal to %d\n",
            location, 
            radius));
        String consideringLights = 
            generateConsideringLights();
        sb.append(consideringLights);
        System.out.println(sb.toString());
    }
}
