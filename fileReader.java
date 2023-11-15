import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadFile {

  public static void main(String args[]) throws IOException {
    FileInputStream in = null;

    try {
      // TODO: Figure out what the logfile name is and output to terminal
      in = new FileInputStream(logfile.csv)

      int c;
      while((c = in.read()) != -1) {
        System.out.println(c);
      }
    } finally {
      if (in != null) {
        in.close();
      }
    }
  }
}
