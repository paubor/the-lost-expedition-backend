package lostexpedition.entity;

import java.util.ArrayList;
import java.util.List;

public class Path {

    private final int length;
    private int player;
    private final List<AdventureCard> cards;

    public Path(final int lengthOfPath) {
        this.cards = new ArrayList<>();
        this.length = lengthOfPath-1;
        this.player = 0;
    }

    public void addCards(final List<AdventureCard> newCards, final GameTime time) {
        if(cards.size() + newCards.size() < length) {
            cards.addAll(newCards);
            if (GameTime.MORNING_HIKE.equals(time)) {
                cards.sort(AdventureCard::compareTo);
            }
        }
        //Trying to add too many cards.
    }

    public void advance(){
        player++;
    }

    public boolean didPlayerWin(){
        return player==length-1;
    }
}
