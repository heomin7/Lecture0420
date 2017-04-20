package park;

import park.module.Park;
import park.service.ParkService;

import java.util.List;

/**
 * Created by danawacomputer on 2017-04-20.
 */
public class ParkMain {
    public static void main(String[] args){

        //csv file -> Park object List
        List<Park> parks = ParkService.csvConvertoPark("src\\Parks.csv");

        //sort state order by Insc
        List<Park> stateSort = ParkService.getStateSortedByInsc(parks);
        System.out.println("order INSC state: ");
        stateSort.forEach(p -> System.out.println(p));

        //remove not US country
        List<Park> onlyUS = ParkService.removeNotUS(parks);
        System.out.println("only US country: ");
        onlyUS.forEach(p -> System.out.println(p));

        //remove not park.alias
        List<Park> isAlias = ParkService.removeNotHaveAlias(parks);
        System.out.println("only have Alias: ");
        isAlias.forEach(p -> System.out.println(p));

    }
}
