package com.renderer.sceneelements;

import com.renderer.math.Vector3d;

public abstract class SceneElement implements Rendereable {
    protected Vector3d location;

    public SceneElement(Vector3d location) {
        this.location = location;
    }

    public Vector3d getLocation() {
        return location;
    }

    public void setLocation(Vector3d newLocation) {
        location = newLocation;
    }
}
