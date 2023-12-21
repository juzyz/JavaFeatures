package lambda.general;

@FunctionalInterface
interface Pet {
    public void say();
}

/* There is no need to declare Cat and Dog classes
since say() method is implemented in lambda expression

class Cat implements Pet {
    public void say() {
        System.out.println("Meow");
    }
}

class Dog implements Pet {
    public void say() {
        System.out.println("Bark");
    }
}
*/

public class InterfaceUsageForZeroInputParams {

    public void check() {
//        Pet cat = new Cat();
//        cat.say(); // Meow
//        Pet dog = new Dog();
//        cat.say(); // Bark

        Pet cat = () -> System.out.println("Meow");
        cat.say(); // Meow
        Pet dog = () -> System.out.println("Bark");
        dog.say(); // Bark
    }
}
