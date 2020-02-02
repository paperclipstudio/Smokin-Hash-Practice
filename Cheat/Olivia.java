import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Olivia {
  public static void main(String[] args) throws IOException {
    String ans = "";
    for(int i=0; i < 350; i++) {
      ans += "1 " + i + "\n";
    }
    BufferedWriter writer = new BufferedWriter(new FileWriter("cheat.txt"));
    writer.write(ans);
    writer.close();
  }
}

