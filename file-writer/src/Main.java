import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        try {
            FileWriter writer = new FileWriter("poem.txt");
            writer.write("Roses are red \nViolets are blue \n");
            writer.append("(A poem by denizhan)");
            writer.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}