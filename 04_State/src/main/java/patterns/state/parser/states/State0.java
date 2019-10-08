package patterns.state.parser.states;

public class State0 extends AbstractState {

    @Override
    public State onPeriod() {
        return State.S2;
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
        return State.S1;
    }


}
