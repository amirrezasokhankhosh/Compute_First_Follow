import java.util.ArrayList;

public class CFG {
    private static ArrayList<Character> variables = new ArrayList<Character>();
    private static ArrayList<Character> alphabets = new ArrayList<Character>();
    private static ArrayList<Rule> rules = new ArrayList<Rule>();
    private Character StartingVariable;

    public static boolean addVariable(Character theVariable) {
        if (!variables.contains(theVariable)) {
            variables.add(theVariable);
            return true;
        }
        return false;
    }

    public static boolean addAlphabet(Character theAlphabet) {
        if (!alphabets.contains(theAlphabet)) {
            alphabets.add(theAlphabet);
            return true;
        }
        return false;
    }

    public static boolean addRule(Rule theRule) {
        if (!rules.contains(theRule)) {
            rules.add(theRule);
            return true;
        }
        return false;
    }

    public void isStartingVariable(Character theStartingVariable) {
        this.StartingVariable = theStartingVariable;
    }

    public static ArrayList<Rule> getRules() {
        ArrayList<Rule> returningRules = new ArrayList<Rule>();
        for (Rule rule : rules) {
            returningRules.add(rule);
        }
        return returningRules;
    }

    public static ArrayList<Character> getAlphabet() {
        ArrayList<Character> returningAlphabet = new ArrayList<Character>();
        for (Character symbol : alphabets) {
            returningAlphabet.add(symbol);
        }
        return returningAlphabet;
    }

    public static ArrayList<Character> getVariables() {
        ArrayList<Character> returningVariables = new ArrayList<Character>();
        for (Character variable : variables) {
            returningVariables.add(variable);
        }
        return returningVariables;
    }
}