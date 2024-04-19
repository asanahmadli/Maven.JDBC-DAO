import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class AppRunner {

    public static void main(String[] args) {

        DAOConcreate daoConcreate = new DAOConcreate();
       Car car = (Car) daoConcreate.findById(5);
        System.out.println("findby "+car.toString(car));


        List<Car> cars = daoConcreate.findAll();
        Iterator iterator = cars.iterator();
        while (iterator.hasNext()){
            Car car1 = (Car) iterator.next();
            System.out.println(daoConcreate.toString(car1));
        }


        daoConcreate.create(new Car(6,"bmw","6","2020","white","666666"));
        Car car2 = (Car) daoConcreate.findById(6);
        System.out.println(daoConcreate.toString(car2));

        daoConcreate.delete(6);




//        boolean b = (boolean) car.update(new Car("bmw","m8","2020","white","22222"));
//        System.out.println(car.findById(2));
    }
}
