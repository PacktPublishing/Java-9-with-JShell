package com.renderer.cameras;

import com.renderer.math.Vector3d;
import com.renderer.sceneelements.SceneElement;

public abstract class Camera extends SceneElement {
    public Camera(Vector3d location) {
        super(location);
    }
}
