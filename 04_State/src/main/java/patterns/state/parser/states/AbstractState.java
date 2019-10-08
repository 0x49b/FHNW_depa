package patterns.state.parser.states;

public class AbstractState implements State {

    @Override
    public State onDigit() {
        throw new IllegalStateException();
    }

    @Override
    public State onPeriod() {
        throw new IllegalStateException();
    }

    @Override
    public State onExp() {
        throw new IllegalStateException();
    }

    @Override
    public State onModifier() {
        throw new IllegalStateException();
    }
}
