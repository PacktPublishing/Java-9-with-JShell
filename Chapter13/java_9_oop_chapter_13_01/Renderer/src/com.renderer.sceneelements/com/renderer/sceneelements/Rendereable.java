package com.renderer.sceneelements;

import com.renderer.math.Vector3d;

public interface Rendereable {
    Vector3d getLocation();
    void setLocation(Vector3d newLocation);
    void render();
}
