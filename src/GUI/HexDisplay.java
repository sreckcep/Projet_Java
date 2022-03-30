package GUI;

import java.awt.*;
import java.awt.event.*;
import Hexagons.*;
import Hexagons.Point;

import java.awt.geom.GeneralPath;
import java.util.ArrayList;

import static java.lang.Math.round;
import static java.lang.Math.sqrt;

public class HexDisplay extends Frame {
    private ArrayList<Hex> hexes;
    private Layout layout;

    public HexDisplay(ArrayList<Hex> hexes, Layout layout) {
        super("Board display");
        setSize(800, 500);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                        dispose();
                        System.exit(0);
                    }
                }
        );
        this.hexes = hexes;
        this.layout = layout;
    }


    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.black);

        //render chaque hexagone sur l'écran
        for (Hex hex: hexes) {
            //récupération des coordonnées des points
            ArrayList<Point> points = layout.polygonCorners(hex);
            Point stringCoord = layout.hexToPixel(hex);
            GeneralPath polygon = new GeneralPath(GeneralPath.WIND_EVEN_ODD);
            polygon.moveTo(points.get(0).x, points.get(0).y);
            for (Point point : points) {

                polygon.lineTo(point.x, point.y);
            }
            polygon.closePath();
            g2d.draw(polygon);
            g2d.drawString(hex.getQ() + "|" + hex.getR() + "|" + hex.getS(), (int) stringCoord.x - 12, (int) stringCoord.y + 5);
        }

    }
}
