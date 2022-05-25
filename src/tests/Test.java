package tests;

import GUI.Board;
import GUI.Game;
import Hexagons.Hex;
import Hexagons.Layout;
import Hexagons.Orientation;
import Hexagons.Point;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static java.lang.Math.sqrt;

public class Test {
    public static void main(String args[]) {

        Set<Hex> hexes = new HashSet<Hex>();
        hexes.add(new Hex(0, 0, 0));
        for (int i = 0; i < mapSize; i++) {
            for (Hex hex : hexes) {
                hexes.addAll(hex.neighbors());
            } 
        }
        //peut être pointy ou flat
        Layout layout = new Layout(Layout.pointy, new Point(50, 50), new Point(200, 200));

        Game frame = new Game();
        Board canvas = new Board(hexes, layout);
        frame.add(canvas).validate();
    }
}
