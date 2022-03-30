package GUI;

import java.awt.*;
import java.awt.event.*;
import Hexagons.*;
import Hexagons.Point;

import java.awt.geom.GeneralPath;
import java.util.ArrayList;

public class HexDisplay extends Canvas {
    private ArrayList<Hex> hexes;
    private Layout layout;

    public HexDisplay(ArrayList<Hex> hexes, Layout layout) {
        super();
        setSize(600, 400);
        setVisible(true);
        this.hexes = hexes;
        this.layout = layout;
    }


    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.black);

        //render chaque hexagone sur l'écran
        for (Hex hex: hexes) {
            //récupération des coordonnées des points de chaque point de l'hexagone
            ArrayList<Point> points = layout.polygonCorners(hex);

            Point stringCoord = layout.hexToPixel(hex);
            //objet generalpath qui sera rempli;
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
