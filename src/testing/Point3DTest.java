package testing;

import Primitives.Point3D;
import Primitives.Vector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Point3DTest {
Point3D temp=new Point3D(10,20,30);
Vector temp2 = new Vector(3,4,5);
    @Test
    void add() {
        temp.add(temp2);
    assertTrue(temp.get_x().getCoordiannte()==13&&temp.get_y().getCoordiannte()==24&&temp.get_z().getCoordiannte()==35);
    }

    @Test
    void subtract() {
        temp.subtract(temp2);
        assertTrue(temp.get_x().getCoordiannte()==7&&temp.get_y().getCoordiannte()==16&&temp.get_z().getCoordiannte()==25);
    }

    @Test
    void distance() {
        assertEquals(0,temp.distance(temp));
        assertEquals(30.49,temp.distance(temp2.get_head()),0.05);
    }
}