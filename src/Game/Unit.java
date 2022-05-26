package Game;

import Hexagons.Hex;

public class Unit {
    private int move;
    private int life;
    private int damage;
    private String name;
    private Hex hex;
    private Army army;
    
    public Unit(String name, int move, int life, int damage) {
        this.move = move;
        this.life = life;
        this.damage = damage;
        this.name = name;
    }
    /**
     * move the unit from its current hex to targetHex of coordinates coords
     * @param targetHex
     * @return true if the unit was able to move, false if it wasn't
     */
    public Boolean move(String coords){
        
        //verify that target hex exists on the board
        if (!Hex.isValid(this.hex.getBoard(), coords))
            return false;
        
        Hex targetHex = hex.getBoard().getHexes().get(coords);
        
        //verify that target hex is within range of the unit
        if (this.hex.distance(targetHex) > this.move)
            return false;

        //if target hex is not empty AND it is not a friendly unit, attack it
        if (targetHex.getUnit() != null){
                
            //verify that target unit is not friendly
            if (targetHex.getUnit().getArmy() == this.army)
                return false;
            //attack the unit, then if the unit is still alive, do not move
            if (targetHex.getUnit().receiveDmg(this.damage) > 0){
                System.out.println("attacked but not hard enough");
                return true;
            }

            //if target unit was killed, then move to the target hex
            else{
                System.out.println("went to empty hex after killing a unit");
                targetHex.setUnit(this);
                this.hex.setUnit(null);
                this.hex = targetHex;
                return true;
            }
        }
        //if target hex is empty, then move to the target hex
        else{
            System.out.println("went to empty hex");
            targetHex.setUnit(this);
            this.hex.setUnit(null);
            this.hex = targetHex;
            return true;
            }   
        }

    public void die(){
        this.army.removeUnit(this.name);
        this.hex.setUnit(null);
        System.out.println(this.name + "died on hex" + this.hex.getCoord());
    }

    public int receiveDmg(int damage){
        System.out.println("unit is getting attacked");
        life -= damage;
        if (life <= 0){
            this.die();
            return 0;
        }
        else{
            System.out.println("unit is still alive");
            return life;
        }
    }

    public String getName() {
        return name;
    }
    public int getMove() {
        return move;
    }

    public int getLife() {
        return life;
    }

    public int getDamage() {
        return damage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMove(int move) {
        this.move = move;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Hex getHex() {
        return this.hex;
    }

    public Unit setHex(Hex hex) {
        this.hex = hex;
        return this;
    }

    public Army getArmy(){
        return this.army;
    }

    public Unit setArmy(Army army){
        this.army = army;
        return this;
    }
}




