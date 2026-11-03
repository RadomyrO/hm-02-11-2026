package part1_references;

// Part 1. References: assignments and arguments

// simple class for demo
class Car {
    String model;
    int speed;

    Car(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Car{model='" + model + "', speed=" + speed + "}";
    }
}

public class Part1References {

    public static void main(String[] args) {
        partAssignments();
        System.out.println();
        partArguments();
    }

    // Part 1.1 Assignments
    static void partAssignments() {
        System.out.println("=== Part 1.1 Assignments ===");

        // new object in heap, car1 keeps ref to it
        Car car1 = new Car("BMW", 200);

        // copy ref, not object! both point to same car
        Car car2 = car1;

        System.out.println("start:");
        System.out.println("car1 = " + car1);
        System.out.println("car2 = " + car2);

        // change via car1
        car1.speed = 250;
        System.out.println("after car1.speed = 250:");
        System.out.println("car1 = " + car1);
        System.out.println("car2 = " + car2); // car2 sees it too

        // change via car2
        car2.model = "Audi";
        System.out.println("after car2.model = \"Audi\":");
        System.out.println("car1 = " + car1); // car1 sees it too
        System.out.println("car2 = " + car2);

        // same object check
        System.out.println("car1 == car2 ? " + (car1 == car2));
    }

    // Part 1.2 Arguments
    static void partArguments() {
        System.out.println("=== Part 1.2 Arguments ===");

        Car myCar = new Car("Toyota", 180);
        System.out.println("before method: " + myCar);

        // pass ref copy into method
        tuneCar(myCar);

        // object changed outside too
        System.out.println("after method:  " + myCar);

        // reassign param inside method - no effect outside
        replaceCar(myCar);
        System.out.println("after replaceCar: " + myCar);
    }

    // param = copy of ref -> same object
    static void tuneCar(Car c) {
        c.speed += 50; // changes original obj
        c.model = c.model + " Tuned";
        System.out.println("inside method: " + c);
    }

    // new obj only for local var, original untouched
    static void replaceCar(Car c) {
        c = new Car("Lada", 100);
        System.out.println("inside replaceCar: " + c);
    }
}
