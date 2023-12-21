package lambda.predicate;

import org.juzyz.common.Employee;
import java.util.ArrayList;
import java.util.function.Predicate;


/*  This class is created to show how to use lambda expression for Predicate objects.
 * Predicate interface contains 1 abstract method: test();
 *  */
public class PredicateUsage {

    public void check() {
        System.out.println("Example 1 and 2: simple usage");
        //Example 1: Simple usage
        Predicate<Integer> p = i -> (i > 10);
        System.out.println(p.test(20)); // true
        System.out.println(p.test(5)); // false

        //Example 2: check the length of given string is greater than 4 or not
        Predicate<String> ps = s -> (s.length() > 4);
        System.out.println(ps.test("welcome")); // true
        System.out.println(ps.test("xyz")); // false

        //Example 3: print array elements whose size is > 4 from array
        System.out.println("Example 3: print array elements whose size is > 4 from array");

        String[] names = {"David", "Scott", "Smith", "John", "Mary"};
        for (String name : names) {
            if (ps.test(name)) {
                System.out.println(name);  //David, Scott, Smith
            }
        }

        // Example 4: return name if sal > 50k and exp > 3y
        System.out.println("Example 4: return name if sal > 50k and exp > 3y");

        Employee emp = new Employee("John", 50000, 5);
        Predicate<Employee> pe = e -> (e.getSalary() > 50000 && e.getExperience() > 3);
        System.out.println(pe.test(emp)); // true


        //Example 5: calling predicate lambda expression for each item of an array
        ArrayList<Employee> al = new ArrayList<>();
        al.add(new Employee("John", 50000, 5));
        al.add(new Employee("David", 20000, 2));
        al.add(new Employee("Scott", 30000, 3));
        al.add(new Employee("Joe", 60000, 6));

        for (Employee e : al) {
            if (pe.test(e)) {
                System.out.println(e.getName() + " " + e.getSalary());  //Joe 60000
            }
        }

        //Example 6: Joining predicates 'and', 'or', 'negate'
        int[] a = {5, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65};
        Predicate<Integer> p1 = i -> i % 2 == 0;
        Predicate<Integer> p2 = i -> i > 50;

        //and
        System.out.println("Following are numbers EVEN and Greater than 50");
        for (int i : a) {
            if (p1.and(p2).test(i)) // if(p1.test(i) && p2.test(i))
            {
                System.out.println(i); //60
            }
        }

        //or
        System.out.println("Following are numbers even OR greater than 50");
        for (int i : a) {
            if (p1.or(p2).test(i)) // if(p1.test(i) || p2.test(i))
            {
                System.out.println(i); //20, 30, 40, 50, 55, 60, 65
            }
        }
        //negate
        System.out.println("Following are numbers odd only");
        for (int i : a) {
            if (p1.negate().test(i)) // if(!p1.test(i) )
            {
                System.out.println(i); //5, 15, 25, 35, 45, 55, 65
            }
        }
    }
}
