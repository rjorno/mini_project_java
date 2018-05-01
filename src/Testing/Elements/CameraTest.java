package Testing.Elements;

import Elements.Camera;
import Primitives.Point3D;
import Primitives.Vector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CameraTest {

    @Test
    void constructRayThroughPixel() {

        assertEquals(1,new Camera(new Camera(new Point3D(),new Vector(0,1,0),new Vector(0,0,-1))).get_vRight().get_head().get_x().getCoordiannte());
        assertEquals(1,new Camera(new Point3D(),new Vector(0,1,0),new Vector(0,0,-1)).get_vRight().get_head().get_x().getCoordiannte());
        assertEquals(1,new Camera(new Camera()).get_vRight().get_head().get_x().getCoordiannte());


        assertEquals(0,new Camera().constructRayThroughPixel(3,3,0,0,1,9,9).get_POO().get_x().getCoordiannte());
        assertEquals(0,new Camera().constructRayThroughPixel(3,3,0,0,1,9,9).get_POO().get_y().getCoordiannte());
        assertEquals(0,new Camera().constructRayThroughPixel(3,3,0,0,1,9,9).get_POO().get_z().getCoordiannte());

        assertEquals(-3,new Camera().constructRayThroughPixel(3,3,0,0,1,9,9).get_direction().get_head().get_x().getCoordiannte());
     //   assertEquals(-3,new Camera().constructRayThroughPixel(3,3,0,0,1,9,9).get_direction().get_head().get_y().getCoordiannte());
        assertEquals(-1,new Camera().constructRayThroughPixel(3,3,0,0,1,9,9).get_direction().get_head().get_z().getCoordiannte());


    }
}