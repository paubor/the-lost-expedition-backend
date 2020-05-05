package lostexpedition.entity;

import static lostexpedition.entity.Operation.GAIN;
import static lostexpedition.entity.Operation.SKIP;
import static lostexpedition.entity.Operation.SPEND;
import static lostexpedition.entity.Operation.SWAP;
import static java.lang.String.format;

public class Action {
    private final Subject subject;
    private final Operation operation;
    private final boolean enforced;

    protected Action(final Subject subject, final Operation operation, final boolean enforced) {
        this.subject = subject;
        this.operation = operation;
        this.enforced = enforced;
    }

    public Subject getSubject() {
        return subject;
    }

    public Operation getOperation() {
        return operation;
    }

    public boolean isEnforced() {
        return enforced;
    }

    public static Builder<Resource> resource(Resource subject){
        return new Builder<>(subject);
    }

    public static Builder<Expertise> expertise(Expertise expertise){
        return new Builder<>(expertise);
    }

    public static Builder<GameSubjects> game(GameSubjects gameSubjects){
        return new Builder<>(gameSubjects);
    }

    public static class Builder<T extends Subject>{
        private final T subject;
        private Operation operation;
        private boolean enforced = false;

        private Builder(final T subject) {
            this.subject = subject;
        }

        public Builder<T> gain(){
            this.operation = GAIN;
            return this;
        }
        public Builder<T> spend() {
            this.operation = SPEND;
            return this;
        }

        public Builder<T> skip() {
            this.operation = SKIP;
            return this;
        }

        public Builder<T> swap() {
            this.operation = SWAP;
            return this;
        }

        public Builder<T> enforced() {
            this.enforced = true;
            return this;
        }

        public Action build() {
            return new Action(subject, operation, enforced);
        }
    }
}
