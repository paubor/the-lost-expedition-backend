package lostexpedition.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import lostexpedition.control.Camp;

public class Game {

    private final Camp camp;
    private final List<AdventureCard> deckOfCards;
    private final GameTime time;
    private final Path path;
    private final List<AdventureCard> playerCards;
    private final GameState state;
    private UUID id;

    private Game(final String name, final int lengthOfPath, final int food, final int ammunition, final int healthPerExplorer) {
        id = UUID.randomUUID();
        this.camp = Camp.builder().food(3).ammunition(3).healthPerExplorer(3).build();
        this.deckOfCards = initDeckOfCards();
        time= GameTime.MORNING_HIKE;
        path = new Path(lengthOfPath);
        path.addCards(getRandomCards(2), time);


        playerCards = getRandomCards(6);
        state = new SetupMorningGameState(path);
    }

    private List<AdventureCard> initDeckOfCards() {
        List<AdventureCard> cards = new ArrayList<>();
        cards.addAll(Data.ADVENTURE_CARDS);
        Collections.shuffle(cards);
        return cards;
    }

    public static Game create(final String name, final int lengthOfPath, final int food, final int ammunition,
            final int healthPerExplorer) {
        return new Game(name, lengthOfPath, food, ammunition, healthPerExplorer);
    }

    protected List<AdventureCard> getRandomCards(final int number) {
        List<AdventureCard> cards = new ArrayList<>();
        if(0 <= number && number < deckOfCards.size()){
            for(int i = 0; i < number; i++){
                cards.add(deckOfCards.remove(i));
            }
        }
        return cards;
    }

    public UUID getID() {
        return id;
    }
}
