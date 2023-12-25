package stream;

import org.juzyz.common.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterUsage {

    public void check() {

        //Example 1: Simple usage
        System.out.println("Example 1 and 2: simple usage");
        List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30);

        //without using stream
        /* for (int n : numbers) {
            if (n % 2 == 0)
                evenNumbers.add(n);
        }
        System.out.println(evenNumbers); */

        //with using stream
        List<Integer> evenNumbers = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println(evenNumbers);
        //predicate and consumer
        evenNumbers.stream().filter(n -> n % 2 == 0).forEach(n -> System.out.println(n));
        evenNumbers.stream().filter(n -> n % 2 == 0).forEach(System.out::println);

        //Example 2: Filtering strings
        List<String> names = Arrays.asList("Scott", "Santa", "John", "Joffery", "Sam");
        names.stream().filter(name -> name.length() > 4 && name.length() < 6).forEach(System.out::println);

        //Example 3: Filtering out null items from array
        System.out.println("Example 3: Filtering out null items from array");
        List<String> words = Arrays.asList("cup", null, "forest", "sky", "book", null, "theatre");
        List<String> results = words.stream().filter(w -> w != null).collect(Collectors.toList());
        System.out.println(results);

        //Example 4: Filtering objects
        System.out.println("Example 4: Filtering objects");
        List<Employee> empList = new ArrayList<Employee>();
        empList.add(new Employee("David", 50000, 5));
        empList.add(new Employee("John", 30000, 2));
        empList.add(new Employee("Mary", 20000, 4));
        empList.add(new Employee("Scott", 40000, 5));
        empList.add(new Employee("Sam", 10000, 1));

        empList.stream()
                .filter(emp -> emp.getSalary() > 35000) //filtering
                .forEach(emp -> System.out.println(emp.getName())); //iterating names
    }
}
