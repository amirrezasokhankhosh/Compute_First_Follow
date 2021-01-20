import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> productions = new ArrayList<String>();
        productions.add("E=TR");
        productions.add("R=+TR");
        productions.add("R=#");
        productions.add("T=FY");
        productions.add("Y=*FY");
        productions.add("Y=#");
        productions.add("F=(E)");
        productions.add("F=i");

        FirstAndFollow firstAndFollow = new FirstAndFollow(productions , 8);
        firstAndFollow.runAdjusmentOnProduction();
        ArrayList<Set> first = firstAndFollow.calculateFirst();
        ArrayList<Set> follow = firstAndFollow.calculateFollow();

        System.out.println("First :");
        for (Set s :
                first) {
            s.printSet();
        }
        System.out.println("Follow :");
        for (Set s :
                follow) {
            s.printSet();
        }
    }
}
