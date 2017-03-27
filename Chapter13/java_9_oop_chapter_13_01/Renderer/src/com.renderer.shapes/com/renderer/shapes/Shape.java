package com.renderer.shapes;

import com.renderer.math.Vector3d;
import com.renderer.sceneelements.SceneElement;
import com.renderer.lights.Light;
import com.renderer.cameras.Camera;
import java.util.*;
import java.util.stream.Collectors;

public abstract class Shape extends SceneElement {
    protected Camera activeCamera;
    protected List<Light> lights;

    public Shape(Vector3d location) {
        super(location);
        lights = new ArrayList<>();
    }

    public void setActiveCamera(Camera activeCamera) {
        this.activeCamera = activeCamera;
    }
    
    public void setLights(List<Light> lights) {
        this.lights = lights;
    }

    protected boolean isValidForRender() {
        return !((activeCamera == null) && lights.isEmpty());
    }

    protected String generateConsideringLights() {
        return lights.stream()
            .map(light -> String.format(
                "considering light at %s\nand %s",
                    light.getLocation(), 
                    light.getPropertiesDescription()))
            .collect(Collectors.joining());
    }
}
