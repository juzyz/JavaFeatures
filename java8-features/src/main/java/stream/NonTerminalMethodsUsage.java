package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NonTerminalMethodsUsage {

    public void check(){

        //Example 1:Using distinct()
        System.out.println("Example 1:Using distinct()");
        List<String> vehicleList = Arrays.asList("bus", "car", "bycle", "bus", "car", "car", "bike");
        List<String> distinctVehicle = vehicleList.stream().distinct().collect(Collectors.toList());
        System.out.println(distinctVehicle); //[bus, car, bycle, bike]

        vehicleList.stream().distinct().forEach(System.out::println); //bus, car, bycle, bike

        //Example 2:Using limit()
        System.out.println("Example 2:Using limit()");
        List<String> limitedVehicleList = vehicleList.stream().limit(3).collect(Collectors.toList());
        System.out.println(limitedVehicleList); // [bus, car, bycle]
        vehicleList.stream().limit(3).forEach(System.out::println); //bus, car, bycle

        //Example 3:Using sorted()
        System.out.println("Example 8:Using sorted()");
        List<Integer> list1 = Arrays.asList(2,4,3,7,5,9);
        List<Integer> sortedList = list1.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedList); //[2, 3, 4, 5, 7, 9]  -- ascending order
        sortedList = list1.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(sortedList);  //[9, 7, 5, 4, 3, 2] -- descending order

        List<String> names = Arrays.asList("John", "Mary", "Kim", "David", "Smith");
        List<String> sortedList2 = names.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedList2); //[David, John, Kim, Mary, Smith]

        //Example 4:Concatenate streams
        System.out.println("Concatenate streams");

        List<String> animalList = Arrays.asList("Dog", "Cat", "Elephant");
        List<String> birdList = Arrays.asList("Peacock", "Parrot", "Crow");

        Stream<String> stream1 = animalList.stream();
        Stream<String> stream2 = birdList.stream();
        List<String> conList = Stream.concat(stream1, stream2).collect(Collectors.toList());
        System.out.println(conList); //[Dog, Cat, Elephant, Peacock, Parrot, Crow]

    }
}
