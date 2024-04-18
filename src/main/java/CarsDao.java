import java.util.List;
import java.util.Set;

public interface CarsDao {
    Cars getCar();
    List<Cars> getAllCars();
    Cars getCarByIDAndVin();
    boolean insertCar();
    boolean updateCar();
    boolean deleteCar();


}
