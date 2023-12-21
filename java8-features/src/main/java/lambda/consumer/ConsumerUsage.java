package lambda.consumer;

import org.juzyz.common.Employee;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/*  This class is created to show how to use lambda expression for Consumer objects.
 * Consumer interface contains 1 abstract method: accept();
 */

public class ConsumerUsage {

    public void check() {

        //Example 1: General usage
        System.out.println("Example 1: General usage");
        Consumer<String> cs = s -> System.out.println(s);
        cs.accept("Welcome");

        //Example 2: Apply a consumer for array items
        System.out.println("Example 2: display an employee with some bonus condition");
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("David", 50000, 4));
        employees.add(new Employee("John", 30000, 3));
        employees.add(new Employee("Mary", 20000, 1));

        //Function
        Function<Employee, Integer> f = emp -> (emp.getSalary() * 10) / 100;
        //Predicate
        Predicate<Integer> p = bonus -> bonus >= 5000;
        //Consumer
        Consumer<Employee> c =emp ->{
            System.out.println(emp.getName());
            System.out.println(emp.getSalary());
            System.out.println(emp.getExperience());
        };

        for(Employee emp: employees){
            int bonus = f.apply(emp);
            if(p.test(bonus)){
                c.accept(emp);
                System.out.println("Employee bonus is: " + bonus);
            }
        }

        //Example : Consumer chaining
        System.out.println("Example 3: applying a consumer chaining");

        Consumer<String> c1 = s -> System.out.println(s + " is white.");
        Consumer<String> c2 = s -> System.out.println(s + " has 4 legs.");
        Consumer<String> c3 = s -> System.out.println(s + " eats grass.");

        /* c1.accept("Cow");
        c2.accept("Cow");
        c3.accept("Cow"); */
        //or
//        c1.andThen(c2).andThen(c3).accept("Cow");
        //or
        Consumer<String> c4 = c1.andThen(c2).andThen(c3);
        c4.accept("Cow");
    }
}
