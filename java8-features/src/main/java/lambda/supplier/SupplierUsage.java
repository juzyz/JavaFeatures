package lambda.supplier;

import org.juzyz.common.Employee;

import java.util.Date;
import java.util.function.Supplier;

public class SupplierUsage {
    public void check() {
        // Example 1: There is no input parameters but Data output parameter
        System.out.println("Example 3: applying a consumer chaining");
        Supplier s = () -> new Date();
        System.out.println(s.get());

        // Example 2: Generation objects
        System.out.println("Example 2: Generation objects");
        Supplier<Employee> studentGenerator = SupplierUsage::employeeMaker;

        for (int i = 0; i < 5; i++) {
            System.out.println("#" + i + ": " + studentGenerator.get());
//            #0: lambda.supplier.Employee@533ddba
//            #1: lambda.supplier.Employee@246b179d
//            #2: lambda.supplier.Employee@7a07c5b4
//            #3: lambda.supplier.Employee@26a1ab54
//            #4: lambda.supplier.Employee@3d646c37
        }
    }

    public static Employee employeeMaker() {
        return new Employee("A", 20000, 2);
    }
}

