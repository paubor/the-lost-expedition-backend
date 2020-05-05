package lostexpedition.control;

public class Explorer {
    private int health;

    private Explorer(final int health) {
        this.health = health;
    }

    public static Explorer withHealth(final int health) {
        return new Explorer(health);
    }

    public int spendHealth(){
        if(health == 0){
            throw new RuntimeException("Player is already dead");
        }
        return --this.health;
    }

    public int gainHealth(){
        if(health == 0){
            throw new RuntimeException("Player is already dead");
        }
        return ++this.health;
    }

    public boolean isDead(){
        return this.health == 0;
    }
}
