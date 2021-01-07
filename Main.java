import java.util.Scanner;
import java.util.StringTokenizer;

public class Main{
    static Scanner scanner;
    static CFG cfg;
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        cfg = new CFG();

        getCFG();
    }

    public static void getCFG() {
        getRules();
        isStartingVariable();
    }


    public static void getRules() {
        String leftSide, rightSide;
        leftSide = rightSide = "";
        System.out.println("Enter your rules and enter done when you are done.");
        while (true) {
            System.out.println("leftSide: ");
            leftSide = scanner.next();
            if (!leftSide.equals("done")) {
                System.out.println("rightSide: ");
                rightSide = scanner.next();
                saveRules(leftSide, rightSide);
            } else {
                break;
            }
        }
    }

    public static void saveRules(String leftSide , String rightSide){
        cfg.addVariable(leftSide.toCharArray()[0]);
        StringTokenizer st = new StringTokenizer(rightSide , "|");
        while(st.hasMoreTokens()){
            String right = st.nextToken();
            char[] chars = right.toCharArray();
            for(int i = 0; i < chars.length ; i++){
                if(Character.isLowerCase(chars[i]) || Character.isDigit(chars[i])){
                    cfg.addAlphabet(chars[i]);
                }else if(Character.isUpperCase(chars[i])){
                    cfg.addVariable(chars[i]);
                }
            }
            Rule rule = new Rule(leftSide, right);
            if (!cfg.addRule(rule)) {
                System.out.println("Already exist.");
            }
        }
    }

    public static void isStartingVariable() {
        String startingVariable;
        Character charVar;
        System.out.println("Enter the starting variable:");
        startingVariable = scanner.next();
        charVar = startingVariable.toCharArray()[0];
        cfg.isStartingVariable(charVar);
    }
}