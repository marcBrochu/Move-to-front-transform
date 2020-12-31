import java.util.ArrayList;
import java.util.LinkedList;

public class MoveToFront {
    private LinkedList<Integer> listOfAllnumbers;
    private LinkedList<Integer> listOfAllNumbersOriginal;


    public MoveToFront(int maximun){
        this.listOfAllnumbers = new LinkedList<Integer>();
        this.listOfAllNumbersOriginal = new LinkedList<Integer>();
        for (int i = 0; i < maximun; i++) {
            this.listOfAllnumbers.add(i);
            this.listOfAllNumbersOriginal.add(i);
        }

    }
    private void resetNumbers(){
        this.listOfAllnumbers = this.listOfAllNumbersOriginal;
    }

    private void moveToFront(int numberToMove, int indexOfNumberToMove){
        this.listOfAllnumbers.remove(indexOfNumberToMove);
        this.listOfAllnumbers.addFirst(numberToMove);
    }

    public ArrayList<Integer> encode(Integer[] listToEncode){
        ArrayList<Integer> encodedResult = new ArrayList<>();
        for (int i = 0; i < listToEncode.length; i++) {
            int numberToMove = listToEncode[i];
            int indexOfNumberToMove = this.listOfAllnumbers.indexOf(numberToMove);
            encodedResult.add(indexOfNumberToMove);
            moveToFront(numberToMove, indexOfNumberToMove);
        }
        resetNumbers();
        return  encodedResult;
    }

    public ArrayList<Integer> decode(int[] listToDecode){
        ArrayList<Integer> decodedResult = new ArrayList<>();
        for (int i = 0; i < listToDecode.length; i++) {
            int numberToMove = this.listOfAllnumbers.get(listToDecode[i]);
            int indexOfNumberToMove = this.listOfAllnumbers.indexOf(numberToMove);
            decodedResult.add(numberToMove);
            moveToFront(numberToMove, indexOfNumberToMove);
        }
        resetNumbers();
        return decodedResult;
    }
}
