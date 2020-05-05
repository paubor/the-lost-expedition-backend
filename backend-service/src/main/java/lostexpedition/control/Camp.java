package lostexpedition.control;

import static lostexpedition.entity.Expertise.CAMPING;
import static lostexpedition.entity.Expertise.JUNGLE;
import static lostexpedition.entity.Expertise.NAVIGATION;

import java.util.List;
import java.util.Map;

import lostexpedition.entity.Action;
import lostexpedition.entity.AdventureCard;
import lostexpedition.entity.Expertise;
import lostexpedition.entity.Subject;

public class Camp {
    private int food;
    private int ammunition;

    private final Map<Expertise, Explorer> explorers;

    private final List<AdventureCard> saved;

    public Camp(final int food, final int ammunition, final int healthPerExplorer) {
        this.food = food;
        this.ammunition = ammunition;
        this.explorers =  Map.of(
            JUNGLE, Explorer.withHealth(healthPerExplorer),
            NAVIGATION, Explorer.withHealth(healthPerExplorer),
            CAMPING, Explorer.withHealth(healthPerExplorer)
        );
        this.saved = List.of();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private int food;
        private int ammunition;
        private int healthPerExplorer;

        public Builder food(final int food) {
            this.food = food;
            return this;
        }

        public Builder ammunition(final int ammunition) {
            this.ammunition = ammunition;
            return this;
        }

        public Builder healthPerExplorer(final int health) {
            this.healthPerExplorer = health;
            return this;
        }

        public Camp build() {
            return new Camp(this.food, this.ammunition, this.healthPerExplorer);
        }
    }

    public int spendHealth(Expertise expertise){
        return this.explorers.get(expertise).spendHealth();
    }

    public int gainHealth(Expertise expertise){
        return this.explorers.get(expertise).gainHealth();
    }

    public int spendFood(){
        return --this.food;
    }
    public int gainFood(){
        return ++this.food;
    }

    public int spendAmmo(){
        return --this.ammunition;
    }

}
