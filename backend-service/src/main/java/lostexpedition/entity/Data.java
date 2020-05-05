package lostexpedition.entity;

import static lostexpedition.entity.Data.Actions.DIE;
import static lostexpedition.entity.Data.Actions.GAIN_AMMUNITION;
import static lostexpedition.entity.Data.Actions.GAIN_CAMPING;
import static lostexpedition.entity.Data.Actions.GAIN_EXPEDITION;
import static lostexpedition.entity.Data.Actions.GAIN_FOOD;
import static lostexpedition.entity.Data.Actions.GAIN_HEALTH;
import static lostexpedition.entity.Data.Actions.GAIN_JUNGLE;
import static lostexpedition.entity.Data.Actions.GAIN_NAVIGATION;
import static lostexpedition.entity.Data.Actions.GAIN_PATH;
import static lostexpedition.entity.Data.Actions.REMOVE_PATH;
import static lostexpedition.entity.Data.Actions.SKIP_PATH;
import static lostexpedition.entity.Data.Actions.SPEND_AMMUNITION;
import static lostexpedition.entity.Data.Actions.SPEND_CAMPING;
import static lostexpedition.entity.Data.Actions.SPEND_FOOD;
import static lostexpedition.entity.Data.Actions.SPEND_HEALTH;
import static lostexpedition.entity.Data.Actions.SPEND_JUNGLE;
import static lostexpedition.entity.Data.Actions.SPEND_NAVIGATION;
import static lostexpedition.entity.Data.Actions.SWAP_PATH;

import java.util.ArrayList;
import java.util.List;

public class Data {

    public static class Actions {

        public static final Action GAIN_FOOD = Action.resource(Resource.FOOD).gain().enforced().build();
        public static final Action SPEND_FOOD = Action.resource(Resource.FOOD).spend().enforced().build();
        public static final Action GAIN_AMMUNITION = Action.resource(Resource.AMMUNITION).gain().enforced().build();
        public static final Action SPEND_AMMUNITION = Action.resource(Resource.AMMUNITION).spend().enforced().build();
        public static final Action GAIN_HEALTH = Action.resource(Resource.HEALTH).gain().enforced().build();
        public static final Action SPEND_HEALTH = Action.resource(Resource.HEALTH).spend().enforced().build();
        public static final Action GAIN_JUNGLE = Action.expertise(Expertise.JUNGLE).gain().enforced().build();
        public static final Action SPEND_JUNGLE = Action.expertise(Expertise.JUNGLE).spend().enforced().build();
        public static final Action GAIN_NAVIGATION = Action.expertise(Expertise.NAVIGATION).gain().enforced().build();
        public static final Action SPEND_NAVIGATION = Action.expertise(Expertise.NAVIGATION).spend().enforced().build();
        public static final Action GAIN_CAMPING = Action.expertise(Expertise.CAMPING).gain().enforced().build();
        public static final Action SPEND_CAMPING = Action.expertise(Expertise.CAMPING).spend().enforced().build();
        public static final Action SKIP_PATH = Action.game(GameSubjects.PATH).skip().enforced().build();
        public static final Action SWAP_PATH = Action.game(GameSubjects.PATH).swap().build();
        public static final Action REMOVE_PATH = Action.game(GameSubjects.PATH).spend().build();
        public static final Action GAIN_PATH = Action.game(GameSubjects.PATH).gain().enforced().build();
        public static final Action GAIN_EXPEDITION = Action.game(GameSubjects.EXPEDITION).gain().enforced().build();
        public static final Action DIE = Action.game(GameSubjects.EXPLORER).spend().enforced().build();
    }

