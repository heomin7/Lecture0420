package salary.service;

import com.opencsv.CSVReader;
import salary.module.Salary;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by danawacomputer on 2017-04-20.
 */
public class SalaryService {
    public static List<Salary> csvConvertoSalary(String filePath){

        CSVReader reader = null;
        List<Salary> salaries = new ArrayList<>();

        try {
            reader = new CSVReader(
                    new FileReader(filePath));
            String[] parts = null;
            reader.readNext();




            while((parts = reader.readNext()) != null){
                Integer a = Integer.parseInt(parts[0]);
                salaries.add(new Salary(LocalDate.of(Integer.parseInt(parts[0]), 1, 1), parts[1],
                        parts[2], parts[3], Integer.parseInt(parts[4])));

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return salaries;
    }
}
