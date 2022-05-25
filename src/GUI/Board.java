package GUI;

import Game.Cell;

import java.awt.*;
import java.awt.event.*;
import Hexagons.*;
import Hexagons.Point;

import java.awt.geom.GeneralPath;
import java.util.ArrayList;

public class Board extends Canvas {
    private ArrayList<Cell> cells;
    private Layout layout;

    public Board(ArrayList<Cell> cells, Layout layout) {
        super();
        setSize(600, 400);
        setVisible(true);
        this.cells = cells;
        this.layout = layout;
    }

    @Override
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.black);

        //render chaque hexagone sur l'écran
        for (Cell cell: cells) {
            //récupération des coordonnées des points de chaque point de l'hexagone
            ArrayList<Point> points = layout.polygonCorners(cell);

            Point stringCoord = layout.hexToPixel(cell);
            //objet generalpath qui sera rempli;
            GeneralPath polygon = new GeneralPath(GeneralPath.WIND_EVEN_ODD);
            polygon.moveTo(points.get(0).x, points.get(0).y);
            for (Point point : points) {
                polygon.lineTo(point.x, point.y);
            }
            polygon.closePath();
            g2d.draw(polygon);
            g2d.drawString(cell.getQ() + "|" + cell.getR() + "|" + cell.getS(), (int) stringCoord.x - 12, (int) stringCoord.y + 5);
        }

    }
}
