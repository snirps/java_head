package classes;

import java.util.ArrayList;

public class ShipsPortal {
    private ArrayList<String> localField;
    private String name;


    public void setLocalField(ArrayList<String> locFie) {
        this.localField = locFie;
    }
    public void setName(String name) {this.name = name;}


    public String check(String move) {
        String result = "miss";

        int index=localField.indexOf(move);

        if (index>=0){
            localField.remove(index);
            if (localField.isEmpty()){
                result="sunk";
            }else{
                result="hit";
            }
        }
        System.out.println(localField);
        return result;
    }



}
