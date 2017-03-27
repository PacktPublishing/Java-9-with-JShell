package com.renderer.lights;

import com.renderer.math.Vector3d;

public class DirectionalLight extends Light {
    public final String color;

    public DirectionalLight(Vector3d location, String color) {
        super(location);
        this.color = color;
    }

    @Override
    public void render() {
        System.out.println(
            String.format("Created directional light at %s",
                location));
        System.out.println(
            String.format("Set light color to %s",
                color));
    }

    @Override
    public String getPropertiesDescription() {
        return String.format(
            "light's color equal to %s",
            color);
    }
}
