package classes;

public class ShipsPortal {
    int[] localField;
    int countHit;

    public String check(String stringField) {
        int shot = Integer.parseInt(stringField);

        String result = "miss";

        for (int field:localField){
            if(shot==field){
                result="hit";
                countHit++;
            }
        }

        if (countHit==localField.length){
            result="sunk";
        }

        System.out.print(result+"\n");

        return result;
    }

    public void setLocalField(int[] localField) {
        this.localField = localField;
    }
}
