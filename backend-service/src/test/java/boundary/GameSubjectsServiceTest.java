package boundary;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.paulborek.lostexpedition.entity.Data;

class GameSubjectsServiceTest {

    private GameService sut;

    @BeforeEach
    void setUp() {
        sut = GameService.create();
    }

    @Test
    public void shuffleTest(){
        assertThat(sut.deckOfCards).hasSameSizeAs(Data.ADVENTURE_CARDS);

        assertThat(sut.getRandomCards(3)).as("first 3 cards").hasSize(3);
        assertThat(sut.deckOfCards).as("after taking 3 cards").hasSize(Data.ADVENTURE_CARDS.size()-3);

        assertThat(sut.getRandomCards(16)).as("16 more cards").hasSize(16);
        assertThat(sut.deckOfCards).as("after taking 19 cards").hasSize(Data.ADVENTURE_CARDS.size()-19);
    }
}