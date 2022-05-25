package Game.units;

public class Unit {
    public Unit(int move, int life, int damage) {
        this.move = move;
        this.life = life;
        this.damage = damage;
    }

    private int move;
    private int life;
    private int damage;

    public int getMove() {
        return move;
    }

    public int getLife() {
        return life;
    }

    public int getDamage() {
        return damage;
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
}
