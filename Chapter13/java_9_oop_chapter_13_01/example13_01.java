public class Renderer {
    public static void renderCube(int x, int y, int z, int edgeLength,
        int cameraX, int cameraY, int cameraZ,
        int cameraDirectionX, int cameraDirectionY, int cameraDirectionZ,
        int cameraVectorX, int cameraVectorY, int cameraVectorZ,
        int cameraPerspectiveFieldOfView,
        int cameraNearClippingPlane,
        int cameraFarClippingPlane,
        int directionalLightX, int directionalLightY, int directionalLightZ,
        String directionalLightColor) {
            System.out.println(
                String.format("Created camera at (x:%d, y:%d, z:%d)",
                    cameraX, cameraY, cameraZ));
            System.out.println(
                String.format("Set camera direction to (x:%d, y:%d, z:%d)",
                    cameraDirectionX, cameraDirectionY, cameraDirectionZ));
            System.out.println(
                String.format("Set camera vector to (x:%d, y:%d, z:%d)",
                    cameraVectorX, cameraVectorY, cameraVectorZ));
            System.out.println(
                String.format("Set camera perspective field of view to: %d",
                    cameraPerspectiveFieldOfView));
            System.out.println(
                String.format("Set camera near clipping plane to: %d", 
                    cameraNearClippingPlane));
            System.out.println(
                String.format("Set camera far clipping plane to: %d",
                    cameraFarClippingPlane));
            System.out.println(
                String.format("Created directional light at (x:%d, y:%d, z:%d)",
                    directionalLightX, directionalLightY, directionalLightZ));
            System.out.println(
                String.format("Set light color to %s",
                    directionalLightColor));
            System.out.println(
                String.format("Drew cube at (x:%d, y:%d, z:%d) with edge length equal to %d" +
                    "considering directional light at (x:%d, y:%d, z:%d) " +
                    "and light's color equal to %s", 
                    x, y, z, edgeLength,
                    directionalLightX, directionalLightY, directionalLightZ,
                    directionalLightColor));
    }

    public static void renderSphere(int x, int y, int z, int radius,
        int cameraX, int cameraY, int cameraZ,
        int cameraDirectionX, int cameraDirectionY, int cameraDirectionZ,
        int cameraVectorX, int cameraVectorY, int cameraVectorZ,
        int cameraPerspectiveFieldOfView,
        int cameraNearClippingPlane,
        int cameraFarClippingPlane,
        int directionalLightX, int directionalLightY, int directionalLightZ,
        String directionalLightColor) {
            System.out.println(
                String.format("Created camera at (x:%d, y:%d, z:%d)",
                    cameraX, cameraY, cameraZ));
            System.out.println(
                String.format("Set camera direction to (x:%d, y:%d, z:%d)",
                    cameraDirectionX, cameraDirectionY, cameraDirectionZ));
            System.out.println(
                String.format("Set camera vector to (x:%d, y:%d, z:%d)",
                    cameraVectorX, cameraVectorY, cameraVectorZ));
            System.out.println(
                String.format("Set camera perspective field of view to: %d",
                    cameraPerspectiveFieldOfView));
            System.out.println(
                String.format("Set camera near clipping plane to: %d", 
                    cameraNearClippingPlane));
            System.out.println(
                String.format("Set camera far clipping plane to: %d",
                    cameraFarClippingPlane));
            System.out.println(
                String.format("Created directional light at (x:%d, y:%d, z:%d)",
                    directionalLightX, directionalLightY, directionalLightZ));
            System.out.println(
                String.format("Set light color to %s",
                    directionalLightColor));
            // Render the sphere
            System.out.println(
                String.format("Drew sphere at (x:%d, y:%d z:%d) with radius equal to %d",
                    x, y, z, radius));
            System.out.println(
                String.format("considering directional light at (x:%d, y:%d, z:%d)",
                    directionalLightX, directionalLightY, directionalLightZ));
            System.out.println(
                String.format("and the light's color equal to %s",
                    directionalLightColor));
    }
}

// Refactored version
public class Vector3d {
    public int x;
    public int y;
    public int z;

