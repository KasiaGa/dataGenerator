import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Kasia on 2015-12-28.
 */
public class Generator {

    public ArrayList<String> readFile(String name) {
        try {
            Scanner s = new Scanner(new File(name));
            ArrayList<String> list = new ArrayList<>();
            while(s.hasNext()) {
                list.add(s.nextLine());
            }
            return list;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String select(ArrayList<String> list) {
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }
}
