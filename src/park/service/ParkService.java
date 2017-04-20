package park.service;

import com.opencsv.CSVReader;
import park.module.Park;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by danawacomputer on 2017-04-20.
 */
public class ParkService {

    public static List<Park> csvConvertoPark(String filePath){

        CSVReader reader = null;
        List<Park> parks = new ArrayList<>();
        try {
            reader = new CSVReader(
                    new FileReader("src\\Parks.csv"));
            String[] parts = null;
            reader.readNext();


            while((parts = reader.readNext()) != null){
                parks.add(new Park(parts[0], parts[1],
                        parts[2], parts[3], parts[4], parts[5]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return parks;
    }

    public static List<Park> getStateSortedByInsc(List<Park> parks){

        List<Park> stateSort = new ArrayList<>();
        stateSort.addAll(parks);
        Collections.sort(stateSort,
                (c1, c2) -> c1.getState().compareTo(c2.getState()));

        return stateSort;
    }

    public static List<Park> removeNotUS(List<Park> parks){

        List<Park> onlyUS = new ArrayList<>();
        onlyUS.addAll(parks);
        onlyUS.removeIf(p -> !p.getCountry().equals("US"));

        return onlyUS;
    }

    public static List<Park> removeNotHaveAlias(List<Park> parks){

        List<Park> isAlias = new ArrayList<>();
        isAlias.addAll(parks);
        isAlias.removeIf(p -> p.getParkAlias().equals(""));
        return isAlias;
    }
}
