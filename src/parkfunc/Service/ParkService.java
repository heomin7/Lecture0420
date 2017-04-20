package parkfunc.Service;

import com.opencsv.CSVReader;
import park.module.Park;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by danawacomputer on 2017-04-20.
 */
public class ParkService {

    public static List<Park> makeListFromCSV(String filename){

        List<Park> list = new ArrayList<>();
        try {
            CSVReader reader = new CSVReader(new FileReader(filename));


            String[] spl = null;
            reader.readNext();
            while((spl = reader.readNext()) != null){
                list.add(new Park(spl[0], spl[1],
                        spl[2], spl[3], spl[4], spl[5]));
            }

        } catch (FileNotFoundException e) {
            System.out.println("파일이 없습니다.");
        } catch (IOException e) {
            e.printStackTrace(); //별도의 스레드로 동작을 함. 그래서 띄엄띄엄 나옴
        }
        return list;
    }
}
