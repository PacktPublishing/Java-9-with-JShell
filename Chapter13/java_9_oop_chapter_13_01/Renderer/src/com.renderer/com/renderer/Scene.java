package com.renderer;

import com.renderer.math.Vector3d;
import com.renderer.cameras.Camera;
import com.renderer.lights.Light;
import com.renderer.shapes.Shape;
import java.util.*;

public class Scene {
    protected List<Light> lights;
    protected List<Shape> shapes;
    protected Camera activeCamera;

    public Scene(Camera activeCamera) {
        this.activeCamera = activeCamera;
        this.lights = new ArrayList<>();
        this.shapes = new ArrayList<>();
    }

    public void addLight(Light light) {
        this.lights.add(light);
    }

    public void addShape(Shape shape) {
        this.shapes.add(shape);
    }

    public void render() {
        activeCamera.render();
        lights.forEach(Light::render);
        shapes.forEach(shape -> {
            shape.setActiveCamera(activeCamera);
            shape.setLights(lights);
            shape.render();
        });
    }
}
