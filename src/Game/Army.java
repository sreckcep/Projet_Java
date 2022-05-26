package Game;

import java.util.HashMap;
import java.util.Map;

public class Army {
    
    private String name;
    private Map<String, Unit> units;
    
    public Army(String name){
        this.name = name;
        units = new HashMap<String, Unit>();
    }

    public boolean contains(String name){
        return units.containsKey(name);
    }

    public Unit getUnit(String name){
        return units.get(name);
    }

    public void addUnit(Unit unit){
        units.put(unit.getName(), unit);
        unit.setArmy(this);
    }

    public void removeUnit(String name){
        units.remove(name);
    }

    public boolean isEmpty(){
        return units.isEmpty();
    }

    public Map<String, Unit> getUnits() {
        return this.units;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
