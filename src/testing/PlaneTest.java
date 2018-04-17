package testing;

import Geometris.*;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlaneTest {

    @Test
    void testgetQ() {

        try {
            Plane p = new Plane(new Vector(0,0,1),new Point3D(0,0,-3));
            assertEquals(new Point3D(0,0,-3).toString(),p.getQ().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}