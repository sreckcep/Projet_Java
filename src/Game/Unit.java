package Game;

import java.util.ArrayList;

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
     * move the unit from its current hex to targetHex
     * @param targetHex
     * @return true if the unit was able to move, false if it wasn't
     */
    public Boolean move(Hex targetHex){
        //verify that target hex exists on the board
        if (!Hex.isValid(this.hex.getBoard(), targetHex))
            return false;
        
        //verify that target hex is within range of the unit
        if (this.hex.distance(targetHex) > this.move)
            return false;
        
        //prevent friendly fire
        if (targetHex.getUnit().getArmy() == this.army){
            return false;
        }

        //if target hex is not empty AND it is not a friendly unit, attack it
        if (targetHex.getUnit() != null && targetHex.getUnit().getArmy() != this.army){
            
            //attack the unit
            if (targetHex.getUnit().receiveDmg(this.damage) > 0){
                //if the unit is still alive, do not move
                return false; 
            }

            //if target unit was killed, then move to the target hex
            else{
                targetHex.setUnit(this);
                this.hex.setUnit(null);
                this.hex = targetHex;
                return true;
            }
        }
        //if target hex is empty, then move to the target hex
        else{
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
        life -= damage;
        if (life < 0){
            life = 0;
            this.die();
            return 0;
        }
        else{
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

    public void setHex(Hex hex) {
        this.hex = hex;
    }

    public Army getArmy(){
        return this.army;
    }
}




