package salary;

import salary.module.Salary;
import salary.service.SalaryService;

import java.time.LocalDate;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;

/**
 * Created by danawacomputer on 2017-04-20.
 */
public class SalaryMain {
    public static void main(String[] args){
        List<Salary> salaries = SalaryService.csvConvertoSalary("Salaries.csv");

//        salaries.forEach(x -> System.out.println(x.getYearId()));
        OptionalDouble average = salaries.stream().filter(x ->
                x.getYearId().isAfter(LocalDate.of(1985,1,1)))
                .filter(x -> x.getYearId().isBefore(LocalDate.of(2000, 1,1 )))
                .mapToInt(x -> x.getSalary()).average();

        System.out.printf("%.0f\n", average.getAsDouble());
        System.out.println(average.getAsDouble());

        OptionalDouble allAverage = salaries.stream().mapToInt(x -> x.getSalary()).average();
        System.out.printf("%.0f\n", allAverage.getAsDouble());

        OptionalInt max = salaries.stream().mapToInt(x -> x.getSalary()).max();
        System.out.println(max.getAsInt());

        OptionalInt min = salaries.stream().mapToInt(x -> x.getSalary()).min();
        System.out.println(min.getAsInt());

        OptionalInt nlmax = salaries.stream().filter(x -> x.getLgId().
                equals("NL")).mapToInt(x -> x.getSalary()).max();
        System.out.println(nlmax.getAsInt());

        OptionalDouble nyyAverage = salaries.stream().filter(x -> x.getTeamId()
                .equals("NYY")).mapToInt(x -> x.getSalary()).average();
        System.out.printf("%.0f\n", nyyAverage.getAsDouble());

        OptionalDouble notTenAverage =
                salaries.stream().sorted((x, y) -> y.getSalary() - x.getSalary())
                        .limit(10).mapToInt(x -> x.getSalary()).average();
        System.out.printf("%.0f\n", notTenAverage.getAsDouble());



    }
}
