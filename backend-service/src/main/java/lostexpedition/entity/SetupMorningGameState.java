package lostexpedition.entity;

public class SetupMorningGameState extends GameState {

    public SetupMorningGameState(final Path path) {
        missingCards = 6-i;
    }

    @Override public GameState next() {
        return null;
    }
}
