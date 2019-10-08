package patterns.state.parser.states;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FloatParserState {

    private final State S0 = new State0();
    private final State S1 = new State1();
    private final State S2 = new State2();
    private final State S3 = new State3();
    private final State S4 = new State4();
    private final State S5 = new State5();
    private final State S6 = new State6();
    private final State SERROR = new StateError();

    private State currentState = S0;


    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String s = r.readLine();

        while (s != null && s.length() > 0) {
            try {
                double d = parse(s);
                System.out.println(d);
            } catch (IllegalArgumentException e) {
                System.out.println("Illegal Format");
            }
            s = r.readLine();
        }
    }

    double parse(String str) {
        double m = 0, quo = 10;
        int exp = 0, exp_sign = 1;
        int pos = 0;

        while ( !(currentState instanceof SERROR) && pos < str.length()) {
            char ch = str.charAt(pos++);

            if (ch == '.') {
                currentState.onPeriod();
            } else if (Character.toLowerCase(ch) == 'e') {
                currentState.onExp();
            } else if (ch == '-' | ch == '+') {
                currentState.onModifier();
            } else if (isDigit(ch)) {
                currentState.onDigit();
            } else {
                throw new IllegalStateException();
            }

        }

        if (currentState instanceof S3 || currentState instanceof S6) {
            return m * Math.pow(10, exp_sign * exp);
        } else {
            throw new IllegalArgumentException();
        }

    }

    public static boolean isDigit(char ch) {
        return Character.isDigit(ch);
    }
}
