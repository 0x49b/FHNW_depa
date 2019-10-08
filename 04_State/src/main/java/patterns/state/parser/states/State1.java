package patterns.state.parser.states;

public class State1 extends AbstractState{

    @Override
    public State onPeriod() {
        return State.S3;
    }

    @Override
    public State onExp() {
        return State.S4;
    }

    @Override
    public State onModifier() {
        return State.ERROR;
    }

    @Override
    public State onDigit() {
        return State.S1;
    }
}
