package lostexpedition.boundary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import lostexpedition.control.Camp;
import lostexpedition.entity.AdventureCard;
import lostexpedition.entity.Data;
import lostexpedition.entity.Game;

/**
 * Handles games
 */
public class GameService {

    private Map<UUID, Game> games;

    private GameService(final int lengthOfPath, final int food, final int ammunition, final int health) {
        this.games = new HashMap<>();
    }

    public Game createGame(final String name, final int lengthOfPath, final int food, final int ammunition, final int healthPerExplorer){
        Game game = Game.create(name, lengthOfPath, food, ammunition, healthPerExplorer);
        games.put(game.getID(), game);
        return game;
    }



    /**
     * Starts the game
     *
     * @return 6 cards for the player
     */
    public static GameService create(){
        return new GameService(9, 3, 3, 3);
    }


}
