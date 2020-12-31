import java.io.FileWriter;
import java.io.IOException;

public class EncodageUniversel {
    private static final String filename = "files/test.txt";
    private static FileWriter out;
    
    public static void main(String[] args) throws IOException {
        out = new FileWriter(filename,true);
        for (int i = 0; i < 16; i++) {
            encodeOmega(Integer.toBinaryString(i));
        }
        out.close();
    }

    private static void writeBits(String bits) throws IOException {
            out.write(bits);
    }

    private static void encodeOmega(String binaryNumber) throws IOException {
        if(binaryNumber.length() != 1){
            encodeOmega(Integer.toBinaryString(binaryNumber.length()-1));
        }
        writeBits(binaryNumber);
    }

}
