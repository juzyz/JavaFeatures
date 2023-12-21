package lambda.function;

import org.juzyz.common.Employee;

import java.util.ArrayList;

import java.util.function.Function;
import java.util.function.Predicate;


/*  This class is created to show how to use lambda expression for Function objects.
 * Consumer interface contains 1 abstract method: apply();
 */

public class FunctionUsage {
    public void check() {

        //Example 1: General usage
        System.out.println("Example 1: General usage");
        Function<Integer, Integer> f = n -> n * n;

        System.out.println(f.apply(5)); //25
        System.out.println(f.apply(10));  //100
        System.out.println(f.apply(2)); //4

        //String --> length --> Int
        Function<String, Integer> fs = s -> s.length();

        System.out.println(fs.apply("Welcome")); //7
        System.out.println(fs.apply("Java Programming")); //16

        //Example 2: Apply function for array items
        System.out.println("Example 2: calculate bonus for employees of array");
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("David", 50000, 5));
        employees.add(new Employee("John", 30000, 2));
        employees.add(new Employee("Mary", 20000, 4));

        Function<Employee, Integer> fe = e -> {
            int sal = e.getSalary();
            if (sal >= 10000 && sal <= 20000)
                return (sal * 10 / 100);
            else if (sal > 20000 && sal <= 30000)
                return (sal * 20 / 100);
            else if (sal > 30000 && sal <= 40000)
                return (sal * 30 / 100);
            else
                return (sal * 40 / 100);
        };
        Predicate<Integer> p = b -> b > 5000;

        for (Employee e : employees) {
            int bonus = fe.apply(e);
            if (p.test(bonus)) {
                System.out.println(e.getName() + " " + e.getSalary());
                System.out.println("Bonus is: " + bonus);
            }
        }

        //Example 3: Apply multiple functions: andThen(), compose()
        System.out.println("Example 3: Apply multiple functions: andThen(), compose()");
        Function<Integer, Integer> f1 = n -> n * 2;
        Function<Integer, Integer> f2 = n -> n * n * n;

        System.out.println(f1.andThen(f2).apply(2)); // 4   64
        System.out.println(f1.compose(f2).apply(2)); // 8   16

        //Example 4: creating objects
        System.out.println("Example 4: creating objects");
        Function<String, Employee> emp = Employee::new;
        Employee e = emp.apply("Sam");

        System.out.println( String.format("The is an employee with name %s and salary %d",  e.getName() ,  e.getSalary()));
  }
}
