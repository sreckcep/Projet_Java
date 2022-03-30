package Hexagons;

public class DoubledCoord {
    public DoubledCoord(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public final int col;
    public final int row;

    static public DoubledCoord qdoubledFromCube(Hex h) {
        int col = h.getQ();
        int row = 2 * h.getR() + h.getQ();
        return new DoubledCoord(col, row);
    }


    public Hex qdoubledToCube() {
        int q = col;
        int r = (int) ((row - col) / 2);
        int s = -q - r;
        return new Hex(q, r, s);
    }


    static public DoubledCoord rdoubledFromCube(Hex h) {
        int col = 2 * h.getQ() + h.getR();
        int row = h.getR();
        return new DoubledCoord(col, row);
    }


    public Hex rdoubledToCube() {
        int q = (int) ((col - row) / 2);
        int r = row;
        int s = -q - r;
        return new Hex(q, r, s);
    }

}