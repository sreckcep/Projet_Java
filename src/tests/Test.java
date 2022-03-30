package tests;

import GUI.HexDisplay;
import Hexagons.Hex;
import Hexagons.Layout;
import Hexagons.Orientation;
import Hexagons.Point;

import java.util.ArrayList;

import static java.lang.Math.sqrt;

public class Test {
    public static void main(String args[]) {

        ArrayList<Hex> hexes = new ArrayList<>();
        hexes.add(new Hex(0, 0, 0));
        hexes.addAll(hexes.get(0).neighbors());

        //flat
        /*
        Layout layout = new Layout(new Orientation(3.0 / 2.0, 0.0, sqrt(3.0) / 2.0, sqrt(3.0),
                2.0 / 3.0, 0.0, -1.0 / 3.0, sqrt(3.0) / 3.0,
                0.0), new Point(50, 50), new Point(200, 200));
        */

        //pointy
        Layout layout = new Layout(new Orientation(sqrt(3.0), sqrt(3.0) / 2.0, 0.0, 3.0 / 2.0,
                sqrt(3.0) / 3.0, -1.0 / 3.0, 0.0, 2.0 / 3.0,
                0.5), new Point(50, 50), new Point(200, 200));

        HexDisplay display = new HexDisplay(hexes, layout);
    }
}
