import classes.ShipsPortal;

import java.util.ArrayList;

public class ships_tester {
    public static void main(String[] args) {

        System.out.print("Test code\n");

        ShipsPortal wit = new ShipsPortal();

        ArrayList<String> localisation = new ArrayList<>();
        localisation.add("2");
        localisation.add("3");
        localisation.add("4");

        wit.setLocalField(localisation);

        String chooseField = "2";
        String results = wit.check(chooseField);


        String testResults = "test -> failure";

        if (results.equals("hit")) {
            testResults="test -> pass";
        }

        System.out.print(testResults);


    }
}
