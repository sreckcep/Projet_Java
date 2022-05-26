/**
 * basé sur le très utile www.redblobgames.com/grids/hexagon par Amitp
 */

package Hexagons;

import java.util.ArrayList;

import GUI.Board;
import Game.Unit;

public class Hex {

    private Unit unit;
    private Board board;

    public Hex(int q, int r, int s) {
        this.q = q;
        this.r = r;
        this.s = s;
        if (q + r + s != 0) throw new IllegalArgumentException("q + r + s must be equal to 0");
    }

    public static Boolean isValid(Board board, String coords){
        return board.getHexes().containsKey(coords);
    }

    public Unit getUnit() {
        return this.unit;
    }

    public Hex setUnit(Unit unit) {
        this.unit = unit;
        return this;
    }

    public Hex setBoard(Board board){
        this.board = board;
        return this;
    }

    public Board getBoard(){
        return this.board;
    }


    //___________________Hexagon coordinate system_____________________\\
    
    private final int q;
    private final int r;
    private final int s;
    
    static public ArrayList<Hex> directions = new ArrayList<Hex>() {{
        add(new Hex(1, 0, -1));
        add(new Hex(1, -1, 0));
        add(new Hex(0, -1, 1));
        add(new Hex(-1, 0, 1));
        add(new Hex(-1, 1, 0));
        add(new Hex(0, 1, -1));
    }};

    static public ArrayList<Hex> diagonals = new ArrayList<Hex>() {{
        add(new Hex(2, -1, -1));
        add(new Hex(1, -2, 1));
        add(new Hex(-1, -1, 2));
        add(new Hex(-2, 1, 1));
        add(new Hex(-1, 2, -1));
        add(new Hex(1, 1, -2));
    }};

    public Hex add(Hex b) {
        return new Hex(q + b.q, r + b.r, s + b.s);
    }


    public Hex subtract(Hex b) {
        return new Hex(q - b.q, r - b.r, s - b.s);
    }


    public Hex scale(int k) {
        return new Hex(q * k, r * k, s * k);
    }


    public Hex rotateLeft() {
        return new Hex(-s, -q, -r);
    }


    public Hex rotateRight() {
        return new Hex(-r, -s, -q);
    }


    static public Hex direction(int direction) {
        return Hex.directions.get(direction);
    }


    public Hex neighbor(int direction) {
        return add(Hex.direction(direction));
    }

    public ArrayList<Hex> neighbors() {
        ArrayList<Hex> neighborsArray = new ArrayList<Hex>();
        for (int i = 0; i < 6; i++) {
            neighborsArray.add(this.neighbor(i));
        }
        return neighborsArray;
    }


    public Hex diagonalNeighbor(int direction) {
        return add(Hex.diagonals.get(direction));
    }


    public int length() {
        return (int) ((Math.abs(q) + Math.abs(r) + Math.abs(s)) / 2);
    }


    public int distance(Hex b) {
        return subtract(b).length();
    }

    public int getQ() {
        return q;
    }

    public int getR() {
        return r;
    }

    public int getS() {
        return s;
    }

    public String getCoord(){
        String coords = Integer.toString(q) + "|" + Integer.toString(r) + "|" + Integer.toString(s);
        return coords;
    }
}