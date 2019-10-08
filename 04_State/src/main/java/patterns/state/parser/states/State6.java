package patterns.state.parser.states;

public class State6 extends AbstractState {

    @Override
    public State onPeriod() {
        return State.ERROR;
    }

    @Override
    public State onExp() {
        return State.ERROR;
    }

    @Override
    public State onModifier() {
        return State.ERROR;
    }

    @Override
    public State onDigit() {
        return State.S6;
    }
}
