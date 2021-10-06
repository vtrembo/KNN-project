import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Reader {
    private final String _file;
    public Reader (String file) { _file = file;}

    public String[][] parse (String[][] arr) {
        Path pathToFile = Paths.get(_file);
        try (BufferedReader reader = Files.newBufferedReader(pathToFile)) {
            String line = reader.readLine();
            int i = 0;
            while (line != null) {
                String[] record = line.split(",");
                arr[i++] = record;
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
    }

    public int getAmountOfLines() {
        Path pathToFile = Paths.get(_file);
        int j = 0;
        try (BufferedReader reader = Files.newBufferedReader(pathToFile)) {
            String line = reader.readLine();
            while (line != null) {
                j++;
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return j;
    }
}
