import classes.ShipsPortal;

public class ships_tester {
    public static void main(String[] args) {

        System.out.print("Here is the tester");

        ShipsPortal wit = new ShipsPortal();

        int [] localisation = {2,3,4,};
        wit.setLocalField(localisation);

        String chooseField = "2";
        String results = wit.check(chooseField);

        String testResults = "failure";

        if (results.equals("hit")){
            testResults="pass";
        }

        System.out.print(testResults);


    }
}
