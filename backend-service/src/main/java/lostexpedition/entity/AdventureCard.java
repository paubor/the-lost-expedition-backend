package lostexpedition.entity;

import java.util.ArrayList;
import java.util.List;

public class AdventureCard implements Comparable<AdventureCard>{
    private final int number;
    private final String name;
    private final List<Action> events;
    private final List<List<Action>> choices;
    private final List<List<Action>> options;

    private AdventureCard(final int number, final String name,
            final List<Action> events,
            final List<List<Action>> choices,
            final List<List<Action>> options) {
        this.number = number;
        this.name = name;
        this.events = events;
        this.choices = choices;
        this.options = options;
    }

    public static Builder builder(final int number, final String name){
        return new Builder().number(number).name(name);
    }

    @Override public int compareTo(final AdventureCard o) {
        return this.number - o.number;
    }

    static class Builder{
        private int number;
        private String name;
        private List<Action> events;
        private List<List<Action>> choices = new ArrayList<>();
        private List<List<Action>> options = new ArrayList<>();

        public Builder number(final int number) {
            this.number = number;
            return this;
        }

        public Builder name(final String name) {
            this.name = name;
            return this;
        }

        public Builder events(final Action... events){
            this.events = List.of(events);
            return this;
        }

        public Builder choice(final Action... choice){
            this.choices.add(List.of(choice));
            return this;
        }

        public Builder option(final Action... option){
            this.options.add(List.of(option));
            return this;
        }
        
        public AdventureCard build(){
            return new AdventureCard(number, name, events, choices, options);
        }
    }
}
