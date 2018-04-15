package testing;

import Primitives.Coordinate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinateTest {
    Coordinate temp=new Coordinate(12);
    Coordinate temp1=new Coordinate(12);
    @Test
    void compareTo() {

       assertEquals(temp.getCoordiannte(),temp1.getCoordiannte());

    }
    @Test
    void add() {

        temp.add(temp1);
        assertEquals(24,temp.getCoordiannte());
    }
    @Test
    void subtract(){

        temp.subtract(temp1);
        assertEquals(0,temp.getCoordiannte());
    }





}