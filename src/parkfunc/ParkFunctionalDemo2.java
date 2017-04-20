package parkfunc;

import park.module.Park;
import parkfunc.Service.ParkService;

import java.util.List;
import java.util.OptionalDouble;

/**
 * Created by danawacomputer on 2017-04-20.
 */
public class ParkFunctionalDemo2 {
    public static void main(String[] args){
        List<Park> list = ParkService.makeListFromCSV("Parks.cs");

        OptionalDouble nameCountAverage = list.stream()
                .mapToInt(x -> x.getParkName().length())
                .peek(System.out::println)
                .average();//average는 OptionalDouble을 리턴함

        if(nameCountAverage.isPresent()){
            System.out.println(nameCountAverage.getAsDouble());
        }
        else{
            System.out.println("값이 없어요");
        }

//        List<Park> resultList =
//                list.stream()
//                        .skip(10)
//                        .limit(10)
//                        .map(x -> {
//                            x.setCity(x.getCity().substring(0,3));
//                            x.setState(x.getState().toLowerCase());
//                            return x;
//                        })
//                        .peek(System.out::println)
//                        .

    }
}
