package stream;

import org.juzyz.common.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ParallelStream {


    public void check() {

        //Example 1: Processing int collection sequential and in parallel
        System.out.println("Example 1: Processing int collection sequential and in parallel");
        System.out.println("Normal...");
        IntStream range = IntStream.rangeClosed(1, 10);
        range.forEach(System.out::println);  // 1,2,3,4,5,6,7,8,9,10
        System.out.println("Parallel...");
        IntStream range2 = IntStream.rangeClosed(1, 10); //7,6,9,10,8,2,1,4,5,3
        range2.parallel().forEach(System.out::println); //7,6,9,10,8,2,1,4,5,3


        //Example 2: Processing object collection sequential and in parallel
        System.out.println("Example 2: Processing object collection sequential and in parallel");
        List<Employee> employeeList = Arrays.asList(
                new Employee("David", 50000, 5),
                new Employee("John", 30000, 2),
                new Employee("Mary", 20000, 4),
                new Employee("Alex", 10000, 1),
                new Employee("Brain", 20000, 1),
                new Employee("Charles", 30000, 4),
                new Employee("David", 40000, 4),
                new Employee("Edward", 50000, 5)
        );
        //using  stream() sequential
        employeeList.stream()
                .filter(emp -> emp.getExperience() > 2)
                .limit(3)
                .forEach(emp -> System.out.println(emp.getName() + " " + emp.getSalary()));

        //using  stream() in parallel
        employeeList.parallelStream()
                .filter(emp -> emp.getExperience() > 2)
                .limit(3)
                .forEach(emp -> System.out.println(emp.getName() + " " + emp.getSalary()));

        //convert stream()  ->  parallelStream()
        employeeList.stream().parallel()
                .filter(emp -> emp.getExperience() > 2)
                .limit(3)
                .forEach(emp -> System.out.println(emp.getName() + " " + emp.getSalary()));


    }
}
