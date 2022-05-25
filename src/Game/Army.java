package Game;

import Game.units.Unit;

import java.util.ArrayList;

public class Army {
    private ArrayList<Unit> units;

    public void addUnit(Unit unit){
        units.add(unit);
    }

    public boolean removeUnit(Unit unit){
        return units.remove(unit);
    }

    public boolean isEmpty(){
        return units.isEmpty();
    }
}
