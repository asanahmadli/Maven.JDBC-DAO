import java.util.List;

public class AppRunner {
    public static void main(String[] args) {
        Car car = new Car();
        DAOConcreate daoConcreate = new DAOConcreate();
        car = (Car) daoConcreate.findById(5);
        System.out.println(daoConcreate.toString());
        daoConcreate.findAll();
//        daoConcreate.update(car);
//        daoConcreate.create(car);
//        daoConcreate.delete(2);
    }
}
