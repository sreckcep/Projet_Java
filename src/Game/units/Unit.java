package Game.units;

public class Unit {
    public Unit(String name, int move, int life, int damage) {
        this.move = move;
        this.life = life;
        this.damage = damage;
    }

    public void fight(Unit unit) {
        String message = this.name + " subit une violente attaque, ";
        this.life -= this.damage;
        if (this.life < 0) {
            this.die();
        }
    }




    private int move;
    private int life;
    private int damage;

    private int name;

    public int getName() {
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

    public void setName(int name) {
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
}
