package stream;

import org.juzyz.common.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapUsage {

    public void check() {
        //Example 1: Simple usage
        List<String> vehicle = Arrays.asList("bus", "car", "bicycle", "plane", "train");
        List<String> vehicleListInUpperCase = new ArrayList<String>();
        vehicleListInUpperCase = vehicle.stream().map(name -> name.toUpperCase()).collect(Collectors.toList());
        System.out.println(vehicleListInUpperCase);

        //Example 2: Creating an array with new data type based on original array
        System.out.println("Example 2: Creating an array with new data type based on original array");
        vehicle.stream().map(name -> name.length()).forEach(System.out::println);

        //Example 3: Creating an array based on original array
        System.out.println("Example 3: Creating an array based on original array");
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5);
        List<Integer> multipliedList = numbers.stream().map(n -> n * 3).collect(Collectors.toList());
        System.out.println(multipliedList);

        //Example 4: Using filter and map
        //Collection -->stream -> filter --> map --> collect
        System.out.println("Example 4: Using filter and map");
        List<Employee> employees = Arrays.asList(
                new Employee("Alex", 10000, 1),
                new Employee("Brain", 20000, 1),
                new Employee("Charles", 30000, 4),
                new Employee("David", 40000, 4),
                new Employee("Edward", 50000, 5)
        );

        List<Integer> results = employees.stream()
                .filter(emp -> emp.getSalary() > 20000)
                .map(emp -> emp.getSalary())
                .collect(Collectors.toList());
        System.out.println(results);


        //Example 5: Simple using flatMap()
        System.out.println("Example 5: simple using flatMap()");
        List<Integer> list1 = Arrays.asList(1, 2);
        List<Integer> list2 = Arrays.asList(3, 4);
        List<Integer> list3 = Arrays.asList(5, 6);

        List<List<Integer>> listOfLists = Arrays.asList(list1, list2, list3);
        List<Integer> resultList = listOfLists.stream()
                .flatMap(x -> x.stream().map(n -> n + 10))
                .collect(Collectors.toList());
        System.out.println(listOfLists); //[[1, 2], [3, 4], [5, 6]]
        System.out.println(resultList);  //[11, 12, 13, 14, 15, 16]


        //Example 6: Using flatMap() for String arrays
        System.out.println("Example 6: Using flatMap() for String arrays");
        List<String> teamA = Arrays.asList("Scoot", "David", "John");
        List<String> teamB = Arrays.asList("Mary", "Luna", "Tom");
        List<String> teamC = Arrays.asList("Ken", "Jony", "Kitty");

        List<List<String>> playersInWorldCup = Arrays.asList(teamA, teamB, teamC);
        List<String> names = playersInWorldCup.stream().flatMap(team -> team.stream()).collect(Collectors.toList());
        System.out.println(names); //[Scoot, David, John, Mary, Luna, Tom, Ken, Jony, Kitty]

        //Example 7: Using flatMap() for objects arrays
        System.out.println("Example 7: Using flatMap() for objects arrays");
        List<Employee> emps1 = new ArrayList<>();
        emps1.add(new Employee("Alex", 10000, 1));
        emps1.add(new Employee("Brain", 20000, 1));
        emps1.add(new Employee("Charles", 30000, 4));

        List<Employee> emps2 = new ArrayList<>();
        emps2.add(new Employee("Scoot", 25000, 3));
        emps2.add(new Employee("David", 40000, 4));
        emps2.add(new Employee("Edward", 50000, 5));

        List<List<Employee>> empList = Arrays.asList(emps1, emps2);
        List<String> empNames = empList.stream()
                .flatMap(list -> list.stream()
                        .map(emp -> emp.getName()))
                .collect(Collectors.toList());
        System.out.println(empNames); //[Alex, Brain, Charles, Scoot, David, Edward]


        //Example 8: Using  flatMap() and filter()
        System.out.println("Example 8: Using flatMap() and filter()");
        String[][] array = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

        List<String> collect = Stream.of(array)     // Stream<String[]>
                .flatMap(Stream::of)                // Stream<String>
                .filter(x -> !"a".equals(x))        // filter out the a
                .collect(Collectors.toList());      // return a List
        collect.forEach(System.out::println);       // b, c, d, e, f

    }
}
