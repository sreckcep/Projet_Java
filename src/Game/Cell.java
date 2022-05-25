package Game;

import Game.units.Unit;
import Hexagons.Hex;

public class Cell extends Hex{
    private Unit unit;

    public Cell(int q, int r, int s) {
        super(q, r, s);
    }

    public Unit getUnit() {
        return this.unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Cell unit(Unit unit) {
        setUnit(unit);
        return this;
    };
}