    public static List<AdventureCard> ADVENTURE_CARDS = new ArrayList<>();
        static{
            ADVENTURE_CARDS.add(AdventureCard.builder(1, "abandoned camp!")
                    .choice(GAIN_NAVIGATION, GAIN_JUNGLE, GAIN_CAMPING)
                    .choice(GAIN_AMMUNITION, GAIN_AMMUNITION)
                    .build());
            ADVENTURE_CARDS.add(AdventureCard.builder(2, "xinguano")
                    .choice(GAIN_AMMUNITION, SPEND_CAMPING, SWAP_PATH)
                    .choice(GAIN_HEALTH, GAIN_HEALTH, GAIN_EXPEDITION)
                    .choice(DIE)
                    .build());
            ADVENTURE_CARDS.add(AdventureCard.builder(3, "kalapalos")
                    .choice(GAIN_FOOD)
                    .choice(SKIP_PATH)
                    .choice(GAIN_NAVIGATION, GAIN_JUNGLE)
                    .build());
            ADVENTURE_CARDS.add(AdventureCard.builder(4, "clearing")
                    .option(SPEND_CAMPING, GAIN_FOOD, GAIN_FOOD)
                    .option(SPEND_CAMPING, GAIN_HEALTH)
                    .build());
            ADVENTURE_CARDS.add(AdventureCard.builder(21, "scorpion")
                    .events(GAIN_CAMPING, GAIN_PATH, SWAP_PATH).build());
            ADVENTURE_CARDS.add(AdventureCard.builder(46, "deserted outpost")
                    .events(GAIN_PATH)
                    .choice(SPEND_AMMUNITION, SPEND_AMMUNITION)
                    .choice(SPEND_HEALTH, SPEND_CAMPING)
                    .build());
            ADVENTURE_CARDS.add(AdventureCard.builder(35, "thunderstorm")
                    .events(SKIP_PATH, SKIP_PATH)
                    .choice(GAIN_HEALTH,
                    GAIN_CAMPING).build());
            ADVENTURE_CARDS.add(AdventureCard.builder(22, "xavante")
                    .choice(GAIN_FOOD,SPEND_CAMPING
                    )
                    .choice(
                    GAIN_NAVIGATION,
                    GAIN_EXPEDITION
            ).choice(DIE,GAIN_EXPEDITION
            ).build());
            ADVENTURE_CARDS.add(AdventureCard.builder(33, "injury")
                    .events(
                            GAIN_CAMPING,
                            GAIN_HEALTH,
                            GAIN_HEALTH).option(
                    GAIN_JUNGLE,
                    SPEND_FOOD,
                    SPEND_FOOD)
                    .build());

            ADVENTURE_CARDS.add(AdventureCard.builder(49, "tapirapé")
                    .choice(
                            GAIN_JUNGLE,
                            GAIN_EXPEDITION
                    ).choice(
                    GAIN_NAVIGATION,
                    SPEND_JUNGLE
            ).choice(
                    GAIN_JUNGLE,
                    SPEND_HEALTH
            ).build());
            ADVENTURE_CARDS.add(AdventureCard.builder(7, "thick fog")
                    .events(
                            GAIN_NAVIGATION,
                            SWAP_PATH,
                            SKIP_PATH
                    ).build());
            ADVENTURE_CARDS.add(AdventureCard.builder(18, "progress")
                    .choice(
                            GAIN_NAVIGATION,
                            GAIN_EXPEDITION)
                    .choice(
                            GAIN_NAVIGATION,
                            SPEND_FOOD,
                            SPEND_FOOD)
                    .choice(
                            SPEND_HEALTH
                    ).build());
            ADVENTURE_CARDS.add(AdventureCard.builder(17, "ambush")
                    .events(
                            SPEND_HEALTH,
                            GAIN_PATH,
                            SKIP_PATH
                    ).choice(
                    SPEND_HEALTH
            ).choice(
                    SPEND_JUNGLE,
                    SPEND_JUNGLE
            ).build());
            ADVENTURE_CARDS.add(AdventureCard.builder(13, "bakairí")
                    .choice(
                            SPEND_FOOD,
                            GAIN_CAMPING
                    ).choice(
                    SPEND_AMMUNITION,
                    SWAP_PATH
            ).choice(
                    SPEND_HEALTH,
                    SPEND_HEALTH
            ).build());
            ADVENTURE_CARDS.add(AdventureCard.builder(28, "infected wound")
                    .events(SPEND_HEALTH,
                            GAIN_CAMPING
                    ).choice(
                    SPEND_HEALTH
            ).choice(
                    SPEND_NAVIGATION
            ).build());
            ADVENTURE_CARDS.add(AdventureCard.builder(36, "insects")
                    .events(SPEND_NAVIGATION,
                            SKIP_PATH,
                            GAIN_NAVIGATION,
                            REMOVE_PATH).build());

            ADVENTURE_CARDS.add(AdventureCard.builder(50, "rope bridge")
                    .events(SWAP_PATH)
                    .choice(
                            SPEND_NAVIGATION,
                            GAIN_EXPEDITION
                    ).choice(
                    GAIN_EXPEDITION,
                    DIE
            ).choice(GAIN_PATH
            ).build());
            ADVENTURE_CARDS.add(AdventureCard.builder(41, "peccary!")
                    .events(
                            GAIN_NAVIGATION,
                            SKIP_PATH
                    ).choice(
                    SPEND_FOOD
            ).choice(
                    SPEND_NAVIGATION,
                    GAIN_FOOD,
                    GAIN_FOOD)
                    .choice(
                            SPEND_AMMUNITION,
                            GAIN_FOOD,
                            GAIN_FOOD
                    ).build());
            ADVENTURE_CARDS.add(AdventureCard.builder(30, "cougar")
                    .choice(
                            SPEND_AMMUNITION,
                            GAIN_NAVIGATION
                    ).choice(
                    SPEND_JUNGLE
            ).build());
            ADVENTURE_CARDS.add(AdventureCard.builder(42, "awa")
                    .choice(
                            GAIN_NAVIGATION
                    ).choice(
                    SPEND_FOOD,
                    GAIN_HEALTH
            ).choice(
                    SPEND_FOOD,
                    GAIN_EXPEDITION
            ).build());
            ADVENTURE_CARDS.add(AdventureCard.builder(27, "venomous spider")
                    .events(
                            SWAP_PATH
                    ).choice(
                    SPEND_CAMPING
            ).choice(
                    DIE
            ).build());
            ADVENTURE_CARDS.add(AdventureCard.builder(55, "spoiled supplies")
                    .events(SPEND_FOOD
                    ).build());
            ADVENTURE_CARDS.add(AdventureCard.builder(9, "vampire bats")
                    .events(GAIN_FOOD
                    ).choice(
                    SPEND_CAMPING
            ).choice(
                    SPEND_FOOD,
                    SPEND_FOOD
            ).build());
            ADVENTURE_CARDS.add(AdventureCard.builder(14, "amanayé")
                    .choice(
                            SPEND_HEALTH,
                            GAIN_NAVIGATION
                    ).choice(
                    SPEND_FOOD,
                    SPEND_FOOD,
                    GAIN_EXPEDITION
            ).choice(
                    SPEND_AMMUNITION,
                    SKIP_PATH,
                    SKIP_PATH
            ).choice(
                    DIE
            ).build());
            ADVENTURE_CARDS.add(AdventureCard.builder(29, "rapids")
                    .choice(
                            SPEND_FOOD,
                            GAIN_PATH,
                            GAIN_EXPEDITION
                    ).choice(
                    SPEND_FOOD,
                    SPEND_NAVIGATION,
                    GAIN_EXPEDITION
            ).option(
                    SPEND_JUNGLE,
                    SWAP_PATH,
                    SWAP_PATH
            ).build());
            ADVENTURE_CARDS.add(AdventureCard.builder(31, "hook worms")
                    .choice(
                            SPEND_CAMPING
                    ).choice(
                    SPEND_HEALTH
            ).choice(
                    SPEND_AMMUNITION
            ).build());
            ADVENTURE_CARDS.add(AdventureCard.builder(19, "steep path")
                    .choice(
                            SPEND_HEALTH,
                            SPEND_HEALTH,
                            SKIP_PATH,
                            GAIN_EXPEDITION
                    ).choice(
                    SPEND_FOOD,
                    GAIN_NAVIGATION
            ).build());
            ADVENTURE_CARDS.add(AdventureCard.builder(8, "footprints")
                    .choice(
                            SKIP_PATH,
                            GAIN_EXPEDITION
                    ).choice(
                    GAIN_FOOD,
                    GAIN_FOOD,
                    GAIN_FOOD
            ).build());
            ADVENTURE_CARDS.add(AdventureCard.builder(47, "kapok")
                    .events(SPEND_FOOD,
                            GAIN_CAMPING
                    ).option(
                    SPEND_NAVIGATION,
                    GAIN_HEALTH,
                    REMOVE_PATH
            ).build());
            ADVENTURE_CARDS.add(AdventureCard.builder(16, "poisonous frog")
                    .events(SPEND_HEALTH,
                            SKIP_PATH
                    ).option(SPEND_NAVIGATION,
                    GAIN_JUNGLE
            ).build());
            ADVENTURE_CARDS.add(AdventureCard.builder(56, "swamp")
                    .events(
                            GAIN_PATH
                    ).choice(SPEND_NAVIGATION
            ).choice(
                    SPEND_HEALTH,
                    SPEND_HEALTH
            ).build());
            ADVENTURE_CARDS.add(AdventureCard.builder(26, "pounding rain")
                    .events(SPEND_CAMPING,
                            SPEND_FOOD,
                            SWAP_PATH,
                            SKIP_PATH
                    ).build());
            ADVENTURE_CARDS.add(AdventureCard.builder(11, "old pathway")
                    .choice(
                            GAIN_EXPEDITION,
                            GAIN_PATH
                    ).choice(
                    GAIN_JUNGLE,
                    GAIN_CAMPING
            ).build());
            ADVENTURE_CARDS.add(AdventureCard.builder(54, "dehydration")
                    .choice(
                            SPEND_CAMPING,
                            SPEND_CAMPING
                    ).choice(
                    GAIN_PATH,
                    GAIN_PATH
            ).build());
            ADVENTURE_CARDS.add(AdventureCard.builder(32, "ruins")
                    .events(
                            SPEND_FOOD,
                            REMOVE_PATH,
                            REMOVE_PATH
                    ).option(
                    SPEND_HEALTH,
                    SPEND_NAVIGATION,
                    GAIN_EXPEDITION
            ).option(
                    SPEND_FOOD,
                    SPEND_CAMPING,
                    GAIN_EXPEDITION
            ).build());
            ADVENTURE_CARDS.add(AdventureCard.builder(39, "river crossing")
                    .events(
                            SKIP_PATH
                    )
                    .choice(
                            GAIN_NAVIGATION
                    ).choice(
                    SPEND_NAVIGATION,
                    GAIN_EXPEDITION
            ).choice(
                    GAIN_EXPEDITION,
                    SPEND_HEALTH
            ).build());
            ADVENTURE_CARDS.add(AdventureCard.builder(10, "healing herbs")
                    .events(
                            SKIP_PATH
                    ).option(
                    SPEND_JUNGLE,
                    GAIN_HEALTH,
                    GAIN_HEALTH,
                    GAIN_PATH
            ).build());

            ADVENTURE_CARDS.add(AdventureCard.builder(38, "faulty kit")
                    .events(
                            SWAP_PATH)
                    .choice(
                            SPEND_CAMPING
                    ).choice(SPEND_HEALTH
            ).choice(
                    SPEND_AMMUNITION
            ).build());
            ADVENTURE_CARDS.add(AdventureCard.builder(37, "electric eels")
                    .events(
                            GAIN_PATH
                    ).option(
                    SPEND_HEALTH,
                    GAIN_FOOD,
                    GAIN_FOOD
            ).build());
            ADVENTURE_CARDS.add(AdventureCard.builder(24, "ants")
                    .events(
                            SKIP_PATH,
                            SKIP_PATH
                    ).option(
                    SPEND_HEALTH,
                    GAIN_FOOD,
                    GAIN_FOOD
            ).build());
            ADVENTURE_CARDS.add(AdventureCard.builder(45, "nightshade")
                    .events(
                            SKIP_PATH
                    ).choice(
                    SPEND_FOOD
            ).choice(SPEND_JUNGLE
            ).build());
            ADVENTURE_CARDS.add(AdventureCard.builder(12, "anaconda")
                    .choice(
                            SPEND_AMMUNITION,
                            GAIN_FOOD
                    ).choice(
                    SPEND_AMMUNITION,
                    GAIN_NAVIGATION
            ).choice(
                    SPEND_HEALTH,
                    SPEND_HEALTH
            ).build());
            ADVENTURE_CARDS.add(AdventureCard.builder(51, "monkey")
                    .events(
                            SPEND_FOOD,
                            GAIN_NAVIGATION,
                            GAIN_JUNGLE
                    ).build());
            ADVENTURE_CARDS.add(AdventureCard.builder(34, "lost")
                    .choice(
                            GAIN_PATH,
                            GAIN_PATH,
                            GAIN_CAMPING,
                            SKIP_PATH
                    ).choice(SPEND_NAVIGATION,
                    SPEND_NAVIGATION,
                    GAIN_EXPEDITION
            ).build());
            ADVENTURE_CARDS.add(AdventureCard.builder(23, "swarm")
                    .choice(
                            SPEND_CAMPING
                    ).choice(
                    SPEND_HEALTH
            ).build());
            ADVENTURE_CARDS.add(AdventureCard.builder(43, "fever")
                    .events(
                            SPEND_HEALTH,
                            SWAP_PATH
                    )
                    .choice(
                            SPEND_HEALTH
                    ).choice(SPEND_CAMPING
            ).build());
            ADVENTURE_CARDS.add(AdventureCard.builder(20, "bushmaster")
                    .choice(
                            SPEND_AMMUNITION,
                            GAIN_FOOD
                    ).choice(SPEND_HEALTH,
                    SPEND_HEALTH
            ).build());

            ADVENTURE_CARDS.add(AdventureCard.builder(25, "crocodile")
                    .choice(
                            SPEND_AMMUNITION,
                            GAIN_FOOD,
                            GAIN_FOOD
                    ).choice(GAIN_PATH,
                    GAIN_PATH
            ).build());
            ADVENTURE_CARDS.add(AdventureCard.builder(53, "leeches")
                    .events(
                            SPEND_HEALTH,
                            SPEND_FOOD,
                            REMOVE_PATH
                    ).build());
            ADVENTURE_CARDS.add(AdventureCard.builder(52, "mudslide")
                    .events(
                            SPEND_HEALTH,
                            SPEND_FOOD,
                            SWAP_PATH
                    ).choice(
                    SPEND_HEALTH
            ).choice(
                    SPEND_CAMPING
            ).build());
            ADVENTURE_CARDS.add(AdventureCard.builder(44, "hi'aito'ihi")
                    .choice(
                            SPEND_AMMUNITION,
                            SPEND_HEALTH,
                            GAIN_EXPEDITION
                    ).choice(
                    DIE,
                    GAIN_EXPEDITION
            ).choice(
                    SPEND_HEALTH,
                    GAIN_NAVIGATION,
                    GAIN_CAMPING
            ).build());
            ADVENTURE_CARDS.add(AdventureCard.builder(48, "vantage point")
                    .events(
                            SPEND_HEALTH,
                            SWAP_PATH,
                            GAIN_JUNGLE
                    ).option(
                    SPEND_AMMUNITION,
                    GAIN_FOOD
            ).build());
            ADVENTURE_CARDS.add(AdventureCard.builder(6, "jaguar")
                    .choice(
                            SPEND_HEALTH,
                            SPEND_HEALTH,
                            SKIP_PATH)
                    .choice(
                            SPEND_AMMUNITION,
                            GAIN_JUNGLE
                    ).build());
            ADVENTURE_CARDS.add(AdventureCard.builder(40, "black panther")
                    .events(
                            GAIN_JUNGLE
                    )
                    .choice(
                            SPEND_AMMUNITION,
                            GAIN_FOOD
                    ).choice(
                    SPEND_FOOD,
                    SPEND_FOOD
            ).choice(
                    SPEND_HEALTH,
                    SPEND_HEALTH
            ).build());
            ADVENTURE_CARDS.add(AdventureCard.builder(15, "piranhas")
                    .choice(
                            SPEND_FOOD,
                            SPEND_FOOD,
                            GAIN_EXPEDITION
                    ).choice(GAIN_EXPEDITION,
                    SPEND_HEALTH
            ).build());
            ADVENTURE_CARDS.add(AdventureCard.builder(5, "the path ahead")
                    .events(
                            GAIN_PATH
                    ).option(
                    SPEND_NAVIGATION,
                    GAIN_EXPEDITION
            ).option(
                    SPEND_AMMUNITION,
                    GAIN_FOOD
            ).build());
        }
}