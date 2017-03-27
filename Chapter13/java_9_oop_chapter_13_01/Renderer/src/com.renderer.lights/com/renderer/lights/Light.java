package com.renderer.lights;

import com.renderer.sceneelements.SceneElement;
import com.renderer.math.Vector3d;

public abstract class Light extends SceneElement {
    public Light(Vector3d location) {
        super(location);
    }

    public abstract String getPropertiesDescription();
}
