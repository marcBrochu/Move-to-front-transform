import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MTFOmega {
    private static String encodedNumbers = "";
    private static ArrayList<Integer> charsToEncode;
    private static MoveToFront moveToFront;


    public static void main(String[] args)  throws IOException {
        String fileNameRead = args[0];
        moveToFront = new MoveToFront(65536);
        charsToEncode = new ArrayList<>();
        stockInArrayFromFile(fileNameRead);
        moveToFrontChars();
        writeLastByte();
    }


    private static void stockInArrayFromFile(String fileNameRead)  throws IOException{
        FileReader fr = new FileReader(fileNameRead);
        int i;
        while((i = fr.read())!= -1) {
            charsToEncode.add(i);
        }
        fr.close();
    }


    private static void moveToFrontChars() {
        ArrayList<Integer> encodedChars = moveToFront.encode(charsToEncode.toArray(new Integer[0]));
        for (Integer encodedChar : encodedChars) {
            encodeOmega(Integer.toBinaryString(encodedChar));
        }
    }


    private static void encodeOmega(String binaryNumber) {
        if(binaryNumber.length() != 1){
            encodeOmega(Integer.toBinaryString(binaryNumber.length()-1));
        }
        encodedNumbers += binaryNumber;
        writeByte();
    }


    private static void writeByte() {
        if (encodedNumbers.length() >= 8) {
            String bytes = encodedNumbers.substring(0,8);
            encodedNumbers = encodedNumbers.substring(8);
            for (int i = 0; i < bytes.length(); i++) {
                System.out.write(bytes.charAt(i));
            }
        }
    }


    private static void writeLastByte() {
        if (encodedNumbers.length() != 0) {
            encodedNumbers = String.format("%-8s", encodedNumbers).replace(' ', '0');
            writeByte();
        }
        System.out.flush();
    }
}
