package patterns.state.parser.states;

public interface State {

    void onDigit();
    void onPeriod();
    void onExp();
    void onModifier();

}
