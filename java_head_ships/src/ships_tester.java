import classes.ShipsPortal;

public class ships_tester {
    public static void main(String[] args) {

        System.out.print("Here is the teste\n");

        ShipsPortal wit = new ShipsPortal();

        int [] localisation = {2,3,4,};
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
