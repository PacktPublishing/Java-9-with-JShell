package com.renderer.shapes.polyhedrons;

import com.renderer.math.Vector3d;
import com.renderer.shapes.Shape;
import com.renderer.lights.Light;
import java.util.stream.Collectors;

public class Cube extends Shape {
    protected int edgeLength;

    public Cube(Vector3d location, int edgeLength) {
        super(location);
        this.edgeLength = edgeLength;
    }
    
    public int getEdgeLength() {
        return edgeLength;
    }

    public void setEdgeLength(int newEdgeLength) { 
        edgeLength = newEdgeLength;
    }

    @Override
    public void render() {
        if (!isValidForRender()) {
            System.out.println(
                "Setup wasn't completed to render the cube.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(
            "Drew cube at %s with edge length equal to %d\n",
            location,
            edgeLength));
        String consideringLights = 
            generateConsideringLights();
        sb.append(consideringLights);
        System.out.println(sb.toString());
    }
}