    Vector3d(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    Vector3d(int valueForXYZ) {
        this(valueForXYZ, valueForXYZ, valueForXYZ);
    }

    Vector3d() {
        this(0);
    }

    public void absolute() {
        x = Math.abs(x);
        y = Math.abs(y);
        z = Math.abs(z);
    }

    public void negate() {
        x = -x;
        y = -y;
        z = -z;
    }

    public void add(Vector3d vector) {
        x += vector.x;
        y += vector.y;
        z += vector.z;
    }

    public void sub(Vector3d vector) {
        x -= vector.x;
        y -= vector.y;
        z -= vector.z;
    }

    public String toString() {
        return String.format(
            "(x: %d, y: %d, z: %d)",
            x,
            y,
            z);
    }
}

public interface Rendereable {
    Vector3d getLocation();
    void setLocation(Vector3d newLocation);
    void render();
}

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

public abstract class Light extends SceneElement {
    public Light(Vector3d location) {
        super(location);
    }

    public abstract String getPropertiesDescription();
}

public class DirectionalLight extends Light {
    public final String color;

    public DirectionalLight(Vector3d location, String color) {
        super(location);
        this.color = color;
    }

    @Override
    public void render() {
        System.out.println(
            String.format("Created directional light at (x:%d, y:%d, z:%d)",
                location.x, location.y, location.z));
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

public abstract class Camera extends SceneElement {
    public Camera(Vector3d location) {
        super(location);
    }
}

public class PerspectiveCamera extends Camera {
    protected Vector3d direction;
    protected Vector3d vector;
    protected int fieldOfView;
    protected int nearClippingPlane;
    protected int farClippingPlane;

    public Vector3d getDirection() {
        return direction;
    }

    public void setDirection(Vector3d newDirection) {
        direction = newDirection;
    }

    public Vector3d getVector() {
        return vector;
    }

    public void setVector(Vector3d newVector) {
        vector = newVector;
    }

    public int getFieldOfView() {
        return fieldOfView;
    }
    
    public void setFieldOfView(int newFieldOfView) {
        fieldOfView = newFieldOfView;
    }

    public int nearClippingPlane() {
        return nearClippingPlane;
    }

    public void setNearClippingPlane(int newNearClippingPlane) {
        this.nearClippingPlane = newNearClippingPlane;
    }

    public int farClippingPlane() {
        return farClippingPlane;
    }

    public void setFarClippingPlane(int newFarClippingPlane) {
        this.farClippingPlane = newFarClippingPlane;
    }

    public PerspectiveCamera(Vector3d location, 
        Vector3d direction, Vector3d vector, 
        int fieldOfView, int nearClippingPlane, 
        int farClippingPlane) {
        super(location);
        this.direction = direction;
        this.vector = vector;
        this.fieldOfView = fieldOfView;
        this.nearClippingPlane = nearClippingPlane;
        this.farClippingPlane = farClippingPlane;
    }

    @Override
    public void render() {
        System.out.println(
            String.format("Created camera at (x:%d, y:%d, z:%d)",
                location.x, location.y, location.z));
        System.out.println(
            String.format("Set camera direction to (x:%d, y:%d, z:%d)",
                direction.x, direction.y, direction.z));
        System.out.println(
            String.format("Set camera vector to (x:%d, y:%d, z:%d)",
                vector.x, vector.y, vector.z));
        System.out.println(
            String.format("Set camera perspective field of view to: %d",
                fieldOfView));
        System.out.println(
            String.format("Set camera near clipping plane to: %d", 
                nearClippingPlane));
        System.out.println(
            String.format("Set camera far clipping plane to: %d",
                farClippingPlane));
    }
}

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
                "considering directional light at (x:%d, y:%d, z:%d)\nand %s",
                    light.getLocation().x, 
                    light.getLocation().y, 
                    light.getLocation().z,
                    light.getPropertiesDescription()))
            .collect(Collectors.joining());
    }
}

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
            "Drew sphere at (x:%d, y:%d z:%d) with radius equal to %d\n",
            location.x, 
            location.y, 
            location.z,
            radius));
        String consideringLights = 
            generateConsideringLights();
        sb.append(consideringLights);
        System.out.println(sb.toString());
    }
}

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
            "Drew cube at (x:%d, y:%d z:%d) with edge length equal to %d\n",
            location.x, 
            location.y, 
            location.z,
            edgeLength));
        String consideringLights = 
            generateConsideringLights();
        sb.append(consideringLights);
        System.out.println(sb.toString());
    }
}

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
