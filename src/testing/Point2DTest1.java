package testing;
import Primitives.Coordinate;
import Primitives.Point2D;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;






import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Point2DTest1 {
    Coordinate a=new Coordinate(7);
    Coordinate b=new Coordinate(5);

    Point2D exmple1=new Point2D(a,b);
    Point2D exmple2=new Point2D(a,new Coordinate(5));

    @Test
    void compareTo() {

        assertTrue(exmple1.get_x().getCoordiannte()==exmple2.get_x().getCoordiannte()&&exmple1.get_y().getCoordiannte()==exmple2.get_y().getCoordiannte());
        assertEquals(0,exmple1.compareTo(exmple2));
    }
}