package tests;

import GUI.HexDisplay;
import GUI.MainFrame;
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

        //peut être pointy ou flat
        Layout layout = new Layout(Layout.pointy, new Point(50, 50), new Point(200, 200));

        MainFrame frame = new MainFrame();
        HexDisplay canvas = new HexDisplay(hexes, layout);
        frame.add(canvas).validate();
    }
}
