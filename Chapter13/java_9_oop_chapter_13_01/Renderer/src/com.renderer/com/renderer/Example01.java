package com.renderer;

import com.renderer.math.Vector3d;
import com.renderer.cameras.PerspectiveCamera;
import com.renderer.lights.DirectionalLight;
import com.renderer.shapes.curvededges.Sphere;
import com.renderer.shapes.polyhedrons.Cube;

public class Example01 {
    public static void main(String[] args){
        PerspectiveCamera camera = new PerspectiveCamera(
            new Vector3d(30),
            new Vector3d(50, 0, 0),
            new Vector3d(4, 5, 2),
            90,
            20,
            40);
        Sphere sphere = new Sphere(new Vector3d(20), 8);
        Cube cube = new Cube(new Vector3d(10), 5);
        DirectionalLight light = new DirectionalLight(
            new Vector3d(2, 2, 5), "Cornflower blue");
        Scene scene = new Scene(camera);
        scene.addShape(sphere);
        scene.addShape(cube);
        scene.addLight(light);
        scene.render();
    }
}
