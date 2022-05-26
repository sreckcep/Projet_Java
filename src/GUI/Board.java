package GUI;

import java.awt.*;
import java.awt.event.*;
import Hexagons.*;
import Hexagons.Point;

import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import Game.Army;
import Game.Unit;
import Game.units.Tank;

import java.util.HashMap;
public class Board extends Canvas {

    private Map<String, Hex> hexes;
    private Layout layout;

    public Board(Layout layout) {
        super();
        setSize(1200, 1000);
        setVisible(true);
        this.hexes = getGameHexes(3);
        this.layout = layout;
    }

    /**
     * place a unit on the board
     * @param unit
     * @param coords
     * @return true if the unit could be placed, else false
     */
    public boolean placeUnit(Unit unit, String coords){
        if (hexes.containsKey(coords) && hexes.get(coords).getUnit() == null){
            hexes.get(coords).setUnit(unit);
            unit.setHex(hexes.get(coords));
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * build a board with given size parameter
     * @return a map of hexes used as a play board
     */
    private Map<String, Hex> getGameHexes(int mapSize){

        //create a map of size mapSize and populate it with a single Hex
        Map<String, Hex> hexes = new HashMap<String, Hex>();
        Hex baseHex = new Hex(0, 0, 0);
        hexes.put(baseHex.getCoord(), baseHex);
        
        //generate the Hexes around the base Hex
        Map<String, Hex> hexesToAdd = new HashMap<String, Hex>();
        for (int i = 0; i < mapSize; i++) {
            for (Hex hex : hexes.values()) {
                for (Hex neighbor : hex.neighbors()) {
                    hexesToAdd.put(neighbor.getCoord(), neighbor);
                }
                
            }
            hexes.putAll(hexesToAdd);
        }
        for (Hex hex : hexes.values()) {
            hex.setBoard(this);
        }
        return hexes;
    }
    
    
    /**
     * rendering method, called everytime the screen must be updated
     */
    @Override
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.black);
        //render chaque hexagone sur l'écran
        for (Hex hex: hexes.values()) {
            //get the coordinates of the hex to draw
            ArrayList<Point> points = layout.polygonCorners(hex);
            

            //build the generalpath object that will be filled
            GeneralPath polygon = new GeneralPath(GeneralPath.WIND_EVEN_ODD);
            polygon.moveTo(points.get(0).x, points.get(0).y);
            for (Point point : points) {
                polygon.lineTo(point.x, point.y);
            }
            polygon.closePath();

            g2d.draw(polygon);

            

            
            Point stringCoord = layout.hexToPixel(hex);
            //draw unit
            if (hex.getUnit() != null){
                g2d.drawString(hex.getUnit().getName(), (int) stringCoord.x, (int) stringCoord.y);
            }
            //draw coordinates for user's convenience
            g2d.drawString(hex.getQ() + "|" + hex.getR() + "|" + hex.getS(), (int) stringCoord.x - 12, (int) stringCoord.y + 15);
        }
    }
    
    public Map<String, Hex> getHexes(){
            return this.hexes;
    }

    /*
    private void wait(int milliSeconds){
        try {
            Thread.sleep(milliSeconds);
        } catch (Exception e) {
            
        }
        
    }*/

    public void start(){
        Army zergs = new Army("zergs");
        Army protosses = new Army("protosses");
        
        Unit zergling = new Unit("&Z", 3, 100, 50);
        Unit ultralisk = new Unit("&U", 1, 400, 80);
        Unit zealot = new Unit("@Z", 3, 100, 50);
        Unit immortal = new Unit("@I", 1, 400, 80);
        
        zergs.addUnit(zergling);
        zergs.addUnit(ultralisk);
        protosses.addUnit(zealot);
        protosses.addUnit(immortal);
        
        this.placeUnit(zergling, "0|0|0");
        this.placeUnit(ultralisk, "-3|1|2");
        this.placeUnit(zealot, "0|1|-1");
        this.placeUnit(immortal, "2|1|-3");
        repaint();
        Scanner input = new Scanner(System.in);
        int turnCount = 1;
        Army currentArmy = zergs;
        while (true){
            //zerg turn
            if (turnCount % 2 == 0)
                currentArmy = protosses;
            else
                currentArmy = zergs;

            System.out.println("select " + currentArmy.getName() + " unit");
            String selectedUnitName = input.nextLine();
            while (!currentArmy.contains(selectedUnitName)){
                System.out.println("select " + currentArmy.getName() + " unit");
                selectedUnitName = input.nextLine();
            }
            Unit selectedUnit = currentArmy.getUnit(selectedUnitName);
            System.out.println("select target hex");
            String selectedTargetHexCoords = input.nextLine();
            while (!selectedUnit.move(selectedTargetHexCoords)){
                System.out.println("select target hex");    
                selectedTargetHexCoords = input.nextLine();
            }
            repaint();
            turnCount++;
        }
    }
}

