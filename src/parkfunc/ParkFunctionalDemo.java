package parkfunc;

import park.module.Park;
import parkfunc.Service.ParkService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danawacomputer on 2017-04-20.
 */
public class ParkFunctionalDemo {
    public static void main(String[] args){
        //오전 수업용
        List<Park> list = ParkService.makeListFromCSV("Parks.csv");
        System.out.println(list);
        List<Park> temp = new ArrayList<>();
        temp.addAll(list);

//        //파크 이름 오름차순 정렬
//        Collections.sort(list, (x, y) ->
//                x.getParkName().length() - y.getParkName().length());
//        list.forEach(x -> System.out.println(x));
//
//        //국가가 US 아닌 것 필터링
//        list.removeIf(x -> !x.getCountry().equals("US"));
//        list.forEach(x -> System.out.println(x)); // list.forEach(System.out::println);
//        list.forEach(System.out::println);

        //리스트 총 개수
        System.out.println("list size: " + list.size());

        //스트림을 이용하여 변경
        list.stream().sorted((x, y) ->
                x.getParkName().length() - y.getParkName().length())
                .filter(x -> x.getCountry().equals("US")).forEach(x -> System.out.println(x));
        //filter는 거짓인것을 제거함.

        list.stream().forEach(x -> System.out.println(x));
        //중개 연산은 생략가능하나, 끝장연산은 꼭 와야함

        long us = list.stream().sorted((x, y) ->
                x.getParkName().length() - y.getParkName().length())
                .filter(x -> x.getCountry().equals("US")).count();
        System.out.println(us);

        List<Park> keys = new ArrayList<>();
        keys.addAll(temp);

        //park.key를 오름차순으로 정렬하고, city가 B로 시작하는 것만 필터링하여 출력
        keys.stream().sorted((x, y) ->
                x.getParkKey().compareTo(y.getParkKey())).
                filter(x -> !x.getCity().substring(0,1).equals("B")).forEach(x -> System.out.println(x));

        //맵핑 시키기: Alias의 값이 없으면 "없음"으로 데이터 입력하여 매핑하고 출력
        keys.stream().map(x -> {
            if(x.getParkAlias().equals("")) x.setParkAlias("없음");
            return x;
        }).forEach(x -> System.out.println(x));

        //city 글자를 모두 소문자로 변경
        keys.stream().map(x -> {
            x.setCity(x.getCity().toLowerCase());
            return x;
        }).forEach(x -> System.out.println(x));


        //city 앞 글자 3개만 표기 + state를 소문자로 변경해 매핑하고 출력
        keys.stream().map(x -> {
            x.setCity(x.getCity().substring(0,3));
            x.setState(x.getState().toLowerCase());
            return x;
        }).forEach(x -> System.out.println(x));

        //나라 en->ko 표기
        System.out.println("나라 표기 한글: ");
        keys.stream().map(x -> {
            switch (x.getCountry()) {
                case "US":
                    x.setCountry("미국");
                    break;
                case "MX":
                    x.setCountry("멕시코");
                    break;
                case "CA":
                    x.setCountry("캐나다");
                    break;
                case "PR":
                    x.setCountry("푸에투리코");
                    break;
                case "AU":
                    x.setCountry("오스트리아");
                    break;
                case "JP":
                    x.setCountry("일본");
                    break;
                default:
                    x.setCountry("기타등등");
                    break;
            }
            return x;
        }).forEach(System.out::println);



        //각 필드 문자열의 개수를 매핑하여 출력
        keys.stream().map(x -> {
            x.setParkKey(Integer.toString(x.getParkKey().length()));
            x.setParkName(Integer.toString(x.getParkName().length()));
            x.setParkAlias(Integer.toString(x.getParkAlias().length()));
            x.setCity(Integer.toString(x.getCity().length()));
            x.setCountry(Integer.toString(x.getCountry().length()));
            x.setState(Integer.toString(x.getState().length()));
            return x;
        }).forEach(x -> System.out.println(x));

    }
}
