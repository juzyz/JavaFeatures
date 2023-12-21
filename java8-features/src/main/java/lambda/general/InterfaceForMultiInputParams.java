package lambda.general;

@FunctionalInterface
interface Car {
    public String notify(String type, String brand);
}

class Ford implements Car {
    @Override
    public String notify(String type, String brand) {
        System.out.println("It is Ford with type " + type + " and brand " + brand);
        return ("Price is 50000$");
    }
}

class Kia implements Car {
    @Override
    public String notify(String type, String brand) {
        System.out.println("It is Kia with type " + type + " and brand " + brand);
        return ("Price is 40000$");
    }
}


public class InterfaceForMultiInputParams {
    public void check() {
        Car ford = (type, brand) ->
        {
            System.out.println("It is Ford with type " + type + " and brand " + brand);
            return ("Price is 50000$");
        };
        System.out.println(ford.notify("sedan", "Focus"));  //Price is 50000$


        Car kia = (type, brand) -> {
            System.out.println("It is Kia with type " + type + " and brand " + brand);
            return ("Price is 40000$");
        };
        System.out.println(kia.notify("sedan", "Rio")); //Price is 40000$
    }


}
