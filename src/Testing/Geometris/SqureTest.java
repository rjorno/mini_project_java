package Testing.Geometris;

import Elements.Camera;
import Elements.DirectionalLight;
import Elements.SpotLight;
import Geometries.Sphere;
import Geometries.Squre;
import Geometries.Triangle;
import Primitives.Point3D;
import Primitives.Vector;
import Renderer.ImageWriter;
import Renderer.Render;
import Scene.Scene;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SqureTest {
    //function that get 8 points and return a cube
    public List<Squre> cube(Point3D A, Point3D B, Point3D C, Point3D D, Point3D E, Point3D F, Point3D G, Point3D H) {

        Squre up = new Squre(A, B, F, E);
        up.setEmmission(new Color(70, 39, 128));

        Squre down = new Squre(D, C, G, H);
        down.setEmmission(new Color(74, 228, 100));

        Squre right = new Squre(B, C, G, F);
        right.setEmmission(new Color(132, 24, 16));

        Squre left = new Squre(A, D, H, E);
        left.setEmmission(new Color(132, 24, 16));

        Squre front = new Squre(A, D, C, B);
        front.setEmmission(new Color(83, 73, 228));

        Squre beak = new Squre(E, H, G, F);
        beak.setEmmission(new Color(228, 9, 6));

        List<Squre> temp = new ArrayList<Squre>();
        temp.add(up);
        temp.add(down);
        temp.add(right);
        temp.add(left);
        temp.add(front);
        temp.add(beak);

        return temp;
    }

    @Test
    public void test() {
        Scene scene = new Scene();
        scene.setScreenDistance(100);
//        scene.setCamera(new Camera(new Point3D(0,0,-6000),new Vector(0,1,0),new Vector(0,0,1)));
        Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -2000));
        sphere.setShininess(20);
        sphere.setEmmission(new Color(0, 0, 100));
        scene.addGeometry(sphere);
        List<Squre> table = cube(
                new Point3D(-3000, -1000, -2000),
                new Point3D(-3000, -1000, -3000),
                new Point3D(-3000, -1500, -3000),
                new Point3D(-3000, -1500, -2000),
                new Point3D(3000, -1000, -2000),
                new Point3D(3000, -1000, -3000),
                new Point3D(3000, -1500, -3000),
                new Point3D(3000, -1500, -2000));
        for (Squre squre : table) {
            scene.addGeometry(squre);
        }
        List<Squre> leg1 = cube(
                new Point3D(2000, -1500, -2100),
                new Point3D(2000, -1500, -2200),
                new Point3D(2000, -4000, -2200),
                new Point3D(2000, -4000, -2100),
                new Point3D(2500, -1500, -2100),
                new Point3D(2500, -1500, -2200),
                new Point3D(2500, -4000, -2200),
                new Point3D(2500, -4000, -2100));
        for (Squre squre : leg1) {
            scene.addGeometry(squre);
        }
        List<Squre> leg2 = cube(
                new Point3D(-2500, -1500, -2100),
                new Point3D(-2500, -1500, -2200),
                new Point3D(-2500, -4000, -2200),
                new Point3D(-2500, -4000, -2100),
                new Point3D(-2000, -1500, -2100),
                new Point3D(-2000, -1500, -2200),
                new Point3D(-2000, -4000, -2200),
                new Point3D(-2000, -4000, -2100));
        for (Squre squre : leg2) {
            scene.addGeometry(squre);
        }
        List<Squre> leg3 = cube(
                new Point3D(2000, -1500, -2800),
                new Point3D(2000, -1500, -2900),
                new Point3D(2000, -4000, -2900),
                new Point3D(2000, -4000, -2800),
                new Point3D(2500, -1500, -2800),
                new Point3D(2500, -1500, -2900),
                new Point3D(2500, -4000, -2900),
                new Point3D(2500, -4000, -2800));
        for (Squre squre : leg3) {
            scene.addGeometry(squre);
        }
        List<Squre> leg4 = cube(
                new Point3D(-2500, -1500, -2800),
                new Point3D(-2500, -1500, -2900),
                new Point3D(-2500, -4000, -2900),
                new Point3D(-2500, -4000, -2800),
                new Point3D(-2000, -1500, -2800),
                new Point3D(-2000, -1500, -2900),
                new Point3D(-2000, -4000, -2900),
                new Point3D(-2000, -4000, -2800));
        for (Squre squre : leg4) {
            scene.addGeometry(squre);
        }
        Squre floor = new Squre(
                new Point3D(-12000, -4000, 1000),
                new Point3D(-12000, -4000, -12000),
                new Point3D(12000, -4000, -12000),
                new Point3D(12000, -4000, 1000));
        floor.setEmmission(new Color(63, 31, 25));
        scene.addGeometry(floor);
