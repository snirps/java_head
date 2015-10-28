package classes;

import java.util.ArrayList;

public class ShipsPortalMaxGame {
    private SupportedClass support = new SupportedClass();
    private ArrayList<ShipsPortal> listOfPortals = new ArrayList<ShipsPortal>();
    private int amountMoves= 0;

    public void preparedGame(){
        ShipsPortal first = new ShipsPortal();
        first.setName("Twoja_stara");

        ShipsPortal second = new ShipsPortal();
        second.setName("Bananowy_potwor");

        ShipsPortal third = new ShipsPortal();
        third.setName("In_your_face");

        listOfPortals.add(first);
        listOfPortals.add(second);
        listOfPortals.add(third);

        System.out.print("Your main goal is to sunk all ships: ");
        System.out.print("Twoja Stara, Bananowy potwor, In Your face\n");
        System.out.print("Let's do it. Try to use as few moves as you can ");

        //repeat for each element of array (locate ships on the net)
        for (ShipsPortal locatedPortal:listOfPortals){
            ArrayList<String> newLocation = support.locatesPortal(3);
            locatedPortal.setLocalField(newLocation);
        }
    }

    public void startGame(){
        //until array is not empty
        while (!listOfPortals.isEmpty()){
            String userMove = support.downloadInputData("Give Field\n"); //take user move
            checkUserMove(userMove); //call method: checkUserMove()
    }
        finishedGame();
    }

    public void checkUserMove(String move){
        amountMoves++;
        String result = "miss";

        for (ShipsPortal portalToCheck: listOfPortals){
            result = portalToCheck.check(move);
            if (result.equals("hit")){
                break;
            }
            if (result.equals("sunk")){
                listOfPortals.remove(portalToCheck);
                break;
            }

        }
        System.out.println(result);
    }

    public void finishedGame(){
        System.out.println("All portals sunks");
        if (amountMoves <= 18) {
            System.out.println("You did only "+amountMoves+" moves.");
            System.out.println("You win this game before max number of moves");
        } else {
            System.out.println("You were too slow. You did almost: "+amountMoves+" moves");
            System.out.println("You're sucks!!!!");
        }

    }



}