//        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -1100),
//                new Vector(-2, -2, -3), 0, 0.000001, 0.0000005));
        scene.addLight(new DirectionalLight(new Color(200, 188, 105), new Vector(-5, -5, -3)));
        ImageWriter imageWriter = new ImageWriter("cube test", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();
    }

    @Test
    public void test2() {
        Scene scene = new Scene();
        scene.setScreenDistance(100);
//        scene.setCamera(new Camera(new Point3D(0,0,-6000),new Vector(0,1,0),new Vector(0,0,1)));
        Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -2000));
        sphere.setShininess(20);
        sphere.setEmmission(new Color(0, 0, 100));
        scene.addGeometry(sphere);
        List<Squre> table = cube(
                new Point3D(-3000, -1000, -2000),
                new Point3D(-3000, -1000, -3000),
                new Point3D(-3000, -1500, -3000),
                new Point3D(-3000, -1500, -2000),
                new Point3D(3000, -1000, -2000),
                new Point3D(3000, -1000, -3000),
                new Point3D(3000, -1500, -3000),
                new Point3D(3000, -1500, -2000));
        for (Squre squre : table) {
            scene.addGeometry(squre);
        }
        List<Squre> leg1 = cube(
                new Point3D(2000, -1500, -2100),
                new Point3D(2000, -1500, -2200),
                new Point3D(2000, -4000, -2200),
                new Point3D(2000, -4000, -2100),
                new Point3D(2500, -1500, -2100),
                new Point3D(2500, -1500, -2200),
                new Point3D(2500, -4000, -2200),
                new Point3D(2500, -4000, -2100));
        for (Squre squre : leg1) {
            scene.addGeometry(squre);
        }
        List<Squre> leg2 = cube(
                new Point3D(-2500, -1500, -2100),
                new Point3D(-2500, -1500, -2200),
                new Point3D(-2500, -4000, -2200),
                new Point3D(-2500, -4000, -2100),
                new Point3D(-2000, -1500, -2100),
                new Point3D(-2000, -1500, -2200),
                new Point3D(-2000, -4000, -2200),
                new Point3D(-2000, -4000, -2100));
        for (Squre squre : leg2) {
            scene.addGeometry(squre);
        }
        List<Squre> leg3 = cube(
                new Point3D(2000, -1500, -2800),
                new Point3D(2000, -1500, -2900),
                new Point3D(2000, -4000, -2900),
                new Point3D(2000, -4000, -2800),
                new Point3D(2500, -1500, -2800),
                new Point3D(2500, -1500, -2900),
                new Point3D(2500, -4000, -2900),
                new Point3D(2500, -4000, -2800));
        for (Squre squre : leg3) {
            scene.addGeometry(squre);
        }
        List<Squre> leg4 = cube(
                new Point3D(-2500, -1500, -2800),
                new Point3D(-2500, -1500, -2900),
                new Point3D(-2500, -4000, -2900),
                new Point3D(-2500, -4000, -2800),
                new Point3D(-2000, -1500, -2800),
                new Point3D(-2000, -1500, -2900),
                new Point3D(-2000, -4000, -2900),
                new Point3D(-2000, -4000, -2800));
        for (Squre squre : leg4) {
            scene.addGeometry(squre);
        }
        Squre floor = new Squre(
                new Point3D(-12000, -4000, 1000),
                new Point3D(-12000, -4000, -12000),
                new Point3D(12000, -4000, -12000),
                new Point3D(12000, -4000, 1000));
        floor.setEmmission(new Color(63, 31, 25));
        scene.addGeometry(floor);
        Squre wall1=new Squre(
                new Point3D(-8000, 4000, 1000),
                new Point3D(-8000, 4000, -12000),
                new Point3D(-8000, -4000, -12000),
                new Point3D(-8000, -4000, 1000));
        wall1.setEmmission(new Color(63, 31, 25));
        scene.addGeometry(wall1);
        Squre wall2=new Squre(
                new Point3D(-8000, 4000, -8000),
                new Point3D(8000, 4000, -8000),
                new Point3D(8000, -4000, -8000),
                new Point3D(-8000, -4000, -8000));
        wall1.setEmmission(new Color(95, 93, 110));
        scene.addGeometry(wall2);
        /*Squre watch=new Squre(
                new Point3D(-8000, 500, -3500),
                new Point3D(-8000, 500, -4500),
                new Point3D(-8000, -500, -4500),
                new Point3D(-8000, -500, -3500));
        wall1.setEmmission(new Color(131, 139, 122));
        scene.addGeometry(watch);
        Sphere m=new Sphere(200,new Point3D(-8100,0,-4200));
        m.setShininess(40);
        m.setEmmission(new Color(0,0,100));
        scene.addGeometry(m);*/
        //        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -1100),
//                new Vector(-2, -2, -3), 0, 0.000001, 0.0000005));
        scene.addLight(new DirectionalLight(new Color(200, 188, 105), new Vector(-10, -5, -3)));
        ImageWriter imageWriter = new ImageWriter("cube test 2", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();
    }

}
